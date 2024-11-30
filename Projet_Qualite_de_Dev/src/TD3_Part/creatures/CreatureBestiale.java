package TD3_Part.creatures;

import TD3_Part.main.Simulation;

import java.util.Random;

public interface CreatureBestiale {

    Random random = new Random();

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
