package TD3_Part.creatures;

import TD3_Part.main.Simulation;

/**
 * L'interface MortVivant représente une créature qui peut se régénérer après la mort.
 */
public interface MortVivant {

    /**
     * Méthode par défaut pour gérer le trépas d'une créature mort-vivante.
     * La créature se régénère en augmentant son moral de 15 points.
     */
    default void trepasser() {
        if (this instanceof Creature creature) {
            creature.setMoral(creature.getMoral() + 15);
            Simulation.events += " - (🧬) " + creature.getNom() + " se régénère (#MortVivant) !\n";
        }
    }

}