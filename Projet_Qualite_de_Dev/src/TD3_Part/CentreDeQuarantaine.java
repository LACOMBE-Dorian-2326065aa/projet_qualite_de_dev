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
            if (getCapaciteActuelle() < getCapaciteMax()) {
                getCreatures().add(creature);
                creature.setServiceMedical(this);
                setCapaciteMax(getCapaciteMax() + 1);
            } else {
                System.out.println("Capacité maximale atteinte pour le service médical.");
            }
        } else {
            System.out.println("Créature non contagieuse.");
        }
    }

}