package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.CreatureBestiale;
import TD3_Part.creatures.HabitantDuTriage;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

public class Orques extends Creature implements CreatureBestiale, HabitantDuTriage {

    public Orques(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        HabitantDuTriage.super.attendre();
    }

    @Override
    public void trepasser() {
        CreatureBestiale.super.trepasser();
    }

}
