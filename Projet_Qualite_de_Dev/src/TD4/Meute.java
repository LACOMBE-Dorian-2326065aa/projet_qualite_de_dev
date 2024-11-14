package TD4;

import java.util.ArrayList;

public class Meute {
    private String nom;
    private String position;
    private ArrayList<Lycanthrope> meute;
    final private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";

    public Meute(String nom, String position) {
        this.nom = nom;
        this.position = position;
        this.meute = new ArrayList<>();
    }

    public void addLycanthrope(Lycanthrope lycanthrope) {
        meute.add(lycanthrope);
    }

    public void removeLycanthrope(Lycanthrope lycanthrope) {
        for (int i = 0; i < meute.size(); i++) {
            if (meute.get(i) == lycanthrope) {
                meute.remove(i);
                break;
            }
        }
    }

    public ArrayList<Lycanthrope> getMeute() {
        return this.meute;
    }

    public void orderMeute(ArrayList<Lycanthrope> meute) {
        for (int i = 0; i < meute.size(); i++) {
            for (int j = 0; j < meute.size(); j++) {
                if (rang.indexOf(meute.get(i).getRangDomination()) < rang.indexOf(meute.get(j).getRangDomination())) {
                    Lycanthrope temp = meute.get(i);
                    meute.set(i, meute.get(j));
                    meute.set(j, temp);
                }
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRang() {
        return rang;
    }

    public void setMeute(ArrayList<Lycanthrope> meute) {
        this.meute = meute;
    }

    public void afficherLycanthropes() {
        // TODO
    }
}
