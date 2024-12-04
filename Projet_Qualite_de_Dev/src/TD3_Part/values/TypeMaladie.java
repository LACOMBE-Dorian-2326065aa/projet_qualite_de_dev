package TD3_Part.values;

/**
 * Enumération représentant les différents types de maladies avec leur nom complet et leur abréviation.
 */
public enum TypeMaladie {

    /**
     * Maladie débilitante chronique (MDC).
     */
    MDC("Maladie débilitante chronique", "MDC"),

    /**
     * Syndrome "fear of missing out" (FOMO).
     */
    FOMO("Syndrome fear of missing out", "FOMO"),

    /**
     * Dépendance aux réseaux sociaux (DRS).
     */
    DRS("Dépendance aux réseaux sociaux", "DRS"),

    /**
     * Porphyrie érythropoïétique congénitale (PEC).
     */
    PEC("Porphyrie érythropoïétique congénitale", "PEC"),

    /**
     * Zoopathie paraphrénique lycanthropique (ZPL).
     */
    ZPL("Zoopathie paraphrénique lycanthropique", "ZPL"),

    /**
     * Nécrose Dégénérative des Membres et des Articulations Dorsales (NDMAD).
     */
    NDMAD("Nécrose Dégénérative des Membres et des Articulations Dorsales", "NDMAD");

    /**
     * Nom complet de la maladie.
     */
    private final String nomComplet;

    /**
     * Nom abrégé de la maladie.
     */
    private final String nomAbrege;

    /**
     * Constructeur de l'énumération {@code TypeMaladie}.
     *
     * @param nomComplet le nom complet de la maladie
     * @param nomAbrege le nom abrégé de la maladie
     */
    TypeMaladie(String nomComplet, String nomAbrege) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
    }

    /**
     * Retourne le nom complet de la maladie.
     *
     * @return le nom complet de la maladie
     */
    public String getNomComplet() {
        return nomComplet;
    }

    /**
     * Retourne le nom abrégé de la maladie.
     *
     * @return le nom abrégé de la maladie
     */
    public String getNomAbrege() {
        return nomAbrege;
    }
}
