package everything.effectivejava.ch06;

import java.util.Map;
import java.util.EnumMap;

/**
 * Created by mcalancea on 2016-02-03.
 */
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition{
        MELT(SOLID, LIQUID),
        FREEZE(LIQUID, SOLID),
        BOIL(LIQUID,GAS),
        CONDENSE(GAS,LIQUID),
        SUBLIME(SOLID,GAS),
        DEPOSIT(GAS,SOLID);

        private final Phase source;
        private final Phase destination;

        Transition(Phase src, Phase dst){
            this.source = src;
            this.destination = dst;
        }

        //Initialize the phase transition map
        private static final Map<Phase,Map<Phase, Transition>> m = new EnumMap<Phase,Map<Phase,Transition>>(Phase.class);
        static{
            for(Phase p : Phase.values()){
                m.put(p,new EnumMap<Phase,Transition>(Phase.class));
            }
            for(Transition t : Transition.values()) {
                m.get(t.source).put(t.destination, t);
            }
        }

        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }


}
