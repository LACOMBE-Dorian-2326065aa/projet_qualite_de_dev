package TD3_Part;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceHopital {
    private static HopitalFantastique hopital;
    private static int actions;
    private static final Scanner scanner = new Scanner(System.in);

    public InterfaceHopital(HopitalFantastique hopital) {
        InterfaceHopital.hopital = hopital;
        actions = 3;
    }

    public void init() {
        actions = 3;
        String choix;

        do {
            afficherMenu();
            choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    soignerCreatures();
                    actions--;
                    break;
                case "2":
                    examinerService();
                    actions--;
                    break;
                case "3":
                    ajouterCreature(scanner);
                    actions--;
                    break;
                case "4":
                    transfererCreature();
                    actions--;
                    break;
                case "5":
                    actions = 0;
                    break;
                case "6":
                    quitter();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != "6" && actions > 0);
        System.out.println("Vous n'avez plus d'action disponible.");
    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu de l'Hôpital Fantastique ---");
        System.out.println("1. Soigner toutes les créatures d'un service médical (1 action)");
        System.out.println("2. Examiner un service médical (1 action)");
        System.out.println("3. Réviser le budget d'un service médical (1 action)");
        System.out.println("4. Transférer une créature d'un service médical à un autre (1 action)");
        System.out.println("5. Passer le tour");
        System.out.println("6. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void afficherDetailsHopital(Scanner scanner) {
        System.out.println("\n--- Liste des services médicaux ---");
        int index = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(index + ". " + service.getNom());
            index++;
        }
        System.out.print("Sélectionnez un service pour afficher les détails (entrez le numéro) : ");
        int choixService = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (choixService > 0 && choixService <= hopital.getServices().size()) {
            ServiceMedical serviceSelectionne = hopital.getServices().get(choixService - 1);
            serviceSelectionne.afficherDetails();
        } else {
            System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    private static void soignerCreatures() {
        for (ServiceMedical service : hopital.getServices()) {
            service.soignerCreatures();
        }
        System.out.println("Toutes les créatures ont été soignées.");
    }

    private static void examinerService() {
        if (hopital.getServices().isEmpty()) {
            System.out.println("Il n'y a aucun service.");
            return;
        }
        System.out.print("Quel service voulez-vous examiner : ");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + " : " + service.getNom());
            count++;
        }
        int choix = getNumero(count);
        hopital.getServices().get(choix).afficherDetails();
        actions--;
    }

    private static void ajouterCreature(Scanner scanner) {
        System.out.print("Entrez le type de créature (Zombie, Vampire, Orques, Elfe) : ");
        String type = scanner.nextLine();
        System.out.print("Entrez le nom de la créature : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le sexe de la créature : ");
        String sexe = scanner.nextLine();
        System.out.print("Entrez le poids de la créature : ");
        double poids = scanner.nextDouble();
        System.out.print("Entrez la taille de la créature : ");
        double taille = scanner.nextDouble();
        System.out.print("Entrez l'âge de la créature : ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Creature creature = null;
        switch (type.toLowerCase()) {
            case "zombie":
                creature = new Zombie(nom, sexe, poids, taille, age);
                break;
            case "vampire":
                creature = new Vampire(nom, sexe, poids, taille, age);
                break;
            case "orques":
                creature = new Orques(nom, sexe, poids, taille, age);
                break;
            case "elfe":
                creature = new Elfe(nom, sexe, poids, taille, age);
                break;
            default:
                System.out.println("Type de créature invalide.");
                return;
        }

        System.out.print("Entrez le nom du service médical : ");
        String nomService = scanner.nextLine();
        for (ServiceMedical service : hopital.getServices()) {
            if (service.getNom().equalsIgnoreCase(nomService)) {
                service.ajouterCreature(creature);
                System.out.println("Créature ajoutée au service " + nomService);
                return;
            }
        }
        System.out.println("Service non trouvé.");
    }

    private static void tomberMalade(Scanner scanner) {
        System.out.print("Entrez le nom de la créature : ");
        String nomCreature = scanner.nextLine();
        System.out.print("Entrez le nom de la maladie : ");
        String maladie = scanner.nextLine();

        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                if (creature.getNom().equalsIgnoreCase(nomCreature)) {
                    // TODO
//                    creature.tomberMalade(maladie);
                    System.out.println("La créature " + nomCreature + " est tombée malade de " + maladie);
                    return;
                }
            }
        }
        System.out.println("Créature non trouvée.");
    }

    private static void quitter() {
        System.out.println("Merci d'avoir utilisé l'interface de l'Hôpital Fantastique. Au revoir !");
    }

    public static int getNumero(int max) {
        String input;
        int number = -1;

        while (true) {
            input = scanner.nextLine();

            if (input.matches("\\d+")) {
                number = Integer.parseInt(input);

                if (number >= 1 && number <= max) {
                    break;
                } else {
                    System.out.println("Erreur : le nombre doit être entre 1 et " + max + ".");
                }
            } else {
                System.out.println("Erreur : entrez un nombre entier valide.");
            }
        }

        return number;
    }

    public static void transfererCreature() {
        System.out.println("Choisissez une créature à transférer :");
        int count = 0;
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                System.out.println(count + " : " + creature.getNom());
                creatures.add(creature);
            }
        }
        int choixCreature = getNumero(count);
        Creature creatureChosen = creatures.get(choixCreature);

    }
}