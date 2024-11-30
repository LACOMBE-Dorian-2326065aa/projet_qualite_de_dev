package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.CreatureBestiale;
import TD3_Part.creatures.HabitantDuTriage;

public class Lycanthrope extends Creature implements CreatureBestiale, HabitantDuTriage {

    public Lycanthrope(String nom, String sexe, double poids, double taille, int age) {
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
