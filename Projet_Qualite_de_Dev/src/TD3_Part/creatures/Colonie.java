package TD3_Part.creatures;

import TD3_Part.creatures.specific.Lycanthrope;

import java.util.ArrayList;
import java.util.Iterator;

public class Colonie {

    private ArrayList<Meute> meutes;

    public Colonie() {
        this.meutes = new ArrayList<>();
    }

    public ArrayList<Meute> getMeutes() {
        return meutes;
    }

    public void setMeutes(ArrayList<Meute> meutes) {
        this.meutes = meutes;
    }

    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }

    public void retirerMeute(Meute meute) {
        meutes.remove(meute);
    }

    public void afficherLycanthropes() {
        Iterator<Meute> meuteIterator = meutes.iterator();
        System.out.println("Liste des lycanthropes de la colonie : ");
        while (meuteIterator.hasNext()) {
            Meute meute = meuteIterator.next();
            Iterator<Lycanthrope> lycanthropeIterator = meute.getLycanthropes().iterator();

            while (lycanthropeIterator.hasNext()) {
                Lycanthrope lycanthrope = lycanthropeIterator.next();
                lycanthrope.afficherCaracteristiques();
            }
        }
    }

    public void afficherMeutes() {
        if (meutes.size() > 0) {
            Iterator<Meute> meuteIterator = meutes.iterator();
            System.out.println("Liste des meutes de la colonie : ");
            int i = 1;
            while (meuteIterator.hasNext()) {
                Meute meute = meuteIterator.next();
                System.out.println(i + " : " + meute.getNom());
                ++i;
            }
        } else {
            System.out.println("Il n'y a aucune meute dans cette colonie.\n");
        }
    }

    public void creerMeute(String nom, String position) {
        Meute meute = new Meute(nom, position);
        ajouterMeute(meute);
    }

    public void lancerSimulation() {
        // TODO
    }

}
