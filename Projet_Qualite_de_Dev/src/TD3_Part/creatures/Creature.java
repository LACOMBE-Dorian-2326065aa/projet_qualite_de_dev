package TD3_Part.creatures;

import TD3_Part.Maladie;
import TD3_Part.ServiceMedical;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Creature {
    private String nom;
    private String sexe;
    private double poids;
    private double taille;
    private int age;
    private int moral;
    private List<Maladie> maladies;
    private ServiceMedical serviceMedical;
    private static Random random = new Random();

    public Creature(String nom, String sexe, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.moral = 100;
        this.maladies = new ArrayList<>();
    }

    public ServiceMedical getServiceMedical() {
        return serviceMedical;
    }

    public void setServiceMedical(ServiceMedical serviceMedical) {
        this.serviceMedical = serviceMedical;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public List<Maladie> getMaladies() {
        return maladies;
    }

    public void setMaladies(List<Maladie> maladies) {
        this.maladies = maladies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void attendre() {
        this.moral--;
    }

    public void hurler() {
        if (this.moral <= 1) {
            System.out.println(this.getNom() + " hurle, RAAAAAAAAAAAAAAAAAAAAH !");
        }
    }

    public void sEmporter() {
        System.out.println(this.getNom() + " s'emporte et devient dangereux !");
    }

    public void tomberMalade(Maladie maladie) {
        this.maladies.add(maladie);
    }

    public void guerison(Maladie maladie) {
        if (this.maladies.contains(maladie)) {
            maladies.remove(maladie);
            moral += 3;
        }
    }

    public void trepasser() {
//        System.out.println(getNom() + " est décédé.");
        if (!getMaladies().isEmpty()) {
            for (Maladie maladie : getMaladies()) {
                if (maladie.estLethal()) {
                    List<Creature> creatures = getServiceMedical().getCreatures();
                    for (Creature creature : creatures) {
                        if (creature != this && Math.random() <= 0.5) {
                            creature.tomberMalade(maladie);
                            System.out.println(getNom() + " a contaminé " + creature.getNom() + " (" + maladie.getNomComplet() + ") en trépassant !");
                        }
                    }
                    break;
                }
            }
        }
    }
}