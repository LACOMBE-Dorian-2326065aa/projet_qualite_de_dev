package TD3_Part;

public class Vampire extends Creature {

    public Vampire(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void demoraliserAutresCreatures() {
        System.out.println("Le vampire " + getNom() + " démoralise les autres créatures du service médical.");
    }

    public void attendre() {
        super.attendre();
        if (getMorale() <= 0) {
            hurler();
        }
    }

    public void trepasserVampire() {
        if (getMaladies().size() >= 5) {
            System.out.println("Le vampire " + getNom() + " a trépassé.");
            demoraliserAutresCreatures();
            regen();
        }
    }

    public void contaminerVampire(){
        System.out.println("Le vampire " + getNom() + " contamine son équipe médical");
    }

    public void regen() {
        System.out.println(super.getNom() + " possède une résistance accrue aux maladies.");
        if (!super.getMaladies().isEmpty()) {
            super.setMorale(Math.max(super.getMorale() - 5, 0));
        }
    }
}
