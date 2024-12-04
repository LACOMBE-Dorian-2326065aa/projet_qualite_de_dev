package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeSexe;

/**
 * La classe Reptilien représente une créature de type reptile.
 * Elle hérite de la classe Creature et implémente l'interface ClientVIPPrioritaire.
 * 
 * @param nom   Le nom du reptile.
 * @param sexe  Le sexe du reptile (TypeSexe).
 * @param poids Le poids du reptile en kilogrammes.
 * @param taille La taille du reptile en mètres.
 * @param age   L'âge du reptile en années.
 * 
 * La méthode attendre() est redéfinie pour utiliser l'implémentation par défaut de l'interface ClientVIPPrioritaire.
 */
public class Reptilien extends Creature implements ClientVIPPrioritaire {

    public Reptilien(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

}
