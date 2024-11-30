package TD3_Part.creatures;

import TD3_Part.Simulation;

public interface MortVivant {

    default void trepasser() {
        if (this instanceof Creature creature) {
            creature.setMoral(creature.getMoral() + 15);
            Simulation.events += " - (🧬) " + creature.getNom() + " se regénère (#MortVivant) !\n";
//            System.out.println(creature.getNom() + " trépasse mais se regénère !");
        }
    }

}
