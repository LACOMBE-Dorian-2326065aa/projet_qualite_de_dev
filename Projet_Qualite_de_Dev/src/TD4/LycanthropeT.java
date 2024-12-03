//package TD4;
//
//import TD4.Meute;
//
//import java.util.Iterator;
//
//public class LycanthropeT {
//
//    private String nom;
//    private boolean sexe;
//    private String categorieAge;
//    private int force;
//    private int facteurDomination;
//    private char rangDomination;
//    private int niveau;
//    private int facteurImpetuosite;
//    private Meute meute;
//
//    public static final String JEUNE = "Jeune";
//    public static final String ADULTE = "Adulte";
//    public static final String VIEUX = "Vieux";
//
//    public LycanthropeT(Meute meute, String nom, int facteurImpetuosite, int niveau, char rangDomination, int facteurDomination, int force, String categorieAge, boolean sexe) {
//        this.nom = nom;
//        this.meute = meute;
//        this.facteurImpetuosite = facteurImpetuosite;
//        this.niveau = niveau;
//        this.rangDomination = rangDomination;
//        this.facteurDomination = facteurDomination;
//        this.force = force;
//        this.categorieAge = categorieAge;
//        this.sexe = sexe;
//    }
//
//    public boolean getSexe() {
//        return sexe;
//    }
//
//    public void setSexe(boolean sexe) {
//        this.sexe = sexe;
//    }
//
//    public String getCategorieAge() {
//        return categorieAge;
//    }
//
//    public void setCategorieAge(String categorieAge) {
//        this.categorieAge = categorieAge;
//    }
//
//    public int getForce() {
//        return force;
//    }
//
//    public void setForce(int force) {
//        this.force = force;
//    }
//
//    public int getFacteurDomination() {
//        return facteurDomination;
//    }
//
//    public void setFacteurDomination(int facteurDomination) {
//        this.facteurDomination = facteurDomination;
//    }
//
//    public char getRangDomination() {
//        return rangDomination;
//    }
//
//    public void setRangDomination(char rangDomination) {
//        this.rangDomination = rangDomination;
//    }
//
//    public int getFacteurImpetuosite() {
//        return facteurImpetuosite;
//    }
//
//    public void setFacteurImpetuosite(int facteurImpetuosite) {
//        this.facteurImpetuosite = facteurImpetuosite;
//    }
//
//    public int getNiveau() {
//        return niveau;
//    }
//
//    public void setNiveau(int niveau) {
//        this.niveau = niveau;
//    }
//
//    public Meute getMeute() {
//        return meute;
//    }
//
//    public void setMeute(Meute meute) {
//        this.meute = meute;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public boolean isSexe() {
//        return sexe;
//    }
//
//    public void afficherCaracteristiques() {
//        System.out.println("Lycanthrope :\n- Nom : " + getNom() + "\n- Rang : " + getRangDomination() + "\n- Sexe : " + (sexe ? "Femelle" : "Mâle") + "\n- Niveau : " + getNiveau() + "\n- Force : " + getForce() + "\n- Catégorie d'âge : " + getCategorieAge() + "\n");
//    }
//
//    public void hurler(String hurlementType) {
//        Iterator<LycanthropeT> iterator = meute.getLycanthropes().iterator();
//
//        while (iterator.hasNext()) {
//            LycanthropeT loup = iterator.next();
//            if (loup != this) {
//                loup.entendre(hurlementType, this);
//            }
//        }
//    }
//
//    public void entendre(String hurlementType, LycanthropeT loup) {
//        switch (hurlementType) {
//            case Hurlements.APPARTENANCE:
//                if (loup.meute == meute) {
//                    System.out.println(getNom() + " de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.APPARTENANCE_SANS_REPONSE + ".");
//                    hurler(Hurlements.APPARTENANCE_SANS_REPONSE);
//                }
//                break;
//            case Hurlements.DOMINATION:
//                if (loup.getFacteurImpetuosite() < getFacteurImpetuosite()) {
//                    System.out.println(getNom() + " de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.AGRESSIVITE + ".");
//                    loup.setFacteurDomination(loup.getFacteurDomination() - 5);
//                    hurler(Hurlements.AGRESSIVITE);
//                } else {
//                    System.out.println(getNom() + " de rang " + getRangDomination() + " a entendu le hurlement " + hurlementType + " et provoque le hurlement : " + Hurlements.SOUMISSION + ".");
//                    loup.setFacteurDomination(loup.getFacteurDomination() + 5);
//                    setFacteurDomination(getFacteurDomination() - 5);
//
//                    char newFacteur = loup.getRangDomination();
//                    loup.setRangDomination(getRangDomination());
//                    setRangDomination(newFacteur);
//                    hurler(Hurlements.SOUMISSION);
//                }
//                break;
//        }
//        if (getFacteurDomination() < 10) {
//            decrementRang();
//        }
//        if (loup.getFacteurDomination() < 10) {
//            loup.decrementRang();
//        }
//    }
//
//    public void decrementRang() {
//        // TODO
//        //setRangDomination(meute.getRang().toCharArray()[]);
//    }
//
//    public void separerDeLaMeute() {
//        meute.removeLycanthrope(this);
//        meute = null;
//        System.out.println(getNom() + " de rang " + getRangDomination() + " s'est séparé de sa meute.");
//    }
//
//    public void transformerEnHumain() {
//        if (Math.random() > (niveau / 100.0)) {
//            separerDeLaMeute();
//            System.out.println(getNom() + " s'est transformé en humain et a quitté sa meute.");
//        } else {
//            System.out.println("Le lycanthrope s'est transformé en humain mais reste dans sa meute.");
//        }
//    }
//
//    public void contaminerLycan(){
//        // TODO
//        System.out.println("Le lycanthrope contamine son équipe médical");
//    }
//
//}
