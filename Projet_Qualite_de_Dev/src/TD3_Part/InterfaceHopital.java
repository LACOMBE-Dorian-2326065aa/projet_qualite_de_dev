package TD3_Part;

import TD3_Part.creatures.Creature;
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
                    reviserBudget();
                    actions--;
                    break;
                case "4":
                    transfererCreature();
                    actions--;
                    break;
                case "5":
                    System.out.println("Tour passé.");
                    actions = 0;
                    break;
                case "6":
                    quitter();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (!choix.equals("6") && actions > 0);
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
        System.out.println("Entrez votre choix (Actions : " + actions + " / 3) : ");
    }

    private static void soignerCreatures() {
        for (ServiceMedical service : hopital.getServices()) {
            service.soignerCreatures();
        }
        System.out.println("Toutes les créatures ont été soignées.");
    }

    private static void examinerService() {
        if (hopital.getServices().isEmpty()) {
            System.out.println("Aucun service médical disponible.");
            return;
        }
        System.out.print("Quel service voulez-vous examiner : ");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + ". " + service.getNom());
            count++;
        }
        int choix = getNumero(count);
        hopital.getServices().get(choix - 1).afficherDetails();
    }

    private static void reviserBudget() {
        if (hopital.getServices().isEmpty()) {
            System.out.println("Aucun service médical disponible.");
            return;
        }
        System.out.print("Quel service voulez-vous réviser le budget : ");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + ". " + service.getNom());
            count++;
        }
        int choix = getNumero(count);
        ServiceMedical service = hopital.getServices().get(choix - 1);
        System.out.print("Entrez le nouveau budget pour " + service.getNom() + " : ");
        String budget = scanner.nextLine();
        service.setBudget(budget);
        System.out.println("Le budget de " + service.getNom() + " a été révisé à " + budget);
    }

    private static void transfererCreature() {
        System.out.println("Choisissez une créature à transférer :");
        int count = 1;
        ArrayList<Creature> creatures = new ArrayList<>();
        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                System.out.println(count + ". " + creature.getNom() + " (" + service.getNom() + ")");
                creatures.add(creature);
                count++;
            }
        }
        int choixCreature = getNumero(count);
        Creature creatureChosen = creatures.get(choixCreature - 1);
        int count2 = 1;
        ServiceMedical initialService = null;
        for (ServiceMedical service : hopital.getServices()) {
            if (service.getCreatures().contains(creatureChosen)) {
                initialService = service;
                break;
            }
        }
        System.out.println("Choisissez le service médical de destination :");
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count2 + ". " + service.getNom());
            count2++;
        }
        int choixService = getNumero(count2);
        ServiceMedical newService = hopital.getServices().get(choixService - 1);
        initialService.getCreatures().remove(creatureChosen);
        newService.getCreatures().add(creatureChosen);
        System.out.println("La créature " + creatureChosen.getNom() + " a été déplacée de " + initialService.getNom() + " à " + newService.getNom() + " !");
    }

    private static void quitter() {
        System.out.println("Merci d'avoir utilisé l'interface de l'Hôpital Fantastique. Au revoir !");
    }

    public static int getNumero(int max) {
        String input;
        int number = -1;

        while (true) {
            input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                if (number > 0 && number <= max) {
                    break;
                } else {
                    System.out.println("Veuillez entrer un numéro valide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro valide.");
            }
        }

        return number;
    }

    public static void resetActions() {
        actions = 3;
    }
}