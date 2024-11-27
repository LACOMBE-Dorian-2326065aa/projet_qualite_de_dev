package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.HabitantDuTriage;
import TD3_Part.creatures.MortVivant;

public class Zombie extends Creature implements MortVivant, HabitantDuTriage {

    public Zombie(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        HabitantDuTriage.super.attendre();
    }

}

