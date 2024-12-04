package TD3_Part.values;

/**
 * Enumération représentant les différents types de budget d'un service.
 * Chaque type de budget est associé à un libellé textuel et son nom interne.
 */
public enum TypeBudget {

    /**
     * Type de budget inexistant.
     */
    INEXISTANT("Inexistant"),

    /**
     * Type de budget médiocre.
     */
    MEDIOCRE("Médiocre"),

    /**
     * Type de budget insuffisant.
     */
    INSUFFISANT("Insuffisant"),

    /**
     * Type de budget faible.
     */
    FAIBLE("Faible");

    /**
     * Libellé textuel associé au type de budget.
     */
    private final String label;

    /**
     * Nom interne du type de budget, basé sur la constante de l'énumération.
     */
    private final String nom;

    /**
     * Constructeur de l'énumération {@code TypeBudget}.
     *
     * @param label le libellé textuel associé au type de budget
     */
    TypeBudget(String label) {
        this.label = label;
        this.nom = name();
    }

    /**
     * Retourne le libellé textuel associé au type de budget.
     *
     * @return le libellé du type de budget
     */
    public String getLabel() {
        return label;
    }

    /**
     * Retourne le nom interne du type de budget.
     *
     * @return le nom interne du type de budget
     */
    public String getNom() {
        return nom;
    }
}
