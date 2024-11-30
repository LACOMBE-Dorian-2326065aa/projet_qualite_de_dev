package TD3_Part.main;

import java.util.Scanner;

public class InterfaceHopital implements MedecinActions {
    private static HopitalFantastique hopital;
    private static int actions;
    private static final Scanner scanner = new Scanner(System.in);

    public InterfaceHopital(HopitalFantastique hopital) {
        InterfaceHopital.hopital = hopital;
        actions = 2;
    }

    public void init() {
        actions = 2;
        String choix;

        do {

            afficherMenu();
            choix = scanner.nextLine();

            if (actions == 0) {
                System.out.println("[⛔] Vous n'avez plus d'action disponible.");
                continue;
            }

            switch (choix) {
                case "1":
                    MedecinActions.super.soigner(hopital);
                    actions--;
                    break;
                case "2":
                    MedecinActions.super.examinerService(hopital);
                    actions--;
                    break;
                case "3":
                    MedecinActions.super.reviserBudget(hopital);
                    actions--;
                    break;
                case "4":
                    MedecinActions.super.transfererCreature(hopital);
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
                    System.out.println("[🈳] Choix invalide. Veuillez réessayer.");
            }
        } while (!choix.equals("6"));
    }

    private static void afficherMenu() {
        System.out.println("\n--- Menu de l'Hôpital Fantastique ---");
        System.out.println("1. Soigner toutes les créatures d'un service médical (1 action)");
        System.out.println("2. Examiner un service médical (1 action)");
        System.out.println("3. Réviser le budget d'un service médical (1 action)");
        System.out.println("4. Transférer une créature d'un service médical à un autre (1 action)");
        System.out.println("5. Passer le tour");
        System.out.println("6. Quitter");
        System.out.println("Entrez votre choix (Actions : " + actions + " / 2) : ");
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
                if (number > 0 && number < max) {
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
        actions = 2;
        System.out.println("[🧑‍⚕️] Nombre d'actions réinitialisé à 2 !\n");
    }
}