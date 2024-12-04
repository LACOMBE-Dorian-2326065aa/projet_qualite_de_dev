package TD3_Part.creatures;

import TD3_Part.main.Simulation;

/**
 * L'interface HabitantDuTriage représente une créature qui habite dans le triage.
 * Elle fournit une méthode par défaut pour gérer l'attente.
 */
public interface HabitantDuTriage {

    /**
     * Méthode par défaut pour gérer l'attente d'un habitant du triage.
     * Met à jour le compteur d'attente de l'espèce et enregistre l'événement dans la simulation.
     */
    default void attendre() {
        Creature.compteurAttendreEspece.put(this.getClass(), Creature.compteurAttendreEspece.getOrDefault(this.getClass(), 0) + 1);
        if (this instanceof Creature creature) {
            if (Creature.compteurAttendreEspece.getOrDefault(this.getClass(), 0) <= 1) {
                Simulation.events += " - (💤) " + creature.getNom() + " : attend (Moral : " + creature.getMoral() + " → " + (creature.getMoral() - 1) + ").\n";
            } else {
                Simulation.events += " - (💤) " + creature.getNom() + " : attend patiemment #HabitantDuTriage.\n";
            }
        }
    }

}