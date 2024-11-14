package TD3_Part;

public class Medecin {
    private String nom;
    private String sexe;
    private int age;

    public Medecin(String nom, String sexe, int age) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
    }

    public void examinerService(ServiceMedical service) {
        service.afficherDetails();
    }

    public void soigner(ServiceMedical service) {
        service.soignerCreatures();
    }
}
