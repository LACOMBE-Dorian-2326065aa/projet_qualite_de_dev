package TD4;

import java.util.Iterator;

public class Lycanthrope {

    private boolean sexe;
    private String categorieAge;
    private int force;
    private int facteurDomination;
    private char rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private Meute meute;

    public Lycanthrope(Meute meute, int facteurImpetuosite, int niveau, char rangDomination, int facteurDomination, int force, String categorieAge, boolean sexe) {
        this.meute = meute;
        this.facteurImpetuosite = facteurImpetuosite;
        this.niveau = niveau;
        this.rangDomination = rangDomination;
        this.facteurDomination = facteurDomination;
        this.force = force;
        this.categorieAge = categorieAge;
        this.sexe = sexe;
    }

    public boolean getSexe() {
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

    public char getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(char rangDomination) {
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
        System.out.println("Lycanthrope :\n- Rang : " + getRangDomination() + "\n- Sexe : " + (sexe ? "Femelle" : "Mâle") + "\n- Niveau : " + getNiveau() + "\n- Force : " + getForce() + "\n- Catégorie d'âge : " + getCategorieAge() + "\n");
    }

    public void hurler(String hurlementType) {
        Iterator<Lycanthrope> iterator = meute.getMeute().iterator();

        while (iterator.hasNext()) {
            Lycanthrope loup = iterator.next();
            if (loup != this) {
                loup.entendre(hurlementType, this);
            }
        }
    }

    public void entendre(String hurlementType, Lycanthrope loup) {
        switch (hurlementType) {
            case Hurlements.APPARTENANCE:
                if (loup.meute == meute) {
                    System.out.println("Un lycanthrope de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.APPARTENANCE_SANS_REPONSE + ".");
                    hurler(Hurlements.APPARTENANCE_SANS_REPONSE);
                }
                break;
            case Hurlements.DOMINATION:
                if ((loup.meute.getMeute().indexOf(loup) < meute.getMeute().indexOf(this) && loup.getRangDomination() == getRangDomination()) || loup.meute.getMeute().indexOf(loup) > meute.getMeute().indexOf(this)) {
                    System.out.println("Un lycanthrope de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.AGRESSIVITE + ".");
                    hurler(Hurlements.AGRESSIVITE);
                } else {
                    System.out.println("Un lycanthrope de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.SOUMISSION + ".");
                    hurler(Hurlements.SOUMISSION);
                }
                break;
        }
    }

    public void separerDeLaMeute() {
        meute = null;
        System.out.println("Un lycantrophe de rang " + getRangDomination() + " s'est séparé de sa meute.");
    }

    public void transformerEnHumain() {
        // TODO
    }
}
