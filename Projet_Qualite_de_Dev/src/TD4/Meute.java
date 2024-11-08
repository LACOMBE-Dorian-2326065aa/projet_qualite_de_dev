package TD4;

import java.util.ArrayList;

public class Meute {
    private String nom;
    private String position;
    private ArrayList<Lycanthrope> meute;
    private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";

    public void addLycanthrope(Lycanthrope lycanthrope, Lycanthrope[] meute) {
        for (int i = 0; i < meute.length; i++) {
            if (meute[i] == null) {
                meute[i] = lycanthrope;
                break;
            }
        }
    }

    public void removeLycanthrope(Lycanthrope lycanthrope, Lycanthrope[] meute) {
        for (int i = 0; i < meute.length; i++) {
            if (meute[i] == lycanthrope) {
                meute[i] = null;
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
}
