package TD4;

import TD3_Part.values.TypeRangDomination;
import TD3_Part.values.TypeSexe;

import java.util.Random;

public class Couple {

    private Lycanthrope2 male;
    private Lycanthrope2 female;

    public Couple(Lycanthrope2 male, Lycanthrope2 female) {
        if (male.getSexe() != female.getSexe()) {
            this.male = male;
            this.female = female;
        }
    }

    public void afficherCaracteristiques() {
        System.out.println("Informations du couple :\n- Mâle :\n");
        male.afficherCaracteristiques();
        System.out.println("- Femelle :\n");
    }

    public void reproduction() {
        Random r = new Random();
        for (int i = 1; i < r.nextInt(8); i++) {
            Lycanthrope2 lycanthrope = new Lycanthrope2(male.getNom() + female.getNom(), Math.random() <= 0.5 ? TypeSexe.MALE : TypeSexe.FEMELLE, 3, 5, 1, 5, 5, TypeRangDomination.RANG_23, male.getFacteurImpetuosite() - 15, female.getMeute());
            female.getMeute().addLycanthrope(lycanthrope);
            Colonie.events += " - (🐺➕) " + male.getNom() + " + " + female.getNom() + i + " se sont reproduits et donnent naissance à " + lycanthrope.getNom() + "\n";
        }
    }

}
