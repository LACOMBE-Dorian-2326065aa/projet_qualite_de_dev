package TD4;

import TD3_Part.creatures.specific.Lycanthrope;
import TD3_Part.values.TypeRangDomination;
import TD3_Part.values.TypeSexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Meute {
    private String nom;
    private String position;
    private ArrayList<Lycanthrope2> lycanthropes;
    final private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";
    private Couple couple;

    public Meute(String nom, String position) {
        this.nom = nom;
        this.position = position;
        this.lycanthropes = new ArrayList<>();
    }

    public Couple getCouple() {
        return couple;
    }

    public void setCouple() {
        Lycanthrope2 maleAlpha = null;
        Lycanthrope2 femelleAlpha = null;

        for (Lycanthrope2 lycanthrope : lycanthropes) {
            if (lycanthrope.getRangDomination() == TypeRangDomination.RANG_24) {
                if (lycanthrope.getSexe() == TypeSexe.MALE && maleAlpha == null) {
                    maleAlpha = lycanthrope;
                } else if (lycanthrope.getSexe() == TypeSexe.FEMELLE && femelleAlpha == null) {
                    femelleAlpha = lycanthrope;
                }

                if (maleAlpha != null && femelleAlpha != null) {
                    couple = new Couple(maleAlpha, femelleAlpha);
                    break;
                }
            }
        }

        // Vérification si les deux alphas sont trouvés
        if (maleAlpha != null && femelleAlpha != null) {
            couple = new Couple(maleAlpha, femelleAlpha);
        } else {
            System.out.println("Couple alpha introuvable : vérifiez la composition de la meute.");
        }
    }


    public void addLycanthrope(Lycanthrope2 lycanthrope) {
        lycanthropes.add(lycanthrope);
    }

    public void removeLycanthrope(Lycanthrope2 lycanthrope) {
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

    public ArrayList<Lycanthrope2> getLycanthropes() {
        return this.lycanthropes;
    }

    public void orderMeute() {
        Collections.sort(this.lycanthropes, new Comparator<Lycanthrope2>() {
            @Override
            public int compare(Lycanthrope2 l1, Lycanthrope2 l2) {
                return l1.getRangDomination().ordinal() - l2.getRangDomination().ordinal();
            }
        });
        setCouple();
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

    public void setLycanthropes(ArrayList<Lycanthrope2> lycanthropes) {
        this.lycanthropes = lycanthropes;
    }

    public void afficherLycanthropes() {
        System.out.println(getNom());
        for (int i = 0; i < lycanthropes.size(); i++) {
            System.out.println(" - " + i + " : " + lycanthropes.get(i).getNom() + " (" + lycanthropes.get(i).getRangDomination().getRangDomination() + ") (" + lycanthropes.get(i).getCategorieAge().getCategorieAge() + ")");
        }
    }
}
