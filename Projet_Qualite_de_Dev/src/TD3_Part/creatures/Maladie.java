package TD3_Part.creatures;

import TD3_Part.values.TypeMaladie;

import java.util.ArrayList;
import java.util.Arrays;

public class Maladie {
    private TypeMaladie type;
    private int niveauActuel;
    private int niveauMax;

    public static ArrayList<TypeMaladie> maladiesList = new ArrayList<>(Arrays.asList(TypeMaladie.values()));

    public Maladie(TypeMaladie type, int niveauMax) {
        this.type = type;
        this.niveauActuel = 0;
        this.niveauMax = niveauMax;
    }

    public String getNomComplet() {
        return type.getNomComplet();
    }

    public String getNomAbrege() {
        return type.getNomAbrege();
    }

    public int getNiveauActuel() {
        return niveauActuel;
    }

    public void setNiveauActuel(int niveauActuel) {
        this.niveauActuel = niveauActuel;
    }

    public int getNiveauMax() {
        return niveauMax;
    }

    public void setNiveauMax(int niveauMax) {
        this.niveauMax = niveauMax;
    }

    public void augmenterNiveau() {
        if (niveauActuel < niveauMax) {
            niveauActuel++;
        }
    }

    public void diminuerNiveau() {
        if (niveauActuel > 0) {
            niveauActuel--;
        }
    }

    public void changerNiveau(int nouveauNiveau) {
        if (nouveauNiveau >= 0 && nouveauNiveau <= niveauMax) {
            niveauActuel = nouveauNiveau;
        } else {
            System.out.println("Niveau invalide. Il doit être compris entre 0 et " + niveauMax + ".");
        }
    }

    public boolean estLethal() {
        return niveauActuel >= niveauMax;
    }

    public void afficherDetails() {
        System.out.println("- Nom complet : " + type.getNomComplet());
        System.out.println("- Nom abrégé : " + type.getNomAbrege());
        System.out.println("- Niveau actuel : " + niveauActuel);
        System.out.println("- Niveau max avant trépas : " + niveauMax);
    }
}