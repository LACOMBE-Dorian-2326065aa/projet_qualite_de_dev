package TD3_Part.services;

import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeBudget;

/**
 * La classe CentreDeQuarantaine représente un service médical spécialisé dans la quarantaine des créatures malades.
 * Elle hérite de la classe ServiceMedical.
 * 
 * @param nom Le nom du centre de quarantaine.
 * @param superficie La superficie du centre de quarantaine.
 * @param capaciteMax La capacité maximale du centre de quarantaine.
 * @param budget Le type de budget alloué au centre de quarantaine.
 */
public class CentreDeQuarantaine extends ServiceMedical {

    /**
     * Constructeur de la classe CentreDeQuarantaine.
     * 
     * @param nom Le nom du centre de quarantaine.
     * @param superficie La superficie du centre de quarantaine.
     * @param capaciteMax La capacité maximale du centre de quarantaine.
     * @param budget Le type de budget alloué au centre de quarantaine.
     */
    public CentreDeQuarantaine(String nom, double superficie, int capaciteMax, TypeBudget budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    /**
     * Ajoute une créature au centre de quarantaine si elle est malade et si la capacité maximale n'est pas atteinte.
     * 
     * @param creature La créature à ajouter.
     * @return true si la créature a été ajoutée avec succès, false sinon.
     */
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