package TD3_Part.creatures;

import TD3_Part.creatures.specific.Lycanthrope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Meute {
    private String nom;
    private String position;
    private ArrayList<Lycanthrope> lycanthropes;
    final private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";

    public Meute(String nom, String position) {
        this.nom = nom;
        this.position = position;
        this.lycanthropes = new ArrayList<>();
    }

    public void addLycanthrope(Lycanthrope lycanthrope) {
        lycanthropes.add(lycanthrope);
    }

    public void removeLycanthrope(Lycanthrope lycanthrope) {
        for (int i = 0; i < lycanthropes.size(); i++) {
            if (lycanthropes.get(i) == lycanthrope) {
                lycanthropes.remove(i);
                break;
            }
        }
    }

    	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

    public ArrayList<Lycanthrope> getLycanthropes() {
        return this.lycanthropes;
    }

    public void orderMeute(ArrayList<Lycanthrope> meute) {
        Collections.sort(meute, new Comparator<Lycanthrope>() {
            @Override
            public int compare(Lycanthrope l1, Lycanthrope l2) {
                return l1.getRangDomination().ordinal() - l2.getRangDomination().ordinal();
            }
        });
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRang() {
        return rang;
    }

    public void setLycanthropes(ArrayList<Lycanthrope> lycanthropes) {
        this.lycanthropes = lycanthropes;
    }

    public void afficherLycanthropes() {
        for (int i = 0; i < lycanthropes.size(); i++) {
            lycanthropes.get(i).afficherCaracteristiques();
        }
    }
}
