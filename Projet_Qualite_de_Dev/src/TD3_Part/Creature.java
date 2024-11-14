package TD3_Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public abstract class Creature {
    private String nom;
    private String sexe;
    private double poids;
    private double taille;
    private int age;
    private int morale;
    private List<String> maladies;

    public Creature(String nom, String sexe, double poids, double taille, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.morale = 100;
        this.maladies = new ArrayList<>();
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public List<String> getMaladies() {
        return maladies;
    }

    public void setMaladies(List<String> maladies) {
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

    public void attendre(){
        this.morale--;
    }

    public void hurler(){
        if (this.morale <= 1){
            System.out.println("RAAAAAAAAAAAAAAAAAAAAH");
        }
    }

    public void sEmporter(){
        //TODO
    }

    public void tomberMalade(String maladie){
        this.maladies.add(maladie);
    }

    public void guerison(String maladie){
            if(this.maladies.contains(maladie)) {
                maladies.remove(maladie);
                morale++;
            }
    }

    public void trepasser(){
        if (maladies.size() >= 5){
            System.out.println("La créature " + this.getNom() + " a trépassée.");
        }
    }
}
