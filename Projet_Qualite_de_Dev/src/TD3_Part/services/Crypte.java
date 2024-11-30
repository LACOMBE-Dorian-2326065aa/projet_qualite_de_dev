package TD3_Part.services;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeBudget;

public class Crypte extends ServiceMedical {

    private int niveauVentilation;
    private float temperature;

    public Crypte(String nom, double superficie, int capaciteMax, TypeBudget budget) {
        super(nom, superficie, capaciteMax, budget);
    }

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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public int getNiveauVentilation() {
        return niveauVentilation;
    }

    public void setNiveauVentilation(int niveauVentilation) {
        this.niveauVentilation = niveauVentilation;
    }
}