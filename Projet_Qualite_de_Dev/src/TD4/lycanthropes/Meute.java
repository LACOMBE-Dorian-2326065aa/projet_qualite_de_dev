package TD4.lycanthropes;

import TD4.values.TypeRangDomination;
import TD3_Part.values.TypeSexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
    * Classe Meute
    * Permet de créer une meute de lycanthropes
    * Attributs :
        * nom (String) : nom de la meute
        * position (String) : position de la meute
        * lycanthropes (ArrayList<Lycanthrope2>) : liste des lycanthropes de la meute
        * rang (String) : rang des lycanthropes
        * couple (Couple) : couple alpha de la meute
    * Méthodes :
        * getNom() : retourne le nom de la meute
        * setNom(String) : modifie le nom de la meute
        * getPosition() : retourne la position de la meute
        * setPosition(String) : modifie la position de la meute
        * getLycanthropes() : retourne la liste des lycanthropes de la meute
        * setLycanthropes(ArrayList<Lycanthrope2>) : modifie la liste des lycanthropes de la meute
        * getRang() : retourne le rang des lycanthropes
        * setCouple() : attribue un couple alpha à la meute
        * addLycanthrope(Lycanthrope2) : ajoute un lycanthrope à la meute
        * removeLycanthrope(Lycanthrope2) : retire un lycanthrope de la meute
        * orderMeute() : ordonne la meute en fonction des rangs de domination des lycanthropes
        * afficherLycanthropes() : affiche la liste des lycanthropes de la meute
 */
public class Meute {
    private String nom;
    private String position;
    private ArrayList<Lycanthrope2> lycanthropes;
    final private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";
    private Couple couple;
    /**
     * Constructeur de la classe Meute
     * @param nom (String) : nom de la meute
     * @param position (String) : position de la meute
     */
    public Meute(String nom, String position) {
        this.nom = nom;
        this.position = position;
        this.lycanthropes = new ArrayList<>();
    }
    /**
     * Retourne le couple alpha de la meute
     */
    public Couple getCouple() {
        return couple;
    }
    /**
     * Attribue un couple alpha à la meute
     */
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
    
    /**
     * Ajoute un lycanthrope à la meute
     * @param lycanthrope (Lycanthrope2) : lycanthrope à ajouter
     */
    public void addLycanthrope(Lycanthrope2 lycanthrope) {
        lycanthropes.add(lycanthrope);
    }
    /**
     * Retire un lycanthrope de la meute
     * @param lycanthrope (Lycanthrope2) : lycanthrope à retirer
     */
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
    /**
     * Modifie la position de la meute
     * @param position (String) : nouvelle position de la meute
     */
	public void setPosition(String position) {
		this.position = position;
	}
    /**
     * Retourne la liste des lycanthropes de la meute
     */
    public ArrayList<Lycanthrope2> getLycanthropes() {return this.lycanthropes;
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
    /**
     * Retourne le nom de la meute
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom de la meute
     * @param nom (String) : nouveau nom de la meute
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Retourne le rang des lycanthropes
     */
    public String getRang() {
        return rang;
    }
    /**
     * Modifie la liste des lycanthropes de la meute
     * @param lycanthropes (ArrayList<Lycanthrope2>) : nouvelle liste des lycanthropes de la meute
     */
    public void setLycanthropes(ArrayList<Lycanthrope2> lycanthropes) {
        this.lycanthropes = lycanthropes;
    }
    /**
     * Affiche la liste des lycanthropes de la meute
     */
    public void afficherLycanthropes() {
        System.out.println(getNom());
        for (int i = 0; i < lycanthropes.size(); i++) {
            System.out.println(" - " + i + " : " + lycanthropes.get(i).getNom() + " (" + lycanthropes.get(i).getRangDomination().getRangDomination() + ") (" + lycanthropes.get(i).getCategorieAge().getCategorieAge() + ")");
        }
    }
}