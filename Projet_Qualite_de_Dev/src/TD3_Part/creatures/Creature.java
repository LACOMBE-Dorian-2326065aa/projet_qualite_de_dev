
package TD3_Part.creatures;

import TD3_Part.main.Simulation;
import TD3_Part.services.ServiceMedical;
import TD3_Part.values.TypeSexe;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * La classe abstraite Creature représente une créature avec des attributs tels que le nom, le sexe, le poids, la taille, l'âge, le moral, etc.
 * Elle fournit des méthodes pour gérer l'état de la créature, y compris la baisse du moral, l'attente, le hurlement, l'emportement, la maladie et la guérison.
 */
public abstract class Creature {
    private String nom;
    private TypeSexe sexe;
    private double poids;
    private double taille;
    private int age;
    private int moral;
    private List<Maladie> maladies;
    private ServiceMedical serviceMedical;
    private static Random random = new Random();
    private boolean mort;
    private int compteurAttendre;

    public static HashMap<Class<?>, Integer> compteurAttendreEspece = new HashMap<>();
    /**
     * Constructeur de la classe Creature.
     * @param nom   Le nom de la créature.
     * @param sexe  Le sexe de la créature.
     * @param poids Le poids de la créature.
     * @param taille La taille de la créature.
     * @param age   L'âge de la créature.
     * @param moral Le moral de la créature.
     */ 
    public Creature(String nom, TypeSexe sexe, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.moral = 15;
        this.maladies = new ArrayList<>();
        compteurAttendre = 0;
        mort = false;
    }
    /**
     * Constructeur de la classe Creature.
     * @param nom   Le nom de la créature.
     * @param sexe  Le sexe de la créature.
     * @param age   L'âge de la créature.
     */
    public Creature(String nom, TypeSexe sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.moral = 15;
        this.maladies = new ArrayList<>();
        compteurAttendre = 0;
        mort = false;
    }
    /**
     * Méthode pour obtenir le compteur d'attente.
     */
    public int getCompteurAttendre() {
        return compteurAttendre;
    }
    /**
     * Méthode pour définir le compteur d'attente.
     * @param compteurAttendre Le compteur d'attente.
     */
    public void setCompteurAttendre(int compteurAttendre) {
        this.compteurAttendre = compteurAttendre;
    }
    /**
     * Méthode pour obtenir le statut de la créature.
     */
    public boolean isMort() {
        return mort;
    }
    /**
     * Méthode pour définir le statut de la créature.
     * @param mort Le statut de la créature.
     */
    public void setMort(boolean mort) {
        this.mort = mort;
    }
    /**
     * Méthode pour obtenir le service médical.
     */
    public ServiceMedical getServiceMedical() {
        return serviceMedical;
    }
    /**
     * Méthode pour définir le service médical.
     * @param serviceMedical Le service médical.
     */
    public void setServiceMedical(ServiceMedical serviceMedical) {
        this.serviceMedical = serviceMedical;
    }
    /**
     * Méthode pour obtenir le nom de la créature.
     */
    public String getNom() {
        return nom;
    }
    /**
     * Méthode pour définir le nom de la créature.
     * @param nom Le nom de la créature.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Méthode pour obtenir le moral de la créature.
     */
    public int getMoral() {
        return moral;
    }
    /**
     * Méthode pour définir le moral de la créature.
     * @param moral Le moral de la créature.
     */
    public void setMoral(int moral) {
        this.moral = moral;
    }
    /**
     * Méthode pour baisser le moral de la créature.
     */
    public void baisseMoral() {
        Simulation.events += " - (🤯) " + getNom() + " : Moral : " + moral + " → " + (moral - 1) + ".\n";
        this.moral--;
        hurler();
        if (moral <= 0) {
            Simulation.events += " - (☠️) " + getNom() + " : mort.\n";
            Simulation.morts++;
            trepasser();
        }
    }
    /**
     * Méthode pour obtenir la liste des maladies de la créature.
     */
    public List<Maladie> getMaladies() {
        return maladies;
    }
    /**
     * Méthode pour définir la liste des maladies de la créature.
     * @param maladies La liste des maladies de la créature.
     */
    public void setMaladies(List<Maladie> maladies) {
        this.maladies = maladies;
    }
    /**
     * Méthode pour obtenir l'âge de la créature.
     */
    public int getAge() {
        return age;
    }
    /**
     * Méthode pour définir l'âge de la créature.
     * @param age L'âge de la créature.
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Méthode pour obtenir la taille de la créature.
     */
    public double getTaille() {
        return taille;
    }
    /**
     * Méthode pour définir la taille de la créature.
     * @param taille La taille de la créature.
     */
    public void setTaille(double taille) {
        this.taille = taille;
    }
    /**
     * Méthode pour obtenir le poids de la créature.
     */
    public double getPoids() {
        return poids;
    }
    /**
     * Méthode pour définir le poids de la créature.
     * @param poids Le poids de la créature.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }
    /**
     * Méthode pour obtenir le sexe de la créature.
     */
    public TypeSexe getSexe() {
        return sexe;
    }
    /**
     * Méthode pour définir le sexe de la créature.
     * @param sexe Le sexe de la créature.
     */
    public void setSexe(TypeSexe sexe) {
        this.sexe = sexe;
    }
    /**
     * Méthode pour faire attendre la créature.
     */
    public void attendre() {
        compteurAttendreEspece.put(this.getClass(), compteurAttendreEspece.getOrDefault(this.getClass(), 0) + 1);
        Simulation.events += " - (💤) " + getNom() + " : attend (Moral : " + moral + " → " + (moral - 1) + ").\n";
        this.moral--;
        hurler();
        if (moral <= 0) {
            trepasser();
        }
    }
    /**
     * Méthode pour hurler.
     */
    public void hurler() {
        if (this.moral <= 1) {
            Simulation.events += " - (🧟) " + this.getNom() + " : hurle, RAAAAAAAAAAAAAAAAAAAAH !\n";
        }
    }
    /**
     * Méthode pour s'emporter.
     * Si la créature a des maladies et qu'elle s'emporte, elle peut contaminer une autre créature.
     */

    public void sEmporter() {
        Simulation.events += " - (🧟🤯) " + this.getNom() + " : s'emporte, RAAHAHDUEFHUIEGHUZEIGHEZUF !\n";
        if (maladies.size() > 0 && Math.random() <= 0.75) {
            List<Creature> creatures = getServiceMedical().getCreatures();
            for (Creature creature : creatures) {
                if (creature != this) {
                    Maladie maladie = maladies.get(random.nextInt(maladies.size()));
                    creature.tomberMalade(maladie);
                    Simulation.events += " - (☠️🦠) " + getNom() + " : contamine " + creature.getNom() + " (" + maladie.getNomAbrege() + ").\n";
                    break;
                }
            }
        }
    }
    


    public void tomberMalade(Maladie maladie) {
        this.maladies.add(maladie);
    }
    /**
     * Méthode pour guérir une maladie.
     */
    public void guerison(Maladie maladie) {
        if (this.maladies.contains(maladie)) {
            maladies.remove(maladie);
            moral += 3;
        }
    }
    /**
     * Méthode pour tuer une créature.
     */
    public void trepasser() {
        setMort(true);
    }
}