package TD4.lycanthropes;

import TD3_Part.values.TypeSexe;
import TD4.values.TypeRangDomination;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
* La classe Colonie représente une colonie de meutes de lycanthropes.
* Elle permet de gérer les meutes et leurs interactions.
*/
/**
 * La classe Colonie représente une colonie de lycanthropes composée de plusieurs meutes.
 * Elle permet de gérer les meutes, d'ajouter ou de retirer des meutes, et d'initialiser la colonie avec des meutes prédéfinies.
 * La classe offre également des méthodes pour afficher les caractéristiques des lycanthropes et des meutes, 
 * ainsi que pour lancer une simulation de la colonie avec des événements aléatoires et des commandes utilisateur.
 */
public class Colonie {
    
    private int interval = 30;
    public static String events;
    private ArrayList<Meute> meutes;
    
    /**
    * Constructeur de la classe Colonie.
    * Initialise une nouvelle colonie avec une liste vide de meutes.
    */
    public Colonie() {
        this.meutes = new ArrayList<>();
    }
    
    /**
    * Obtient la liste des meutes de la colonie.
    *
    * @return La liste des meutes.
    */
    public ArrayList<Meute> getMeutes() {
        return meutes;
    }
    
    /**
    * Définit la liste des meutes de la colonie.
    *
    * @param meutes La nouvelle liste des meutes.
    */
    public void setMeutes(ArrayList<Meute> meutes) {
        this.meutes = meutes;
    }
    
    /**
    * Ajoute une meute à la colonie.
    *
    * @param meute La meute à ajouter.
    */
    public void ajouterMeute(Meute meute) {
        meutes.add(meute);
    }
    
    /**
    * Retire une meute de la colonie.
    *
    * @param meute La meute à retirer.
    */
    public void retirerMeute(Meute meute) {
        meutes.remove(meute);
    }
    
    /**
    * Initialise la colonie avec des meutes prédéfinies et leurs lycanthropes.
    */
    public void init() {
        Meute meute1 = new Meute("Meute 1", "Forêt");
        Meute meute2 = new Meute("Meute 2", "Désert");
        Meute meute3 = new Meute("Meute 3", "Plaines");
        Meute meute4 = new Meute("Meute 4", "Montagnes");
        
        addLycanthropesMeute1(meute1);
        addLycanthropesMeute2(meute2);
        addLycanthropesMeute3(meute3);
        addLycanthropesMeute4(meute4);
        
        ajouterMeute(meute1);
        ajouterMeute(meute2);
        ajouterMeute(meute3);
        ajouterMeute(meute4);
    }
    /**
    * Ajoute des lycanthropes à la première meute.
    *
    * @param meute La meute à laquelle ajouter les lycanthropes.
    */
    private void addLycanthropesMeute1(Meute meute) {
        meute.addLycanthrope(new Lycanthrope2("Fenrir", TypeSexe.MALE, 65.5, 1.8, 30, 25, 15, TypeRangDomination.RANG_1, 10, meute)); // RANG_1
        meute.addLycanthrope(new Lycanthrope2("Luna", TypeSexe.FEMELLE, 58.0, 1.7, 25, 20, 12, TypeRangDomination.RANG_24, 30, meute)); // ALPHA FEMELLE
        meute.addLycanthrope(new Lycanthrope2("Thor", TypeSexe.MALE, 70.0, 1.9, 35, 30, 18, TypeRangDomination.RANG_24, 30, meute)); // ALPHA MÂLE
        meute.addLycanthrope(new Lycanthrope2("Nyx", TypeSexe.FEMELLE, 55.0, 1.6, 15, 18, 10, TypeRangDomination.RANG_4, 6, meute));
        meute.addLycanthrope(new Lycanthrope2("Ragnar", TypeSexe.MALE, 75.0, 2.0, 40, 35, 20, TypeRangDomination.RANG_5, 14, meute));
        meute.addLycanthrope(new Lycanthrope2("Selene", TypeSexe.FEMELLE, 60.0, 1.7, 28, 22, 14, TypeRangDomination.RANG_6, 9, meute));
    }
    
    /**
    * Ajoute des lycanthropes à la deuxième meute.
    *
    * @param meute La meute à laquelle ajouter les lycanthropes.
    */
    private void addLycanthropesMeute2(Meute meute) {
        meute.addLycanthrope(new Lycanthrope2("Anubis", TypeSexe.MALE, 68.0, 1.85, 27, 28, 17, TypeRangDomination.RANG_1, 11, meute)); // RANG_1
        meute.addLycanthrope(new Lycanthrope2("Bastet", TypeSexe.FEMELLE, 55.5, 1.65, 24, 19, 10, TypeRangDomination.RANG_24, 28, meute)); // ALPHA FEMELLE
        meute.addLycanthrope(new Lycanthrope2("Ra", TypeSexe.MALE, 72.0, 1.92, 31, 32, 19, TypeRangDomination.RANG_24, 28, meute)); // ALPHA MÂLE
        meute.addLycanthrope(new Lycanthrope2("Isis", TypeSexe.FEMELLE, 58.5, 1.72, 29, 23, 15, TypeRangDomination.RANG_4, 10, meute));
        meute.addLycanthrope(new Lycanthrope2("Osiris", TypeSexe.MALE, 80.0, 2.1, 45, 40, 25, TypeRangDomination.RANG_5, 18, meute));
        meute.addLycanthrope(new Lycanthrope2("Hathor", TypeSexe.FEMELLE, 62.0, 1.75, 11, 21, 13, TypeRangDomination.RANG_6, 8, meute));
    }
    
    /**
    * Ajoute des lycanthropes à la troisième meute.
    *
    * @param meute La meute à laquelle ajouter les lycanthropes.
    */
    private void addLycanthropesMeute3(Meute meute) {
        meute.addLycanthrope(new Lycanthrope2("Aquila", TypeSexe.MALE, 67.5, 1.88, 32, 29, 16, TypeRangDomination.RANG_1, 10, meute)); // RANG_1
        meute.addLycanthrope(new Lycanthrope2("Lyra", TypeSexe.FEMELLE, 54.0, 1.63, 23, 17, 8, TypeRangDomination.RANG_24, 25, meute)); // ALPHA FEMELLE
        meute.addLycanthrope(new Lycanthrope2("Draco", TypeSexe.MALE, 73.0, 1.93, 28, 34, 19, TypeRangDomination.RANG_24, 25, meute)); // ALPHA MÂLE
        meute.addLycanthrope(new Lycanthrope2("Vega", TypeSexe.FEMELLE, 59.0, 1.68, 26, 21, 11, TypeRangDomination.RANG_4, 7, meute));
        meute.addLycanthrope(new Lycanthrope2("Orion", TypeSexe.MALE, 77.0, 2.05, 10, 36, 22, TypeRangDomination.RANG_5, 15, meute));
        meute.addLycanthrope(new Lycanthrope2("Andromeda", TypeSexe.FEMELLE, 63.5, 1.77, 27, 24, 14, TypeRangDomination.RANG_6, 9, meute));
    }
    
    /**
    * Ajoute des lycanthropes à la quatrième meute.
    *
    * @param meute La meute à laquelle ajouter les lycanthropes.
    */
    private void addLycanthropesMeute4(Meute meute) {
        meute.addLycanthrope(new Lycanthrope2("Atlas", TypeSexe.MALE, 70.0, 1.9, 33, 30, 18, TypeRangDomination.RANG_1, 12, meute)); // RANG_1
        meute.addLycanthrope(new Lycanthrope2("Gaia", TypeSexe.FEMELLE, 57.0, 1.64, 24, 18, 9, TypeRangDomination.RANG_24, 35, meute)); // ALPHA FEMELLE
        meute.addLycanthrope(new Lycanthrope2("Hyperion", TypeSexe.MALE, 74.0, 1.95, 8, 35, 20, TypeRangDomination.RANG_24, 35, meute)); // ALPHA MÂLE
        meute.addLycanthrope(new Lycanthrope2("Theia", TypeSexe.FEMELLE, 60.0, 1.69, 27, 22, 12, TypeRangDomination.RANG_4, 8, meute));
        meute.addLycanthrope(new Lycanthrope2("Cronos", TypeSexe.MALE, 85.0, 2.15, 50, 45, 28, TypeRangDomination.RANG_5, 20, meute));
        meute.addLycanthrope(new Lycanthrope2("Rhea", TypeSexe.FEMELLE, 65.0, 1.75, 30, 25, 15, TypeRangDomination.RANG_6, 10, meute));
    }
    /**
     * Affiche les caractéristiques de tous les lycanthropes de la colonie.
     * Cette méthode parcourt toutes les meutes de la colonie et affiche les
     * caractéristiques de chaque lycanthrope présent dans chaque meute.
     */
    public void afficherLycanthropes() {
        Iterator<Meute> meuteIterator = meutes.iterator();
        System.out.println("Liste des lycanthropes de la colonie : ");
        while (meuteIterator.hasNext()) {
            Meute meute = meuteIterator.next();
            Iterator<Lycanthrope2> lycanthropeIterator = meute.getLycanthropes().iterator();
            
            while (lycanthropeIterator.hasNext()) {
                Lycanthrope2 lycanthrope = lycanthropeIterator.next();
                lycanthrope.afficherCaracteristiques();
            }
        }
    }
    
    /**
     * Affiche la liste des meutes de la colonie.
     * Si la colonie contient des meutes, elles sont affichées avec leur nom et leur position dans la liste.
     * Sinon, un message indiquant qu'il n'y a aucune meute est affiché.
     */
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
    
    /**
     * Creates a new pack (Meute) with the specified name and position, and adds it to the colony.
     *
     * @param nom the name of the pack
     * @param position the position of the pack
     */
    public void creerMeute(String nom, String position) {
        Meute meute = new Meute(nom, position);
        ajouterMeute(meute);
    }
    
    /**
     * Lance la simulation de la colonie de lycanthropes.
     * 
     * Cette méthode crée deux threads :
     * 
     * 1. Un thread pour simuler les événements de la colonie :
     *    - Incrémente un compteur à chaque itération.
     *    - Tous les trois cycles, chaque meute effectue une reproduction.
     *    - Chaque meute effectue des actions spécifiques et affiche les lycanthropes.
     *    - Simule des événements aléatoires et affiche les événements.
     *    - Attend un intervalle de temps spécifié avant de recommencer.
     * 
     * 2. Un thread pour gérer les commandes de l'utilisateur :
     *    - Lit les commandes de l'utilisateur depuis l'entrée standard.
     *    - Gère la commande "/hurlement [nom]" pour faire hurler un lycanthrope spécifique.
     *    - Gère la commande "/domination [dominateur] [dominé]" pour faire hurler un lycanthrope dominateur sur un lycanthrope dominé.
     *    - Affiche des messages d'erreur si les commandes sont invalides ou si les lycanthropes spécifiés ne sont pas trouvés.
     */
    public void lancerSimulation() {
        
        Thread thread1 = new Thread(() -> {
            int count = 0;
            while (true) {
                count++;
                events = "";
                for (Meute meute : getMeutes()) {
                    if (count % 3 == 0) {
                        meute.getCouple().reproduction();
                    }
                    meute.orderMeute();
                    meute.afficherLycanthropes();
                }
                simulerEvenementsAleatoires();
                System.out.println(events);
                try {
                    Thread.sleep(interval * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Thread pour les actions de l'utilisateur
        Thread thread2 = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String command = scanner.nextLine();
                boolean trouve = false;
                boolean trouve2 = false;
                if (command.toLowerCase().startsWith("/hurlement")) {
                    events = "";
                    String[] args = command.split(" ");
                    if (args.length == 1) {
                        for (Meute meute : getMeutes()) {
                            for (Lycanthrope2 lycanthrope : meute.getLycanthropes()) {
                                if (lycanthrope.getNom().toLowerCase().equals(args[1].toLowerCase())) {
                                    trouve = true;
                                    lycanthrope.hurler();
                                    System.out.println(events);
                                    events = "";
                                }
                            }
                        }
                        if (!trouve) {
                            System.out.println("Erreur : aucun Lycanthrope de ce nom trouvé.\n");
                        }
                    }
                } else if (command.toLowerCase().startsWith("/domination")) {
                    events = "";
                    String[] args = command.split(" ");
                    if (args.length == 3) {
                        String dominateurNom = args[1].toLowerCase();
                        String domineNom = args[2].toLowerCase();
                        boolean dominateurTrouve = false;
                        boolean domineTrouve = false;
                        Lycanthrope2 dominateur = null;
                        Lycanthrope2 domine = null;

                        for (Meute meute : getMeutes()) {

                            for (Lycanthrope2 lycanthrope : meute.getLycanthropes()) {
                                if (lycanthrope.getNom().toLowerCase().equals(dominateurNom)) {
                                    dominateur = lycanthrope;
                                    dominateurTrouve = true;
                                }
                                if (lycanthrope.getNom().toLowerCase().equals(domineNom)) {
                                    domine = lycanthrope;
                                    domineTrouve = true;
                                }

                                if (dominateur != null && domine != null) {
                                    break;
                                }
                            }
                        }

                        if (dominateur != null && domine != null) {
                            if (dominateur.getMeute() == domine.getMeute()) {
                                dominateur.hurlerDomination(domine);
                                System.out.println(events);
                                events = "";
                            } else {
                                System.out.println("Erreur : les deux lycanthropes ne sont pas dans la même meute.\n");
                            }
                        }

                        if (!dominateurTrouve) {
                            System.out.println("Erreur : dominateur '" + args[1] + "' introuvable.\n");
                        }
                        if (!domineTrouve) {
                            System.out.println("Erreur : dominé '" + args[2] + "' introuvable.\n");
                        }
                        if (!dominateurTrouve || !domineTrouve) {
                            System.out.println("Si les noms sont corrects, vérifiez qu'ils sont bien dans la même meute.\n");
                        }
                    } else {
                        System.out.println("Erreur : commande invalide. Utilisation correcte : /domination [dominateur] [dominé]\n");
                    }
                } else {
                    System.out.println("Commande inconnue.\n");
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
    }


/**
 * Simule des événements aléatoires pour chaque lycanthrope dans chaque meute de la colonie.
 * Pour chaque lycanthrope, il y a une chance de 50% qu'il hurle et une chance de 50% qu'il vieillisse.
 */
public void simulerEvenementsAleatoires() {
    for (Meute meute : getMeutes()) {
        for (Lycanthrope2 lycanthrope : meute.getLycanthropes()) {
            if (Math.random() <= 0.5) {
                lycanthrope.hurler();
            }
            
            if (Math.random() <= 0.5) {
                lycanthrope.vieillir();
            }
        }
    }
}

}
