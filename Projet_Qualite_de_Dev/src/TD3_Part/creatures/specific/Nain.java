package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;

public class Nain extends Creature implements ClientVIPPrioritaire {

    public Nain(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

}
