package everything.effectivejava.ch06;

import java.util.Map;
import java.util.EnumMap;

/**
 * Created by mcalancea on 2016-02-03.
 */
public enum Phase {
    SOLID, LIQUID, GAS, PLASMA,
    IONIZED_GAS;

    public enum Transition{
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID,GAS),
        CONDENSE(GAS,LIQUID),
        SUBLIME(SOLID,GAS),
        DEPOSIT(GAS,SOLID),
        IONIZATION(IONIZED_GAS,PLASMA),
        DEIONIZATION(PLASMA, IONIZED_GAS);

        private final Phase source;
        private final Phase destination;

        Transition(Phase src, Phase dst){
            this.source = src;
            this.destination = dst;
        }

        //Initialize the phase transition map
        private static final Map<Phase,Map<Phase, Transition>> fromMap = new EnumMap<Phase,Map<Phase,Transition>>(Phase.class);
        static{
            for(Phase p : Phase.values()){
                fromMap.put(p,new EnumMap<Phase,Transition>(Phase.class));
            }
            for(Transition t : Transition.values()) {
                fromMap.get(t.source).put(t.destination, t);
            }
        }

        private static final Map<Phase, Map<Phase,Transition>> toMap = new EnumMap<Phase,Map<Phase,Transition>>(Phase.class);
        static {
            for(Phase p : Phase.values()){
                toMap.put(p, new EnumMap<Phase,Transition>(Phase.class));
            }
            for(Transition t : Transition.values()) {
                toMap.get(t.destination).put(t.source, t);
            }
        }

        public static Transition from(Phase src, Phase dst) {
            return fromMap.get(src).get(dst);
        }

        public static Transition to(Phase dst, Phase src) {
            return toMap.get(dst).get(src);
        }

        public static void fromWithMessage(Phase src, Phase dst) {
            System.out.println(src + " from " + dst + ": " + Phase.Transition.from(src, dst));
        }

        public static void toWithMessage(Phase dst, Phase src) {
            System.out.println(dst + " to " + src + ": " + Phase.Transition.to(dst, src));
        }
    }


}
