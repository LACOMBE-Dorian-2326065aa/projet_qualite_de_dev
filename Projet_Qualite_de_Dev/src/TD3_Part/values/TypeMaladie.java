package TD3_Part.values;

public enum TypeMaladie {
    MDC("Maladie débilitante chronique", "MDC"),
    FOMO("Syndrome fear of missing out", "FOMO"),
    DRS("Dépendance aux réseaux sociaux", "DRS"),
    PEC("Porphyrie érythropoïétique congénitale", "PEC"),
    ZPL("Zoopathie paraphrénique lycanthropique", "ZPL"),
    NDMAD("Nécrose Dégénérative des Membres et des Articulations Dorsales", "NDMAD");

    private final String nomComplet;
    private final String nomAbrege;

    TypeMaladie(String nomComplet, String nomAbrege) {
        this.nomComplet = nomComplet;
        this.nomAbrege = nomAbrege;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public String getNomAbrege() {
        return nomAbrege;
    }
}
