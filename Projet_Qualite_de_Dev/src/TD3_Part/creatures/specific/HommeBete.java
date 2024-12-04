package TD3_Part.creatures.specific;

import TD3_Part.creatures.*;
import TD3_Part.values.TypeSexe;

/**
 * La classe HommeBete représente une créature spécifique qui hérite de la classe Creature
 * et implémente les interfaces CreatureBestiale et HabitantDuTriage.
 * 
 * <p>Cette classe modélise un Homme-Bête avec des attributs tels que le nom, le sexe, 
 * le poids, la taille et l'âge. Elle fournit également des implémentations spécifiques 
 * des méthodes attendre et trepasser des interfaces implémentées.</p>
 * 
 * @param nom Le nom de l'Homme-Bête.
 * @param sexe Le sexe de l'Homme-Bête (TypeSexe).
 * @param poids Le poids de l'Homme-Bête.
 * @param taille La taille de l'Homme-Bête.
 * @param age L'âge de l'Homme-Bête.
 */
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
