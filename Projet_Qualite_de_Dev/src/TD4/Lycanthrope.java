package TD4;

public class Lycanthrope {

    private boolean sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private int rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private Meute meute;

    public Lycanthrope(Meute meute, int facteurImpetuosite, int niveau, int rangDomination, int facteurDomination, int force, String categorieAge, boolean sexe) {
        this.meute = meute;
        this.facteurImpetuosite = facteurImpetuosite;
        this.niveau = niveau;
        this.rangDomination = rangDomination;
        this.facteurDomination = facteurDomination;
        this.force = force;
        this.categorieAge = categorieAge;
        this.sexe = sexe;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public String getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getFacteurDomination() {
        return facteurDomination;
    }

    public void setFacteurDomination(int facteurDomination) {
        this.facteurDomination = facteurDomination;
    }

    public int getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(int rangDomination) {
        this.rangDomination = rangDomination;
    }

    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Meute getMeute() {
        return meute;
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    public void afficherCaracteristiques() {
        System.out.println(this);
    }

    public void hurler() {
        System.out.println("AAAAAAAARRRRRRRRRGGGGGGHHHHHHHHHHHHHHHHH !!!!!");
    }

    public void entendre() {
        // TODO
    }

    public void separerDeLaMeute() {
        meute = null;
    }

    public void transformerEnHumain() {
        // TODO
    }
}
