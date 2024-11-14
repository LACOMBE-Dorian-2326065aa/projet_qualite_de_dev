package TD4;

import java.util.ArrayList;
import java.util.Iterator;

public class Colonie {

    private ArrayList<Meute> meutes;

    public Colonie() {
        this.meutes = new ArrayList<>();
    }

    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

    public void afficherLycanthropes() {
        Iterator<Meute> meuteIterator = meutes.iterator();
        System.out.println("Liste des lycanthropes de la colonie : ");
        while (meuteIterator.hasNext()) {
            Meute meute = meuteIterator.next();
            Iterator<Lycanthrope> lycanthropeIterator = meute.getMeute().iterator();

            while (lycanthropeIterator.hasNext()) {
                Lycanthrope lycanthrope = lycanthropeIterator.next();
                lycanthrope.afficherCaracteristiques();
            }
        }
    }


}
