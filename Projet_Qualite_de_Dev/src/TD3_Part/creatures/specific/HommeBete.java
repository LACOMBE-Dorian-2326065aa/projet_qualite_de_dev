package TD3_Part.creatures.specific;

import TD3_Part.creatures.*;
import TD3_Part.values.TypeSexe;

public class HommeBete extends Creature implements CreatureBestiale, HabitantDuTriage {

    public HommeBete(String nom, TypeSexe sexe, double poids, double taille, int age) {
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
