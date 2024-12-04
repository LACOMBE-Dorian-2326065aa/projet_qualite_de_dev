package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.HabitantDuTriage;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

/**
 * La classe Zombie représente une créature spécifique qui est à la fois un mort-vivant et un habitant du triage.
 * Elle hérite de la classe Creature et implémente les interfaces MortVivant et HabitantDuTriage.
 * 
 * @param nom Le nom du zombie.
 * @param sexe Le sexe du zombie (TypeSexe).
 * @param poids Le poids du zombie.
 * @param taille La taille du zombie.
 * @param age L'âge du zombie.
 * 
 * @see Creature
 * @see MortVivant
 * @see HabitantDuTriage
 */
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

