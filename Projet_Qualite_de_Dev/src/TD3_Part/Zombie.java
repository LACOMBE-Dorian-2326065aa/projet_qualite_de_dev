package TD3_Part;

public class Zombie extends Creature {

    public Zombie(String nom, String sexe, double poids, double taille, int age) {
        super(nom, sexe, poids, taille, age);
    }

    public void regen() {
        System.out.println(nom + " possède une résistance accrue aux maladies.");
        if (!maladies.isEmpty()) {
            morale = Math.max(morale - 5, 0);
        }
    }
}
