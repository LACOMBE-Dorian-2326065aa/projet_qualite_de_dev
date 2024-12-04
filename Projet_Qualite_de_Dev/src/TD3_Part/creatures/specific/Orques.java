package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.CreatureBestiale;
import TD3_Part.creatures.HabitantDuTriage;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

/**
 * La classe Orques représente une créature spécifique qui hérite de la classe Creature
 * et implémente les interfaces CreatureBestiale et HabitantDuTriage.
 * 
 * @param nom   Le nom de l'orque.
 * @param sexe  Le sexe de l'orque (TypeSexe).
 * @param poids Le poids de l'orque.
 * @param taille La taille de l'orque.
 * @param age   L'âge de l'orque.
 * 
 * @see Creature
 * @see CreatureBestiale
 * @see HabitantDuTriage
 */
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
