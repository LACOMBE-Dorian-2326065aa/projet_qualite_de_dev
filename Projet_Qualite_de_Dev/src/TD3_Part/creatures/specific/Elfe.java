package TD3_Part.creatures.specific;

import TD3_Part.creatures.ClientVIPPrioritaire;
import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeSexe;

/**
 * La classe Elfe représente une créature de type Elfe qui hérite de la classe Creature
 * et implémente l'interface ClientVIPPrioritaire.
 * 
 * <p>Un Elfe a la capacité de démoraliser d'autres créatures lorsqu'il trépassé.</p>
 * 
 * @param nom Le nom de l'Elfe.
 * @param sexe Le sexe de l'Elfe.
 * @param poids Le poids de l'Elfe.
 * @param taille La taille de l'Elfe.
 * @param age L'âge de l'Elfe.
 */
public class Elfe extends Creature implements ClientVIPPrioritaire {

    public Elfe(String nom, TypeSexe sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void demoraliserAutresCreatures() {
        for (Creature creature : getServiceMedical().getCreatures()) {
            if (Math.random() <= 0.5) {
                creature.setMoral(creature.getMoral() - 1);
                System.out.println(getNom() + " a démoralisé " + creature.getNom() + " en trépassant !");
            }
        }
    }

    @Override
    public void attendre() {
        ClientVIPPrioritaire.super.attendre();
    }

    @Override
    public void trepasser() {
        if (getMaladies().size() >= 5) {
            System.out.println("L'elfe " + getNom() + " a trépassé !");
            demoraliserAutresCreatures();
        }
    }

}
