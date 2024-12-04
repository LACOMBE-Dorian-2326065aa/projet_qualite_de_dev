package TD4.values;

/**
 * L'énumération TypeHurlement représente différents types de hurlements avec leur catégorie associée.
 * Chaque type de hurlement a une catégorie spécifique qui lui est attribuée.
 * 
 * <ul>
 *   <li>APPARTENANCE - "Appartenance"</li>
 *   <li>DOMINATION - "Domination"</li>
 *   <li>SOUMISSION - "Soumission"</li>
 *   <li>AGRESSIVITE - "Agressivité"</li>
 * </ul>
 * 
 * @param categorieHurlement La catégorie du hurlement.
 */
public enum TypeHurlement {
    APPARTENANCE("Appartenance"),
    DOMINATION("Domination"),
    SOUMISSION("Soumission"),
    AGRESSIVITE("Agressivité");

    private String categorieHurlement;

    TypeHurlement(String categorieHurlement) {
        this.categorieHurlement = categorieHurlement;
    }

    public String getCategorieHurlement() {
        return categorieHurlement;
    }
}
