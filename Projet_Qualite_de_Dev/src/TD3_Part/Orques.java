package TD3_Part;

public class Orques extends Creature {

    public Orques(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void attendre() {
        super.attendre();
        if (getMorale() <= 0) {
            super.hurler();
        }
    }

    public void trepasserOrques() {
        super.trepasser();
    }

    public void contaminerOrques(){
        System.out.println("L'orques " + getNom() + " contamine son équipe médical");
    }
}
