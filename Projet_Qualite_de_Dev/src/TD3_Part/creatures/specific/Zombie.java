package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.HabitantDuTriage;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

public class Zombie extends Creature implements MortVivant, HabitantDuTriage {

    public Zombie(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        HabitantDuTriage.super.attendre();
    }

    @Override
    public void trepasser() {
        MortVivant.super.trepasser();
    }

}

