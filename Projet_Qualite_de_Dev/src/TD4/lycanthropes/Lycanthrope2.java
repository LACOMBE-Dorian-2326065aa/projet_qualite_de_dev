package TD4.lycanthropes;

import TD3_Part.creatures.*;
import TD4.values.TypeAge;
import TD4.values.TypeHurlement;
import TD4.values.TypeRangDomination;
import TD3_Part.values.TypeSexe;

import java.util.Iterator;
import java.util.Random;

/**
 * La classe Lycanthrope2 représente un lycanthrope avec des caractéristiques spécifiques et des comportements
 * tels que hurler, entendre des hurlements, vieillir et rétrograder de rang si nécessaire.
 * 
 * Cette classe étend la classe Creature et implémente les interfaces CreatureBestiale et HabitantDuTriage.
 * 
 * Attributs :
 * - categorieAge : La catégorie d'âge du lycanthrope (JEUNE, ADULTE, VIEUX).
 * - force : La force physique du lycanthrope.
 * - facteurDomination : Le facteur de domination du lycanthrope.
 * - rangDomination : Le rang de domination du lycanthrope.
 * - niveau : Le niveau du lycanthrope.
 * - facteurImpetuosite : Le facteur d'impétuosité du lycanthrope.
 * - meute : La meute à laquelle appartient le lycanthrope.
 * - random : Générateur de nombres aléatoires pour certaines actions.
 * 
 * Constructeur :
 * - Lycanthrope2(String nom, TypeSexe sexe, double poids, double taille, int age, int force, int facteurDomination, TypeRangDomination rangDomination, int facteurImpetuosite, Meute meute) :
 *   Initialise un nouveau lycanthrope avec les caractéristiques spécifiées.
 * 
 * Méthodes :
 * - getCategorieAge() : Retourne la catégorie d'âge du lycanthrope.
 * - setCategorieAge(TypeAge categorieAge) : Définit la catégorie d'âge du lycanthrope.
 * - getForce() : Retourne la force du lycanthrope.
 * - setForce(int force) : Définit la force du lycanthrope.
 * - getFacteurDomination() : Retourne le facteur de domination du lycanthrope.
 * - setFacteurDomination(int facteurDomination) : Définit le facteur de domination du lycanthrope.
 * - getNiveau() : Retourne le niveau du lycanthrope.
 * - setNiveau(int niveau) : Définit le niveau du lycanthrope.
 * - getRangDomination() : Retourne le rang de domination du lycanthrope.
 * - setRangDomination(TypeRangDomination rangDomination) : Définit le rang de domination du lycanthrope.
 * - getFacteurImpetuosite() : Retourne le facteur d'impétuosité du lycanthrope.
 * - setFacteurImpetuosite(int facteurImpetuosite) : Définit le facteur d'impétuosité du lycanthrope.
 * - getMeute() : Retourne la meute du lycanthrope.
 * - setMeute(Meute meute) : Définit la meute du lycanthrope.
 * - attendre() : Implémente l'attente du lycanthrope.
 * - trepasser() : Implémente la mort du lycanthrope.
 * - afficherCaracteristiques() : Affiche les caractéristiques du lycanthrope.
 * - hurlerDomination(Lycanthrope2 lycan) : Hurle un cri de domination contre un autre lycanthrope.
 * - hurler() : Hurle en fonction d'un type de hurlement aléatoire.
 * - hurler(TypeHurlement hurlementType, boolean answer, Lycanthrope2 loup) : Hurle en fonction du type de hurlement spécifié.
 * - entendre(TypeHurlement hurlementType, Lycanthrope2 loup) : Permet à un lycanthrope d'entendre un hurlement et de réagir en conséquence.
 * - retrograderRangSiNecessaire(int seuilFacteurDomination) : Rétrograde le rang de domination du lycanthrope si nécessaire.
 * - vieillir() : Vieillit le lycanthrope d'un an, met à jour les événements de la colonie et recalcule la catégorie d'âge.
 * - calculCategorieAge() : Calcule et met à jour la catégorie d'âge du lycanthrope en fonction de son âge actuel.
 * - setMort(boolean mort) : Définit l'état de mort du lycanthrope.
 */
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

    /**
     * Affiche les caractéristiques du lycanthrope.
     * Les caractéristiques affichées incluent :
     * - Nom
     * - Sexe (Femelle ou Mâle)
     * - Poids en kilogrammes
     * - Taille en mètres
     * - Âge en années
     * - Catégorie d'âge
     * - Force
     * - Facteur de domination
     * - Rang de domination
     * - Niveau
     * - Facteur d'impétuosité
     * - Nom de la meute (ou "Aucune" si le lycanthrope n'appartient à aucune meute)
     */
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

    /**
     * Hurle un cri de domination contre un autre lycanthrope.
     * Si la meute n'est pas nulle et contient plus d'un lycanthrope,
     * un événement est ajouté à la colonie et le lycanthrope cible entend le hurlement.
     *
     * @param lycan le lycanthrope cible du hurlement de domination
     */
    public void hurlerDomination(Lycanthrope2 lycan) {
        if (meute != null && meute.getLycanthropes().size() > 1) {
            Colonie.events += " - (🐺🔪) " + this.getNom() + " (" + getRangDomination().getRangDomination() + ") : hurle (" + TypeHurlement.DOMINATION + ") contre " + lycan.getNom() + " (" + lycan.getRangDomination().getRangDomination() + ") !\n";
            lycan.entendre(TypeHurlement.DOMINATION, this);
        }
    }

    /**
     * Hurle en fonction d'un type de hurlement aléatoire.
     * Le type de hurlement est déterminé aléatoirement entre APPARTENANCE et DOMINATION.
     * La méthode appelle ensuite la méthode hurler avec le type de hurlement déterminé,
     * un booléen true et une valeur null.
     */
    @Override
    public void hurler() {
        TypeHurlement hurlementType = Math.random() <= 0.5 ? TypeHurlement.APPARTENANCE : TypeHurlement.DOMINATION;
        hurler(hurlementType, true, null);
    }

    /**
     * Cette méthode permet à un lycanthrope de hurler en fonction du type de hurlement spécifié.
     * 
     * @param hurlementType Le type de hurlement (APPARTENANCE, DOMINATION, AGRESSIVITE, SOUMISSION).
     * @param answer Indique si les autres lycanthropes doivent répondre au hurlement.
     * @param loup Le lycanthrope qui entend le hurlement.
     */
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

    /**
     * Permet à un lycanthrope d'entendre un hurlement et de réagir en conséquence.
     *
     * @param hurlementType Le type de hurlement entendu.
     * @param loup Le lycanthrope qui émet le hurlement.
     */
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

    /**
     * Rétrograde le rang de domination du lycanthrope si nécessaire.
     * 
     * Cette méthode vérifie si le facteur de domination du lycanthrope est inférieur
     * au seuil spécifié. Si c'est le cas, elle compte le nombre de membres de la meute
     * ayant le même rang de domination et le même sexe. Si ce nombre est supérieur à 1,
     * le lycanthrope rétrograde d'un rang de domination.
     * 
     * @param seuilFacteurDomination Le seuil en dessous duquel le lycanthrope doit rétrograder.
     */
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

    /**
     * Vieillit le lycanthrope d'un an, met à jour les événements de la colonie et recalcule la catégorie d'âge.
     * <p>
     * Cette méthode incrémente l'âge du lycanthrope de 1, ajoute un événement à la liste des événements de la colonie
     * indiquant que le lycanthrope a vieilli, et recalcule la catégorie d'âge du lycanthrope.
     * </p>
     */
    public void vieillir() {
        setAge(getAge() + 1);
        Colonie.events += " - (🐺👴) " + this.getNom() + " vieillit (" + (getAge()-1) + " → " + getAge() + ") !\n";
        calculCategorieAge();
    }

    /**
     * Calcule et met à jour la catégorie d'âge du lycanthrope en fonction de son âge actuel.
     * Les catégories d'âge sont définies comme suit :
     * - JEUNE : 18 ans ou moins
     * - ADULTE : entre 19 et 45 ans
     * - VIEUX : plus de 45 ans
     * 
     * Si la catégorie d'âge change, un événement est ajouté à la colonie pour indiquer ce changement.
     */
    public void calculCategorieAge() {
        TypeAge old = getCategorieAge();
        if (getAge() <= 18) {
            setCategorieAge(TypeAge.JEUNE);
        } else if (getAge() <= 45) {
            setCategorieAge(TypeAge.ADULTE);
        } else {
            setCategorieAge(TypeAge.VIEUX);
        }

        if (old == null)
            return;

        if (!old.equals(getCategorieAge())) {
            Colonie.events += " - (🐺👴) " + this.getNom() + " est entré dans la catégorie " + getCategorieAge().getCategorieAge() + " !\n";
        }
    }

    /**
     * Définit l'état de mort du lycanthrope.
     * 
     * @param mort un booléen indiquant si le lycanthrope est mort (true) ou non (false)
     * 
     * Remarque : Cette méthode appelle la méthode setMort de la classe parente avec la valeur true,
     * retire le lycanthrope de la meute et définit la meute à null.
     */
    @Override
    public void setMort(boolean mort) {
        super.setMort(true);
        meute.removeLycanthrope(this);
        setMeute(null);
    }

}
