package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.creatures.CreatureBestiale;
import TD3_Part.creatures.MortVivant;
import TD3_Part.values.TypeSexe;

/**
 * La classe Vampire représente une créature de type vampire qui hérite de la classe Creature
 * et implémente les interfaces MortVivant, ClientVIPPrioritaire et CreatureBestiale.
 * 
 * @param nom   Le nom du vampire.
 * @param sexe  Le sexe du vampire (TypeSexe).
 * @param poids Le poids du vampire.
 * @param taille La taille du vampire.
 * @param age   L'âge du vampire.
 * 
 * @see Creature
 * @see MortVivant
 * @see ClientVIPPrioritaire
 * @see CreatureBestiale
 */
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
