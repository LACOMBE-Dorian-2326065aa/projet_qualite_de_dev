package TD3_Part.creatures;

import TD3_Part.Simulation;

import java.util.HashMap;

public interface HabitantDuTriage {

    default void attendre() {
        Creature.compteurAttendreEspece.put(this.getClass(), Creature.compteurAttendreEspece.getOrDefault(this.getClass(), 0) + 1);
        if (this instanceof Creature creature) {
            if (Creature.compteurAttendreEspece.getOrDefault(this.getClass(), 0) <= 1) {
                Simulation.events += " - (💤) " + creature.getNom() + " : attend (Moral : " + creature.getMoral() + " → " + (creature.getMoral() - 1)+").\n";
            } else {
                Simulation.events += " - (💤) " + creature.getNom() + " : attend patiemment #HabitantDuTriage.\n";
            }
        }
    }

}
