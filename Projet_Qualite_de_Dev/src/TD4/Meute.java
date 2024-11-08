package TD4;

import java.util.Arrays;
import java.util.Comparator;

public class Meute {
    private String nom;
    private String position;
    private Lycanthrope[] meute;
    private String rang = "αβγδεζηθικλμνξοπρστυϕχψω";

    

    public void  addLycanthrope(Lycanthrope lycanthrope, Lycanthrope[] meute) {
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
    public Meute getMeute() {
        return this;
    }

    public void orderMeute() {
        Arrays.sort(meute, new Comparator<Lycanthrope>() {
            @Override
            public int compare(Lycanthrope l1, Lycanthrope l2) {
                if (l1 == null && l2 == null) return 0;
                if (l1 == null) return 1;
                if (l2 == null) return -1;
                return rang.indexOf(l1.getRangDomination()) - rang.indexOf(l2.getRangDomination());
            }
        });
    }

    
}
