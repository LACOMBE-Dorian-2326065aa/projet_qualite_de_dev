package TD3_Part;

import java.util.Scanner;

public class Interface {
    private static HopitalFantastique hopital;

    public static void main(String[] args) {
        hopital = new HopitalFantastique("Hôpital Fantastique");
        initialiserHopital();

        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    afficherDetailsHopital();
                    break;
                case 2:
                    soignerCreatures();
                    break;
                case 3:
                    examinerService(scanner);
                    break;
                case 4:
                    ajouterCreature(scanner);
                    break;
                case 5:
                    tomberMalade(scanner);
                    break;
                case 6:
                    quitter();
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 6);

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu de l'Hôpital Fantastique ---");
        System.out.println("1. Afficher les détails de l'hôpital");
        System.out.println("2. Soigner toutes les créatures");
        System.out.println("3. Examiner un service médical");
        System.out.println("4. Ajouter une créature à un service médical");
        System.out.println("5. Faire tomber malade une créature");
        System.out.println("6. Quitter");
        System.out.print("Entrez votre choix : ");
    }

    private static void initialiserHopital() {
        // Création des services médicaux
        ServiceMedical service1 = new ServiceMedical("Service des Zombies", 500.0, 10, "100000");
        ServiceMedical service2 = new ServiceMedical("Service des Vampires", 300.0, 5, "50000");
        ServiceMedical service3 = new ServiceMedical("Service des Orques", 400.0, 8, "75000");

        // Ajout des services à l'hôpital
        hopital.ajouterService(service1);
        hopital.ajouterService(service2);
        hopital.ajouterService(service3);

        // Création des médecins
        Medecin medecin1 = new Medecin("Dr. Frankenstein", "Homme", 45);
        Medecin medecin2 = new Medecin("Dr. Acula", "Femme", 38);

        // Ajout des médecins à l'hôpital
        hopital.ajouterMedecin(medecin1);
        hopital.ajouterMedecin(medecin2);
    }

    private static void afficherDetailsHopital() {
        hopital.afficherCreatures();
    }

    private static void soignerCreatures() {
        for (ServiceMedical service : hopital.getServices()) {
            service.soignerCreatures();
        }
        System.out.println("Toutes les créatures ont été soignées.");
    }

    private static void examinerService(Scanner scanner) {
        System.out.print("Entrez le nom du service à examiner : ");
        String nomService = scanner.nextLine();
        for (ServiceMedical service : hopital.getServices()) {
            if (service.getNom().equalsIgnoreCase(nomService)) {
                service.afficherDetails();
                return;
            }
        }
        System.out.println("Service non trouvé.");
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
                    creature.tomberMalade(maladie);
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
}