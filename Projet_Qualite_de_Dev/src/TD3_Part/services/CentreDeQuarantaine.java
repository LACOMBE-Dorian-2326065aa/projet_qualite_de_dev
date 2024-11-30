package TD3_Part.services;

import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeBudget;

public class CentreDeQuarantaine extends ServiceMedical {

    public CentreDeQuarantaine(String nom, double superficie, int capaciteMax, TypeBudget budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    @Override
    public boolean ajouterCreature(Creature creature) {
        if (creature.getMaladies().size() > 0) {
            if (getCapaciteActuelle() < getCapaciteMax()) {
                getCreatures().add(creature);
                creature.setServiceMedical(this);
                setCapaciteMax(getCapaciteMax() + 1);
                return true;
            } else {
                System.out.println("[⛔] Capacité maximale atteinte pour le service médical.");
                return false;
            }
        } else {
            System.out.println("[⛔] Créature non contagieuse.");
            return false;
        }
    }

}