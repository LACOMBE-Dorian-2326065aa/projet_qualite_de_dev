package TD4.lycanthropes;

import TD3_Part.values.TypeSexe;
import TD4.values.TypeRangDomination;
import java.util.Random;

/**
 * La classe Couple représente un couple de lycanthropes composé d'un mâle et d'une femelle.
 */
public class Couple {

    /**
     * Le lycanthrope mâle du couple.
     */
    private Lycanthrope2 male;

    /**
     * Le lycanthrope femelle du couple.
     */
    private Lycanthrope2 female;

    /**
     * Constructeur de la classe Couple.
     * 
     * @param male Le lycanthrope mâle.
     * @param female Le lycanthrope femelle.
     * @throws IllegalArgumentException si les deux lycanthropes ont le même sexe.
     */
    public Couple(Lycanthrope2 male, Lycanthrope2 female) {
        if (male.getSexe() != female.getSexe()) {
            this.male = male;
            this.female = female;
        }
    }

    /**
     * Affiche les caractéristiques des lycanthropes du couple.
     */
    public void afficherCaracteristiques() {
        System.out.println("Informations du couple :\n- Mâle :\n");
        male.afficherCaracteristiques();
        System.out.println("- Femelle :\n");
    }

    /**
     * Permet la reproduction du couple, générant un nombre aléatoire de nouveaux lycanthropes.
     * Les nouveaux lycanthropes sont ajoutés à la meute de la femelle.
     */
    public void reproduction() {
        Random r = new Random();
        for (int i = 1; i < r.nextInt(8); i++) {
            Lycanthrope2 lycanthrope = new Lycanthrope2(male.getNom() + female.getNom() + i , Math.random() <= 0.5 ? TypeSexe.MALE : TypeSexe.FEMELLE, 3, 5, 1, 5, 5, TypeRangDomination.RANG_23, male.getFacteurImpetuosite() - 15, female.getMeute());
            female.getMeute().addLycanthrope(lycanthrope);
            Colonie.events += " - (🐺➕) " + male.getNom() + " + " + female.getNom() + " se sont reproduits et donnent naissance à " + lycanthrope.getNom() + "\n";
        }
    }

}
