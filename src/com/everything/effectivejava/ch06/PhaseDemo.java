package com.everything.effectivejava.ch06;


/**
 * Created by mcalancea on 2016-02-03.
 */
public class PhaseDemo {

    public static void main(String[] args) {
        Phase.Transition.fromWithMessage(Phase.GAS, Phase.SOLID);
        Phase.Transition.toWithMessage(Phase.LIQUID, Phase.GAS);

        Phase.Transition.fromWithMessage(Phase.IONIZED_GAS, Phase.PLASMA);
        Phase.Transition.toWithMessage(Phase.PLASMA, Phase.IONIZED_GAS);
    }

}
