package TD3_Part.values;

public enum TypeBudget {
    INEXISTANT ("Inexistant"),
    MEDIOCRE ("Médiocre"),
    INSUFFISANT ("Insuffisant"),
    FAIBLE ("Faible");

    private final String label;
    private final String nom;

    TypeBudget(String label) {
        this.label = label;
        this.nom = name();
    }

    public String getLabel() {
        return label;
    }

    public String getNom() {
        return nom;
    }

}
