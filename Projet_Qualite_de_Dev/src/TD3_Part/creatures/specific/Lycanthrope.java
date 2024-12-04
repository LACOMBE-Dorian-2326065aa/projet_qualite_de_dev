package TD3_Part.creatures.specific;

import TD3_Part.creatures.*;
import TD3_Part.values.TypeSexe;

/**
 * La classe Lycanthrope représente une créature spécifique qui hérite de la classe Creature
 * et implémente les interfaces CreatureBestiale et HabitantDuTriage.
 * 
 * @param nom   Le nom de la créature.
 * @param sexe  Le sexe de la créature.
 * @param poids Le poids de la créature.
 * @param taille La taille de la créature.
 * @param age   L'âge de la créature.
 * 
 * @see Creature
 * @see CreatureBestiale
 * @see HabitantDuTriage
 */
public class Lycanthrope extends Creature implements CreatureBestiale, HabitantDuTriage {

    public Lycanthrope(String nom, TypeSexe sexe, double poids, double taille, int age) {
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
