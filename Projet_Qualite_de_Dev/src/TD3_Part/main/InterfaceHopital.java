package TD3_Part.main;

import java.util.Scanner;

/**
 * La classe {@code InterfaceHopital} fournit une interface interactive pour gérer les opérations
 * d'un hôpital fantastique. Elle permet au joueur d'effectuer diverses actions en tant que médecin,
 * comme soigner, examiner ou gérer les créatures et les services de l'hôpital.
 *
 * Cette classe implémente l'interface {@code MedecinActions} pour exécuter les actions médicales.
 */
public class InterfaceHopital implements MedecinActions {
    private static HopitalFantastique hopital;
    private static int actions;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Constructeur de la classe {@code InterfaceHopital}.
     *
     * @param hopital L'objet {@code HopitalFantastique} associé à cette interface.
     */
    public InterfaceHopital(HopitalFantastique hopital) {
        InterfaceHopital.hopital = hopital;
        actions = 2;
    }

    /**
     * Initialise l'interface et démarre le menu principal permettant de gérer les opérations
     * sur l'hôpital fantastique.
     */
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

    /**
     * Affiche le menu principal des actions disponibles dans l'hôpital.
     */
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

    /**
     * Affiche un message de remerciement et termine l'exécution de l'interface.
     */
    private static void quitter() {
        System.out.println("Merci d'avoir utilisé l'interface de l'Hôpital Fantastique. Au revoir !");
    }

    /**
     * Lit un numéro saisi par l'utilisateur et vérifie qu'il est valide.
     *
     * @param max La limite supérieure (non incluse) pour le numéro valide.
     * @return Un entier correspondant au numéro saisi par l'utilisateur.
     */
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

    /**
     * Réinitialise le nombre d'actions disponibles à 2.
     */
    public static void resetActions() {
        actions = 2;
        System.out.println("[🧑‍⚕️] Nombre d'actions réinitialisé à 2 !\n");
    }
}
