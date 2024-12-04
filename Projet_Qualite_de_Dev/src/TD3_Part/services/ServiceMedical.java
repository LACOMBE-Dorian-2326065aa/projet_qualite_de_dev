package TD3_Part.services;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.Maladie;
import TD3_Part.values.TypeBudget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Représente un service médical qui gère des créatures, leur capacité maximale,
 * leur budget et la possibilité de soigner les créatures malades.
 */
public class ServiceMedical {

    /**
     * Nom du service médical.
     */
    private String nom;

    /**
     * Superficie du service médical en mètres carrés.
     */
    private double superficie;

    /**
     * Capacité maximale de créatures pouvant être prises en charge.
     */
    private int capaciteMax;

    /**
     * Nombre actuel de créatures présentes dans le service.
     */
    private int capaciteActuelle;

    /**
     * Liste des créatures prises en charge par le service médical.
     */
    private List<Creature> creatures;

    /**
     * Budget du service médical, représenté par un type de budget prédéfini.
     */
    private TypeBudget budget;

    /**
     * Liste des budgets disponibles pour tous les services médicaux.
     */
    public static ArrayList<TypeBudget> budgets = new ArrayList<>(Arrays.asList(TypeBudget.values()));

    /**
     * Constructeur pour initialiser un service médical avec les paramètres nécessaires.
     *
     * @param nom         le nom du service médical
     * @param superficie  la superficie en mètres carrés
     * @param capaciteMax la capacité maximale du service
     * @param budget      le type de budget associé au service
     */
    public ServiceMedical(String nom, double superficie, int capaciteMax, TypeBudget budget) {
        this.nom = nom;
        this.superficie = superficie;
        this.capaciteMax = capaciteMax;
        this.creatures = new ArrayList<>();
        this.budget = budget;
        this.capaciteActuelle = 0;
    }

    /**
     * Retourne le nom du service médical.
     *
     * @return le nom du service médical
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du service médical.
     *
     * @param nom le nouveau nom du service médical
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le type de budget du service médical.
     *
     * @return le type de budget
     */
    public TypeBudget getBudget() {
        return budget;
    }

    /**
     * Définit le type de budget du service médical.
     *
     * @param budget le nouveau type de budget
     */
    public void setBudget(TypeBudget budget) {
        this.budget = budget;
    }

    /**
     * Retourne la liste des créatures dans le service médical.
     *
     * @return la liste des créatures
     */
    public List<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Définit la liste des créatures prises en charge par le service médical.
     *
     * @param creatures la nouvelle liste des créatures
     */
    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }

    /**
     * Retourne la capacité actuelle du service médical.
     *
     * @return la capacité actuelle
     */
    public int getCapaciteActuelle() {
        return capaciteActuelle;
    }

    /**
     * Définit la capacité actuelle du service médical.
     *
     * @param capaciteActuelle la nouvelle capacité actuelle
     */
    public void setCapaciteActuelle(int capaciteActuelle) {
        this.capaciteActuelle = capaciteActuelle;
    }

    /**
     * Retourne la capacité maximale du service médical.
     *
     * @return la capacité maximale
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * Définit la capacité maximale du service médical.
     *
     * @param capaciteMax la nouvelle capacité maximale
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    /**
     * Retourne la superficie du service médical.
     *
     * @return la superficie
     */
    public double getSuperficie() {
        return superficie;
    }

    /**
     * Définit la superficie du service médical.
     *
     * @param superficie la nouvelle superficie
     */
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    /**
     * Ajoute une créature au service médical si la capacité maximale n'est pas atteinte
     * et si toutes les créatures du service sont du même type.
     *
     * @param creature la créature à ajouter
     * @return true si la créature a été ajoutée, false sinon
     */
    public boolean ajouterCreature(Creature creature) {
        if (capaciteActuelle < capaciteMax) {
            for (Creature creatureElt : creatures) {
                if (creature.getClass() != creatureElt.getClass()) {
                    System.out.println("[⛔] Une créature de type " + creature.getClass().getSimpleName() +
                            " ne peut pas être mélangée avec une créature du type " + creatureElt.getClass().getSimpleName());
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

    /**
     * Retire une créature du service médical.
     *
     * @param creature la créature à retirer
     */
    public void retirerCreature(Creature creature) {
        creatures.remove(creature);
    }

    /**
     * Soigne les maladies de toutes les créatures prises en charge par le service.
     */
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

    /**
     * Affiche les détails du service médical, y compris les créatures et leurs maladies.
     */
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
                    detailsCreature.append(" - Malade : ").append(" " + maladie.getNomComplet() + " (" +
                            maladie.getNiveauActuel() + "/" + maladie.getNiveauMax() + ")");
                }
            }
            System.out.println(detailsCreature.toString());
        }
    }

    /**
     * Affiche uniquement la liste des créatures présentes dans le service médical.
     */
    public void afficherCreatures() {
        for (Creature creature : creatures) {
            StringBuilder detailsCreature = new StringBuilder(" - " + creature.getNom() + " (" + creature.getClass().getSimpleName() + ")");
            if (!creature.getMaladies().isEmpty()) {
                for (Maladie maladie : creature.getMaladies()) {
                    detailsCreature.append(" - Malade : ").append(" " + maladie.getNomComplet() + " (" +
                            maladie.getNiveauActuel() + "/" + maladie.getNiveauMax() + ")");
                }
            }
            System.out.println(detailsCreature.toString());
        }
    }
}
