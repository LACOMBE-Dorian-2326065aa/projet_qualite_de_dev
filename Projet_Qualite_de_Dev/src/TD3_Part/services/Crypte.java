package TD3_Part.services;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeBudget;

/**
 * La classe Crypte représente un service médical spécialisé pour les créatures de type MortVivant.
 * Elle hérite de la classe ServiceMedical.
 */
public class Crypte extends ServiceMedical {

    private int niveauVentilation;
    private float temperature;

    /**
     * Constructeur de la classe Crypte.
     *
     * @param nom Le nom du service médical.
     * @param superficie La superficie du service médical.
     * @param capaciteMax La capacité maximale du service médical.
     * @param budget Le type de budget du service médical.
     */
    public Crypte(String nom, double superficie, int capaciteMax, TypeBudget budget) {
        super(nom, superficie, capaciteMax, budget);
    }

    /**
     * Ajoute une créature au service médical si elle est de type MortVivant et si la capacité maximale n'est pas atteinte.
     *
     * @param creature La créature à ajouter.
     * @return true si la créature a été ajoutée avec succès, false sinon.
     */
    @Override
    public boolean ajouterCreature(Creature creature) {
        if (creature instanceof MortVivant) {
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
            System.out.println("[⛔] Créature non régénérante.");
            return false;
        }
    }

    /**
     * Obtient la température actuelle de la crypte.
     *
     * @return La température actuelle.
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Définit la température de la crypte.
     *
     * @param temperature La nouvelle température.
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    /**
     * Obtient le niveau de ventilation actuel de la crypte.
     *
     * @return Le niveau de ventilation actuel.
     */
    public int getNiveauVentilation() {
        return niveauVentilation;
    }

    /**
     * Définit le niveau de ventilation de la crypte.
     *
     * @param niveauVentilation Le nouveau niveau de ventilation.
     */
    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }
}