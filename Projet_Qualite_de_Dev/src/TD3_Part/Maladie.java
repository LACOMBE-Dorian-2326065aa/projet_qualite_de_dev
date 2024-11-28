package TD3_Part;

public class Maladie {
    private String nomComplet;
    private String nomAbrege;
    private int niveauActuel;
    private int niveauMax;
    public static final String MDC = "Maladie débilitante chronique";
    public static final String FOMO = "Syndrome fear of missing out";
    public static final String DRS = "Dépendance aux réseaux sociaux";
    public static final String PEC = "Porphyrie érythropoïétique congénitale";
    public static final String ZPL = "Zoopathie paraphrénique lycanthropique";
    public static final String NDMAD = "Nécrose Dégénérative des Membres et des Articulations Dorsales";

    public Maladie(String nomComplet, String nomAbrege, int niveauMax) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
        this.niveauActuel = 0;
        this.niveauMax = niveauMax;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }

    public void setNomAbrege(String nomAbrege) {
        this.nomAbrege = nomAbrege;
    }

    public int getNiveauActuel() {
        return niveauActuel;
    }

    public void setNiveauActuel(int niveauActuel) {
        this.niveauActuel = niveauActuel;
    }

    public int getNiveauMax() {
        return niveauMax;
    }

    public void setNiveauMax(int niveauMax) {
        this.niveauMax = niveauMax;
    }

    public void augmenterNiveau() {
        if (niveauActuel < niveauMax) {
            niveauActuel++;
        } else {
            System.out.println("Le niveau de la maladie a atteint son maximum.");
        }
    }

    public void diminuerNiveau() {
        if (niveauActuel > 0) {
            niveauActuel--;
        } else {
            System.out.println("Le niveau de la maladie est déjà à zéro.");
        }
    }

    public void changerNiveau(int nouveauNiveau) {
        if (nouveauNiveau >= 0 && nouveauNiveau <= niveauMax) {
            niveauActuel = nouveauNiveau;
        } else {
            System.out.println("Niveau invalide. Il doit être compris entre 0 et " + niveauMax + ".");
        }
    }

    public boolean estLethal() {
        return niveauActuel >= niveauMax;
    }

    public void afficherDetails() {
        System.out.println("Nom complet : " + nomComplet);
        System.out.println("Nom abrégé : " + nomAbrege);
        System.out.println("Niveau actuel : " + niveauActuel);
        System.out.println("Niveau max avant trépas : " + niveauMax);
    }
}