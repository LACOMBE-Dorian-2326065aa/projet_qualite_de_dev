package TD3_Part;

import TD3_Part.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class CentreDeQuarantaine extends ServiceMedical {

    public CentreDeQuarantaine(String nom, double superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public void ajouterCreature(Creature creature) {
        if (creature.getMaladies().size() > 0) {
            if (capaciteActuelle < capaciteMax) {
                creatures.add(creature);
                capaciteActuelle++;
            } else {
                System.out.println("Capacité maximale atteinte pour le service médical.");
            }
        } else {
            System.out.println("Créature non contagieuse.");
        }
    }

}