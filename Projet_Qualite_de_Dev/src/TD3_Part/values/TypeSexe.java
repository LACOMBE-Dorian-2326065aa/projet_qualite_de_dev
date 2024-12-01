package TD3_Part.values;

public enum TypeSexe {
    MALE("Mâle"),
    FEMELLE("Femelle");

    private String categorieSexe;

    TypeSexe(String categorieSexe) {
        this.categorieSexe = categorieSexe;
    }

    public String getCategorieSexe() {
        return categorieSexe;
    }
}
