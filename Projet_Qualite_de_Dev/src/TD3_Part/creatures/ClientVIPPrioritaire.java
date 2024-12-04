package TD3_Part.creatures;

import TD3_Part.main.Simulation;

/**
 * Interface ClientVIPPrioritaire représentant un client VIP prioritaire.
 * 
 * <p>Cette interface fournit une méthode par défaut pour gérer l'attente d'une créature VIP prioritaire.
 * Lorsqu'une créature attend, son moral est réduit en fonction du nombre d'attentes consécutives.
 * Si le moral de la créature tombe à zéro ou en dessous, elle meurt.</p>
 * 
 * <p>La méthode par défaut <code>attendre</code> effectue les actions suivantes :</p>
 * <ul>
 *   <li>Incrémente le compteur d'attente pour l'espèce de la créature.</li>
 *   <li>Ajoute un événement d'attente à la simulation.</li>
 *   <li>Réduit le moral de la créature en fonction du nombre d'attentes consécutives.</li>
 *   <li>Fait hurler la créature.</li>
 *   <li>Si le moral de la créature est inférieur ou égal à zéro, ajoute un événement de mort à la simulation et incrémente le compteur de morts.</li>
 * </ul>
 * 
 * <p>Cette interface utilise les classes <code>Creature</code> et <code>Simulation</code> pour gérer les créatures et les événements de la simulation.</p>
 */
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
