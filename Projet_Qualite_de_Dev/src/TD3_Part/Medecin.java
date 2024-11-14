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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void examinerService(ServiceMedical service) {
        service.afficherDetails();
    }

    public void soigner(ServiceMedical service) {
        service.soignerCreatures();
    }
}
