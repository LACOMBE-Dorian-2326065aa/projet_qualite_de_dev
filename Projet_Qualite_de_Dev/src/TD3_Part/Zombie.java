package TD3_Part;

public class Zombie extends Creature {

    public Zombie(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void regen() {
        System.out.println(super.getNom() + " possède une résistance accrue aux maladies.");
        if (!super.getMaladies().isEmpty()) {
            super.setMorale(Math.max(super.getMorale() - 5, 0));
        }
    }

    @Override
    public void trepasser() {
        super.trepasser();
        regen();
    }
}
