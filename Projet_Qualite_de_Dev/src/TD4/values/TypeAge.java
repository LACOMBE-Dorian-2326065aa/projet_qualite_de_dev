package TD4.values;

/**
 * L'énumération TypeAge représente différentes catégories d'âge.
 * Chaque instance de cette énumération a une chaîne de caractères associée
 * qui décrit la catégorie d'âge.
 * <p>
 * Les catégories d'âge disponibles sont :
 * <ul>
 *   <li>{@link #JEUNE} - Représente une personne jeune.</li>
 *   <li>{@link #ADULTE} - Représente une personne adulte.</li>
 *   <li>{@link #VIEUX} - Représente une personne âgée.</li>
 * </ul>
 */
public enum TypeAge {
    JEUNE ("Jeune"),
    ADULTE ("Adulte"),
    VIEUX ("Vieux");

    private String categorieAge;

    TypeAge(String categorieAge) {
        this.categorieAge = categorieAge;
    }

    public String getCategorieAge() {
        return categorieAge;
    }
}
