package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeSexe;

public class Reptilien extends Creature implements ClientVIPPrioritaire {

    public Reptilien(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

}
