package TD4;

import java.util.Scanner;

public class InterfaceColonie {

    private static Scanner scanner;
    private Colonie colonie;
    private Meute currentMeute;

    public InterfaceColonie() {
        scanner = new Scanner(System.in);
        colonie = new Colonie();
    }

    public void launch() {
        System.out.println("Bienvenue dans la simulation d'une colonie de lycanthropes !");
        afficherMenu();
    }

    public void afficherMenu() {
        System.out.println(
                "-------------------------------------\n" +
                "MENU DE LA COLONIE\n" +
                "-------------------------------------\n" +
                "1 : Lister les meutes\n" +
                "2 : Créer une meute\n" +
                "3 : Supprimer une meute\n" +
                "4 : Afficher tous les lycanthropes\n" +
                "5 : Sélectionner une meute\n" +
                "6 : Lancer la simulation\n" +
                "-------------------------------------\n" +
                "→ Entrez le numéro de l'action à effectuer :");
        getAction();
    }

    public void afficherMenuMeute() {
        System.out.println(
                "-------------------------------------\n" +
                "MENU DE LA MEUTE " + currentMeute.getNom() + "\n" +
                "-------------------------------------\n" +
                "1 : Lister les lycanthropes\n" +
                "2 : Créer un lycanthrope\n" +
                "3 : Supprimer un lycanthrope\n" +
                "-------------------------------------\n" +
                "→ Entrez le numéro de l'action à effectuer :");
        getAction();
    }

    public void getAction() {
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                colonie.afficherMeutes();
                afficherMenu();
                break;
            case "2":
                System.out.println("Spécifiez le nom de la meute à créer :");
                String nom = scanner.nextLine();
                System.out.println("Spécifiez la position de la meute à créer :");
                String position = scanner.nextLine();
                colonie.creerMeute(nom, position);
                System.out.println("Meute créée avec succès !");
                afficherMenu();
                break;
            case "3":
                if (!colonie.getMeutes().isEmpty()) {
                    System.out.println("Spécifiez le numéro de la meute à supprimer :");
                    colonie.afficherMeutes();
                    int numero = getNumero(colonie.getMeutes().size());
                    colonie.retirerMeute(colonie.getMeutes().get(numero-1));
                    System.out.println("Meute supprimée avec succès !");
                } else {
                    System.out.println("Il n'y a aucune meute à supprimer.");
                }
                afficherMenu();
                break;
            case "4":
                if (!colonie.getMeutes().isEmpty()) {
                    int count = 0;
                    for (Meute meute : colonie.getMeutes()) {
                        for (Lycanthrope lycan : meute.getMeute()) {
                            count++;
                            lycan.afficherCaracteristiques();
                        }
                    }
                    if (count == 0) {
                        System.out.println("Il n'y a aucun lycanthrope.");
                    }
                } else {
                    System.out.println("Il n'y a aucune meute.");
                }
                afficherMenu();
                break;
            default:
                System.out.println("Saisie invalide. Merci d'entrer le numéro de l'action à effectuer !");
                afficherMenu();
        }
    }

    public void getActionLycanthrope() {
        String action = scanner.nextLine();
        switch (action) {
            case "1":
                currentMeute.afficherLycanthropes();
                afficherMenuMeute();
                break;
            case "2":
                // TODO
                System.out.println("Spécifiez le nom de la meute à créer :");
                String nom = scanner.nextLine();
                System.out.println("Spécifiez la position de la meute à créer :");
                String position = scanner.nextLine();
                colonie.creerMeute(nom, position);
                System.out.println("Meute créée avec succès !");
                afficherMenu();
                break;
            case "3":
                // TODO
                if (!colonie.getMeutes().isEmpty()) {
                    System.out.println("Spécifiez le numéro de la meute à supprimer :");
                    colonie.afficherMeutes();
                    int numero = getNumero(colonie.getMeutes().size());
                    colonie.retirerMeute(colonie.getMeutes().get(numero-1));
                    System.out.println("Meute supprimée avec succès !");
                } else {
                    System.out.println("Il n'y a aucune meute à supprimer.");
                }
                afficherMenu();
                break;
            // TODO
            case "4":
                currentMeute.afficherLycanthropes();
                afficherMenu();
                break;
            case "5":
                if (!colonie.getMeutes().isEmpty()) {
                    System.out.println("Spécifiez le numéro de la meute à sélectionner :");
                    colonie.afficherMeutes();
                    int numero = getNumero(colonie.getMeutes().size());
                    currentMeute = colonie.getMeutes().get(numero-1);
                    afficherMenuMeute();
                } else {
                    System.out.println("Il n'y a aucune meute à sélectionner.");
                    afficherMenu();
                }
                break;
            case "6":
                colonie.lancerSimulation();
                break;
            default:
                System.out.println("Saisie invalide. Merci d'entrer le numéro de l'action à effectuer !");
                afficherMenuMeute();
        }
    }

    public int getNumero(int max) {
        Scanner scanner = new Scanner(System.in);
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
}
