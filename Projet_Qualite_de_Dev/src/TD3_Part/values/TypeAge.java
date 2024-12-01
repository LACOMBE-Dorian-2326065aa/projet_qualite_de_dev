package TD3_Part.values;

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
