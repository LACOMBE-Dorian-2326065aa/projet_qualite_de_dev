package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeSexe;

/**
 * La classe Nain représente une créature spécifique qui hérite de la classe Creature
 * et implémente l'interface ClientVIPPrioritaire.
 * 
 * <p>Un Nain est caractérisé par un nom, un sexe, un poids, une taille et un âge.</p>
 * 
 * @param nom   Le nom du nain.
 * @param sexe  Le sexe du nain (TypeSexe).
 * @param poids Le poids du nain.
 * @param taille La taille du nain.
 * @param age   L'âge du nain.
 */
public class Nain extends Creature implements ClientVIPPrioritaire {

    public Nain(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

}
