package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;

public class Elfe extends Creature implements ClientVIPPrioritaire {

    public Elfe(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void demoraliserAutresCreatures() {
        for (Creature creature : getServiceMedical().getCreatures()) {
            if (Math.random() <= 0.5) {
                creature.setMoral(creature.getMoral() - 1);
                System.out.println(getNom() + " a démoralisé " + creature.getNom() + " en trépassant !");
            }
        }
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

    @Override
    public void trepasser() {
        if (getMaladies().size() >= 5) {
            System.out.println("L'elfe " + getNom() + " a trépassé !");
            demoraliserAutresCreatures();
        }
    }

}
