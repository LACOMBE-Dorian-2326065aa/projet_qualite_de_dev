package TD3_Part.creatures;

import TD3_Part.main.Simulation;

import java.util.Random;

/**
 * L'interface {@code CreatureBestiale} représente une catégorie de créatures ayant un comportement bestial.
 * Cette interface inclut des comportements spécifiques liés à la maladie et à la contamination lors de leur trépas.
 */
public interface CreatureBestiale {

    /**
     * Instance de {@link Random} utilisée pour générer des valeurs aléatoires dans les méthodes.
     */
    Random random = new Random();

    /**
     * Décrit le comportement d'une créature bestiale lorsqu'elle décède.
     * Si la créature possède une ou plusieurs maladies, elle contamine une autre créature aléatoire
     * dans son environnement médical avec une des maladies qu'elle porte.
     * <p>
     * Ce comportement est documenté dans les événements de la simulation.
     * </p>
     * 
     * <ul>
     * <li>Choisit une maladie aléatoire parmi celles que porte la créature.</li>
     * <li>Choisit une créature aléatoire à contaminer parmi celles disponibles dans le service médical.</li>
     * <li>Contamine la créature choisie avec la maladie sélectionnée.</li>
     * <li>Ajoute un événement descriptif à la simulation.</li>
     * </ul>
     * 
     * <p>Par exemple :</p>
     * <pre>
     *  - (☠️🦠) NomDeLaCréature (#CrétureBestiale) : contamine NomDeLaVictime (NomMaladie).
     * </pre>
     * 
     * @implNote Cette méthode s'applique uniquement si l'objet est une instance de {@link Creature}.
     */
    default void trepasser() {
        if (this instanceof Creature creature) {
            if (!creature.getMaladies().isEmpty()) {
                int randomIndexMaladie = random.nextInt(creature.getMaladies().size());
                Maladie maladie = creature.getMaladies().get(randomIndexMaladie);
                int randomIndexCreatureAContaminer = random.nextInt(creature.getServiceMedical().getCreatures().size());
                Creature creatureToContamine = creature.getServiceMedical().getCreatures().get(randomIndexCreatureAContaminer);

                creatureToContamine.tomberMalade(maladie);
                Simulation.events += " - (☠️🦠) " + creature.getNom() + " (#CrétureBestiale) : contamine " + creatureToContamine.getNom() + " (" + maladie.getNomAbrege() + ").\n";

//                System.out.println(creature.getNom() + " a contaminé " + creatureToContamine.getNom() + " (" + maladie.getNomComplet() + ") en trépassant !");
            }
        }
    }
}
