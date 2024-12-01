package TD3_Part.values;

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
