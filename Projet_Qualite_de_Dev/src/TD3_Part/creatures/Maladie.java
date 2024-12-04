package TD3_Part.creatures;

import TD3_Part.values.TypeMaladie;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La classe {@code Maladie} représente une maladie pouvant affecter une créature.
 * Chaque maladie possède un type, un niveau actuel, et un niveau maximal au-delà duquel elle devient mortelle.
 */
public class Maladie {
    private TypeMaladie type;
    private int niveauActuel;
    private int niveauMax;

    /**
     * Liste statique contenant tous les types de maladies disponibles.
     */
    public static ArrayList<TypeMaladie> maladiesList = new ArrayList<>(Arrays.asList(TypeMaladie.values()));

    /**
     * Constructeur pour créer une nouvelle maladie avec un type et un niveau maximal.
     *
     * @param type       Le type de la maladie, défini par {@link TypeMaladie}.
     * @param niveauMax  Le niveau maximal que la maladie peut atteindre avant de devenir létale.
     */
    public Maladie(TypeMaladie type, int niveauMax) {
        this.type = type;
        this.niveauActuel = 0;
        this.niveauMax = niveauMax;
    }

    /**
     * Obtient le nom complet de la maladie.
     *
     * @return Une chaîne de caractères représentant le nom complet de la maladie.
     */
    public String getNomComplet() {
        return type.getNomComplet();
    }

    /**
     * Obtient le nom abrégé de la maladie.
     *
     * @return Une chaîne de caractères représentant le nom abrégé de la maladie.
     */
    public String getNomAbrege() {
        return type.getNomAbrege();
    }

    /**
     * Obtient le niveau actuel de gravité de la maladie.
     *
     * @return Un entier représentant le niveau actuel de la maladie.
     */
    public int getNiveauActuel() {
        return niveauActuel;
    }

    /**
     * Définit le niveau actuel de gravité de la maladie.
     *
     * @param niveauActuel Le nouveau niveau actuel à définir.
     */
    public void setNiveauActuel(int niveauActuel) {
        this.niveauActuel = niveauActuel;
    }

    /**
     * Obtient le niveau maximal que la maladie peut atteindre.
     *
     * @return Un entier représentant le niveau maximal de la maladie.
     */
    public int getNiveauMax() {
        return niveauMax;
    }

    /**
     * Définit le niveau maximal de la maladie.
     *
     * @param niveauMax Le nouveau niveau maximal à définir.
     */
    public void setNiveauMax(int niveauMax) {
        this.niveauMax = niveauMax;
    }

    /**
     * Augmente le niveau actuel de gravité de la maladie de 1, si possible.
     */
    public void augmenterNiveau() {
        if (niveauActuel < niveauMax) {
            niveauActuel++;
        }
    }

    /**
     * Diminue le niveau actuel de gravité de la maladie de 1, si possible.
     */
    public void diminuerNiveau() {
        if (niveauActuel > 0) {
            niveauActuel--;
        }
    }

    /**
     * Change le niveau actuel de la maladie à un nouveau niveau spécifié,
     * s'il est valide (compris entre 0 et le niveau maximal).
     *
     * @param nouveauNiveau Le nouveau niveau à définir.
     */
    public void changerNiveau(int nouveauNiveau) {
        if (nouveauNiveau >= 0 && nouveauNiveau <= niveauMax) {
            niveauActuel = nouveauNiveau;
        } else {
            System.out.println("Niveau invalide. Il doit être compris entre 0 et " + niveauMax + ".");
        }
    }

    /**
     * Vérifie si la maladie est létale, c'est-à-dire si le niveau actuel a atteint ou dépassé le niveau maximal.
     *
     * @return {@code true} si la maladie est létale, {@code false} sinon.
     */
    public boolean estLethal() {
        return niveauActuel >= niveauMax;
    }

    /**
     * Affiche les détails de la maladie, incluant son nom, son niveau actuel et son niveau maximal.
     */
    public void afficherDetails() {
        System.out.println("- Nom complet : " + type.getNomComplet());
        System.out.println("- Nom abrégé : " + type.getNomAbrege());
        System.out.println("- Niveau actuel : " + niveauActuel);
        System.out.println("- Niveau max avant trépas : " + niveauMax);
    }
}
