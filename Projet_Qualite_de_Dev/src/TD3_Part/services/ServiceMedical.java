package TD3_Part.services;

import TD3_Part.creatures.Maladie;
import TD3_Part.creatures.Creature;
import TD3_Part.values.TypeBudget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServiceMedical {
    private String nom;
    private double superficie;
    private int capaciteMax;
    private int capaciteActuelle;
    private List<Creature> creatures;
    private TypeBudget budget;

    public static ArrayList<TypeBudget> budgets = new ArrayList<>(Arrays.asList(TypeBudget.values()));

    public ServiceMedical(String nom, double superficie, int capaciteMax, TypeBudget budget) {
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

    public TypeBudget getBudget() {
        return budget;
    }

    public void setBudget(TypeBudget budget) {
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

    public boolean ajouterCreature(Creature creature) {
        if (capaciteActuelle < capaciteMax) {
            for (Creature creatureElt : creatures) {
                if (creature.getClass() != creatureElt.getClass()) {
                    System.out.println("[⛔] Une créature de type " + creature.getClass().getSimpleName() + " ne peut pas être mélangée avec une créature du type " + creatureElt.getClass().getSimpleName());
                    return false;
                }
            }
            creatures.add(creature);
            creature.setServiceMedical(this);
            capaciteActuelle++;
            return true;
        } else {
            System.out.println("Capacité maximale atteinte pour le service médical.");
            return false;
        }
    }

    public void retirerCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void soignerCreatures() {
        HashMap<Creature, Maladie> toRemove = new HashMap<>();
        for (Creature creature : creatures) {
            for (Maladie maladie : creature.getMaladies()) {
                if (maladie != null) {
                    toRemove.put(creature, maladie);
                }
            }
        }
        for (Creature creature : toRemove.keySet()) {
            creature.guerison(toRemove.get(creature));
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
                for (Maladie maladie : creature.getMaladies()) {
                    detailsCreature.append(" - Malade : ").append(" " + maladie.getNomComplet() + " (" + maladie.getNiveauActuel() + "/" + maladie.getNiveauMax() + ")");
                }
            }
            System.out.println(detailsCreature.toString());
        }
    }

    public void afficherCreatures() {
        for (Creature creature : creatures) {
            StringBuilder detailsCreature = new StringBuilder(" - " + creature.getNom() + " (" + creature.getClass().getSimpleName() + ")");
            if (!creature.getMaladies().isEmpty()) {
                for (Maladie maladie : creature.getMaladies()) {
                    detailsCreature.append(" - Malade : ").append(" " + maladie.getNomComplet() + " (" + maladie.getNiveauActuel() + "/" + maladie.getNiveauMax() + ")");
                }
            }
            System.out.println(detailsCreature.toString());
        }
    }
}