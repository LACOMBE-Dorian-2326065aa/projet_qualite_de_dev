import TD4.Colonie;
import TD4.Hurlements;
import TD4.Lycanthrope;
import TD4.Meute;

public class Main {
    public static void main(String[] args) {
        Colonie colonie = new Colonie();
        Meute meute = new Meute("La meute", "Là");
        colonie.ajouterMeute(meute);
        Lycanthrope l1 = new Lycanthrope(meute, 1, 1, 'a', 1, 1, "jeune", true);
        Lycanthrope l2 = new Lycanthrope(meute, 1, 1, 'b', 1, 1, "jeune", true);
        Lycanthrope l3 = new Lycanthrope(meute, 1, 1, 'c', 1, 1, "jeune", true);
        Lycanthrope l4 = new Lycanthrope(meute, 1, 1, 'd', 1, 1, "jeune", true);
        Lycanthrope l5 = new Lycanthrope(meute, 1, 1, 'a', 1, 1, "jeune", true);

        meute.addLycanthrope(l1);
        meute.addLycanthrope(l2);
        meute.addLycanthrope(l3);
        meute.addLycanthrope(l4);
        meute.addLycanthrope(l5);

        l1.hurler(Hurlements.DOMINATION);

        l1.hurler(Hurlements.APPARTENANCE);

        colonie.afficherLycanthropes();

    }
}