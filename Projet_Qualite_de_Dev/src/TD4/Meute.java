package TD4;
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

    
}
