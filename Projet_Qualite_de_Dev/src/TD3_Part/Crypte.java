package TD3_Part;

import TD3_Part.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class Crypte extends ServiceMedical {

    private int niveauVentilation;
    private float temperature;

    public Crypte(String nom, double superficie, int capaciteMax, String budget) {
        super(nom, superficie, capaciteMax, budget);
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