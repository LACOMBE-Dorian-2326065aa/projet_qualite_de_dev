package TD3_Part.creatures;

import TD3_Part.main.Simulation;

public interface ClientVIPPrioritaire {

    default void attendre() {
        if (this instanceof Creature creature) {
            Creature.compteurAttendreEspece.put(this.getClass(), Creature.compteurAttendreEspece.getOrDefault(this.getClass(), 0) + 1);
            Simulation.events += " - (💤) " + creature.getNom() + " : attend (Moral : " + creature.getMoral() + " → " + (creature.getMoral() - creature.getCompteurAttendre()) + " #ClientVIPPrioritaire (" + creature.getCompteurAttendre() + " attentes d'affilée)).\n";
            creature.setMoral(creature.getMoral() - creature.getCompteurAttendre());
            creature.hurler();
            if (creature.getMoral() <= 0) {
                Simulation.events += " - (☠️) " + creature.getNom() + " : mort.\n";
                Simulation.morts++;
                creature.trepasser();
            }
        }
    }

}
