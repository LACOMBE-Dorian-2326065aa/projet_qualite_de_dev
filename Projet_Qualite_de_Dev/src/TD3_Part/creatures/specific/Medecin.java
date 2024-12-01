package TD3_Part.creatures.specific;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.Maladie;
import TD3_Part.main.MedecinActions;
import TD3_Part.values.TypeSexe;

public class Medecin extends Creature implements MedecinActions {

    private String nom;
    private TypeSexe sexe;
    private int age;

    public Medecin(TypeSexe sexe, int age, String nom) {
        super(nom, sexe, age);
        this.sexe = sexe;
        this.age = age;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeSexe getSexe() {
        return sexe;
    }

    public void setSexe(TypeSexe sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void tomberMalade(Maladie maladie) {
        return;
    }
}
