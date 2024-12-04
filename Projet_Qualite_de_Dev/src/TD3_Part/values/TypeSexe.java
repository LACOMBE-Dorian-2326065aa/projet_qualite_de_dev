package TD3_Part.values;

/**
 * Enumération représentant les types de sexe avec leur catégorie associée.
 */
public enum TypeSexe {

    /**
     * Sexe mâle.
     */
    MALE("Mâle"),

    /**
     * Sexe femelle.
     */
    FEMELLE("Femelle");

    /**
     * Catégorie de sexe associée.
     */
    private final String categorieSexe;

    /**
     * Constructeur de l'énumération {@code TypeSexe}.
     *
     * @param categorieSexe la catégorie de sexe associée
     */
    TypeSexe(String categorieSexe) {
        this.categorieSexe = categorieSexe;
    }

    /**
     * Retourne la catégorie de sexe associée.
     *
     * @return la catégorie de sexe
     */
    public String getCategorieSexe() {
        return categorieSexe;
    }
}
