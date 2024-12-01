package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.creatures.CreatureBestiale;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

public class Vampire extends Creature implements MortVivant, ClientVIPPrioritaire, CreatureBestiale {

    public Vampire(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

    @Override
    public void trepasser() {
        CreatureBestiale.super.trepasser();
        MortVivant.super.trepasser();
    }

}
