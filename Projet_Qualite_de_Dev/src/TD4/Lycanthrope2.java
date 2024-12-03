package TD4;

import TD3_Part.creatures.*;
import TD3_Part.main.Simulation;
import TD3_Part.values.TypeAge;
import TD3_Part.values.TypeHurlement;
import TD3_Part.values.TypeRangDomination;
import TD3_Part.values.TypeSexe;

import java.util.Iterator;
import java.util.Random;

public class Lycanthrope2 extends Creature implements CreatureBestiale, HabitantDuTriage {

    private TypeAge categorieAge;
    private int force;
    private int facteurDomination;
    private TypeRangDomination rangDomination;
    private int niveau;
    private int facteurImpetuosite;
    private Meute meute;
//    public static ArrayList<TypeHurlement> hurlementTypes = new ArrayList<>(Arrays.asList(TypeHurlement.values()));
    private static final Random random = new Random();

    public Lycanthrope2(String nom, TypeSexe sexe, double poids, double taille, int age, int force, int facteurDomination, TypeRangDomination rangDomination, int facteurImpetuosite, Meute meute) {
        super(nom, sexe, poids, taille, age);
        this.categorieAge = categorieAge;
        this.force = force;
        this.facteurDomination = facteurDomination;
        this.rangDomination = rangDomination;
        this.niveau = niveau;
        this.facteurImpetuosite = facteurImpetuosite;
        this.meute = meute;
        setCategorieAge(null);
        calculCategorieAge();
    }

    public TypeAge getCategorieAge() {
        return categorieAge;
    }

    public void setCategorieAge(TypeAge categorieAge) {
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

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public TypeRangDomination getRangDomination() {
        return rangDomination;
    }

    public void setRangDomination(TypeRangDomination rangDomination) {
        this.rangDomination = rangDomination;
    }

    public int getFacteurImpetuosite() {
        return facteurImpetuosite;
    }

    public void setFacteurImpetuosite(int facteurImpetuosite) {
        this.facteurImpetuosite = facteurImpetuosite;
    }

    public Meute getMeute() {
        return meute;
    }

    public void setMeute(Meute meute) {
        this.meute = meute;
    }

    @Override
    public void attendre() {
        HabitantDuTriage.super.attendre();
    }

    @Override
    public void trepasser() {
        CreatureBestiale.super.trepasser();
    }

    public void afficherCaracteristiques() {
        System.out.println(
                "=== Caractéristiques du Lycanthrope ===\n" +
                        "- Nom : " + getNom() + "\n" +
                        "- Sexe : " + (getSexe() == TypeSexe.FEMELLE ? "Femelle" : "Mâle") + "\n" +
                        "- Poids : " + getPoids() + " kg\n" +
                        "- Taille : " + getTaille() + " m\n" +
                        "- Âge : " + getAge() + " ans\n" +
                        "- Catégorie d'âge : " + getCategorieAge() + "\n" +
                        "- Force : " + getForce() + "\n" +
                        "- Facteur de domination : " + getFacteurDomination() + "\n" +
                        "- Rang de domination : " + getRangDomination() + "\n" +
                        "- Niveau : " + getNiveau() + "\n" +
                        "- Facteur d'impétuosité : " + getFacteurImpetuosite() + "\n" +
                        "- Meute : " + (getMeute() != null ? getMeute().getNom() : "Aucune") + "\n" +
                        "========================================"
        );
    }

    public void hurlerDomination(Lycanthrope2 lycan) {
        if (meute != null && meute.getLycanthropes().size() > 1) {
            Lycanthrope2 loupElt;
            do {
                loupElt = meute.getLycanthropes().get(random.nextInt(meute.getLycanthropes().size()));
            } while (loupElt == this);
            Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : hurle (" + TypeHurlement.DOMINATION + ") contre " + loupElt.getNom() + " (" + loupElt.getRangDomination().getRangDomination() + ") !\n";
            loupElt.entendre(TypeHurlement.DOMINATION, this);
        }
    }

    @Override
    public void hurler() {
        TypeHurlement hurlementType = Math.random() <= 0.5 ? TypeHurlement.APPARTENANCE : TypeHurlement.DOMINATION;
        hurler(hurlementType, true, null);
    }

    public void hurler(TypeHurlement hurlementType, boolean answer, Lycanthrope2 loup) {
        Iterator<Lycanthrope2> iterator = meute.getLycanthropes().iterator();
        switch (hurlementType) {
            case TypeHurlement.APPARTENANCE:
                Colonie.events += " - (🐺) " + this.getNom() + " : hurle (" + TypeHurlement.APPARTENANCE + "), " + getMeute().getNom() + " RAAAAAAAAAAAAAAAAAAAAH !\n";

                if (answer) {
                    while (iterator.hasNext()) {
                        Lycanthrope2 loupElt = iterator.next();
                        if (loupElt != this) {
                            loupElt.entendre(hurlementType, this);
                        }
                    }
                }

                break;
            case TypeHurlement.DOMINATION:
                if (meute != null && meute.getLycanthropes().size() > 1) {
                    Lycanthrope2 loupElt;
                    do {
                        loupElt = meute.getLycanthropes().get(random.nextInt(meute.getLycanthropes().size()));
                    } while (loupElt == this);
                    Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : hurle (" + TypeHurlement.DOMINATION + ") contre " + loupElt.getNom() + " (" + loupElt.getRangDomination().getRangDomination() + ") !\n";
                    loupElt.entendre(hurlementType, this);
                }
                break;
            case TypeHurlement.AGRESSIVITE:
                Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : entend (" + TypeHurlement.DOMINATION + ") de " + loup.getNom() + " (" + loup.getRangDomination().getRangDomination() + ") mais se montre agressif !\n";
                loup.setFacteurDomination(loup.getFacteurDomination() - 5);
                break;
            case TypeHurlement.SOUMISSION:
                if (loup.getRangDomination().ordinal() < this.getRangDomination().ordinal()) {
                    Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : entend (" + TypeHurlement.DOMINATION + ") de " + loup.getNom() + " (" + loup.getRangDomination().getRangDomination() + ") et se soumet ! " + getRangDomination().getRangDomination() + " ↔️ " + loup.getRangDomination().getRangDomination() + "\n";
                    TypeRangDomination newFacteur = loup.getRangDomination();
                    loup.setRangDomination(getRangDomination());
                    setRangDomination(newFacteur);
                } else {
                    Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : entend (" + TypeHurlement.DOMINATION + ") de " + loup.getNom() + " (" + loup.getRangDomination().getRangDomination() + ") et se soumet !\n";
                }
                setFacteurDomination(getFacteurDomination() - 5);
                loup.setFacteurDomination(loup.getFacteurDomination() + 5);
                break;
        }
        retrograderRangSiNecessaire(5);
    }

    public void entendre(TypeHurlement hurlementType, Lycanthrope2 loup) {
        boolean tropMalade = false;
        for (Maladie maladie : getMaladies()) {
            if (maladie.getNiveauMax() - maladie.getNiveauActuel() <= 2) {
                Colonie.events += " - (🐺🦠) " + this.getNom() + " est trop malade pour entendre un hurlement !\n";
            }
        }
        switch (hurlementType) {
            case TypeHurlement.APPARTENANCE:
                hurler(hurlementType, false, null);
                break;
            case TypeHurlement.DOMINATION:
                if (loup.getFacteurImpetuosite() <= getFacteurImpetuosite() && !(loup.getSexe() == TypeSexe.FEMELLE && loup.getRangDomination() == TypeRangDomination.RANG_24)) {
                    hurler(TypeHurlement.AGRESSIVITE, true, loup);
                } else {
                    hurler(TypeHurlement.SOUMISSION, true, loup);
                }
                break;
        }
    }

    public void retrograderRangSiNecessaire(int seuilFacteurDomination) {
        if (facteurDomination < seuilFacteurDomination) {
            long membresMemeRang = meute.getLycanthropes().stream()
                    .filter(l -> l.getRangDomination() == this.rangDomination && l.getSexe() == this.getSexe())
                    .count();

            if (membresMemeRang > 1) {
                int rangActuelIndex = rangDomination.ordinal();
                if (rangActuelIndex < TypeRangDomination.values().length - 1) {
                    TypeRangDomination nouveauRang = TypeRangDomination.values()[rangActuelIndex - 1];
                    Colonie.events += " - (🐺📉) " + this.getNom() + " rétrograde de " + rangDomination.getRangDomination() + " à " + nouveauRang.getRangDomination() + " !\n";
                    this.rangDomination = nouveauRang;
                }
            }
        }
    }

    public void vieillir() {
        setAge(getAge() + 1);
        Colonie.events += " - (🐺👴) " + this.getNom() + " vieillit (" + (getAge()-1) + " → " + getAge() + ") !\n";
        calculCategorieAge();
    }

    public void calculCategorieAge() {
        TypeAge old = getCategorieAge();
        if (getAge() <= 18) {
            setCategorieAge(TypeAge.JEUNE);
        } else if (getAge() <= 45) {
            setCategorieAge(TypeAge.ADULTE);
        } else {
            setCategorieAge(TypeAge.VIEUX);
        }
        System.out.println(getNom() + " " + getAge() + getCategorieAge());

        if (old == null)
            return;

        if (!old.equals(getCategorieAge())) {
            Colonie.events += " - (🐺👴) " + this.getNom() + " est entré dans la catégorie " + getCategorieAge().getCategorieAge() + " !\n";
        }
    }

    @Override
    public void setMort(boolean mort) {
        super.setMort(true);
        meute.removeLycanthrope(this);
        setMeute(null);
    }

}
