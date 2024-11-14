package TD4;

import java.util.Random;

public class Couple {

    private Lycanthrope male;
    private Lycanthrope female;

    public Couple(Lycanthrope male, Lycanthrope female) {
        if (male.getSexe() != female.getSexe()) {
            this.male = male;
            this.female = female;
        } else {
            System.out.println("Le couple ne peut pas être créé, il doit contenir un mâle et une femelle");
        }
    }

    public void afficherCaracteristiques() {
        System.out.println("Informations du couple :\n- Mâle :\n");
        male.afficherCaracteristiques();
        System.out.println("- Femelle :\n");
    }

    public void reproduction() {
        Random r = new Random();
        Lycanthrope lycanthrope = new Lycanthrope(female.getMeute(), 1, 1, male.getRangDomination(), 1, 1, "Jeune", r.nextInt(2) == 0 ? false : true);
        female.getMeute().addLycanthrope(lycanthrope);
    }

}
