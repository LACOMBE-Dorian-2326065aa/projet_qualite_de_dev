package TD3_Part;

public class Elfe extends Creature {

    public Elfe(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void demoraliserAutresCreatures() {
        System.out.println("L'elfe " + getNom() + " démoralise les autres créatures du service médical.");
    }

    public void attendre() {
        super.attendre();
        if (getMorale() <= 0) {
            hurler();
        }
    }

    public void trepasserElfe() {
        if (getMaladies().size() >= 5) {
            System.out.println("L'elfe " + getNom() + " a trépassé.");
            demoraliserAutresCreatures();
        }
    }

}
