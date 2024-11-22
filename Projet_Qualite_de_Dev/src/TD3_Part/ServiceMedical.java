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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }

    public int getCapaciteActuelle() {
        return capaciteActuelle;
    }

    public void setCapaciteActuelle(int capaciteActuelle) {
        this.capaciteActuelle = capaciteActuelle;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
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
        System.out.println("Liste des créatures :");
        for (Creature creature : creatures) {
            StringBuilder detailsCreature = new StringBuilder(" - " + creature.getNom() + " (" + creature.getClass().getSimpleName() + ")");
            if (!creature.getMaladies().isEmpty()) {
                detailsCreature.append(" - Malade : ").append(String.join(", ", creature.getMaladies()));
            }
            System.out.println(detailsCreature.toString());
        }
    }
}