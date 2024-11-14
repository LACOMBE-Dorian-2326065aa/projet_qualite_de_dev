package TD3_Part;

import java.util.ArrayList;
import java.util.List;

public class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private int capaciteActuelle;
    private List<Creature> creatures;
    private String budget;

    public ServiceMedical(String nom, double superficie, int capaciteMax, String budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>();
        this.budget = budget;
        this.capaciteActuelle = 0;
    }

    public void ajouterCreature(Creature creature) {
        if (capaciteActuelle < capaciteMax) {
            creatures.add(creature);
            capaciteActuelle++;
        } else {
            System.out.println("Capacité maximale atteinte pour le service médical.");
        }
    }

    public void soignerCreatures() {
        for (Creature creature : creatures) {
            creature.guerison("MDC");
        }
    }

    public void afficherDetails() {
        System.out.println("Nom du service: " + nom);
        System.out.println("Superficie: " + superficie);
        System.out.println("Capacité maximale: " + capaciteMax);
        System.out.println("Budget: " + budget);
        System.out.println("Nombre de créatures: " + capaciteActuelle);
    }
}
