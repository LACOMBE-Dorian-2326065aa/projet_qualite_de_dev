//package TD4;
//
//import TD4.Colonie;
//import TD4.Meute;
//
//import java.util.Scanner;
//
//public class InterfaceColonie {
//
//    private static Scanner scanner;
//    private Colonie colonie;
//    private Meute currentMeute;
//
//    public InterfaceColonie() {
//        scanner = new Scanner(System.in);
//        colonie = new Colonie();
//    }
//
//    public void launch() {
//        System.out.println("Bienvenue dans la simulation d'une colonie de lycanthropes !");
//        afficherMenu();
//    }
//
//    public void afficherMenu() {
//        System.out.println(
//                "-------------------------------------\n" +
//                "MENU DE LA COLONIE\n" +
//                "-------------------------------------\n" +
//                "1 : Lister les meutes\n" +
//                "2 : Créer une meute\n" +
//                "3 : Supprimer une meute\n" +
//                "4 : Afficher tous les lycanthropes\n" +
//                "5 : Sélectionner une meute\n" +
//                "6 : Lancer la simulation\n" +
//                "-------------------------------------\n" +
//                "→ Entrez le numéro de l'action à effectuer :");
//        getAction();
//    }
//
//    public void afficherMenuMeute() {
//        System.out.println(
//                "-------------------------------------\n" +
//                "MENU DE LA MEUTE " + currentMeute.getNom() + "\n" +
//                "-------------------------------------\n" +
//                "1 : Lister les lycanthropes\n" +
//                "2 : Créer un lycanthrope\n" +
//                "3 : Supprimer un lycanthrope\n" +
//                "4 : Faire hurler un lycanthrope\n" +
//                "5 : Faire s'accoupler le couple alpha\n" +
//                "-------------------------------------\n" +
//                "→ Entrez le numéro de l'action à effectuer :");
//        getActionLycanthrope();
//    }
//
//    public void getAction() {
//        String action = scanner.nextLine();
//        switch (action) {
//            case "1":
//                colonie.afficherMeutes();
//                afficherMenu();
//                break;
//            case "2":
//                System.out.println("Spécifiez le nom de la meute à créer :");
//                String nom = scanner.nextLine();
//                System.out.println("Spécifiez la position de la meute à créer :");
//                String position = scanner.nextLine();
//                colonie.creerMeute(nom, position);
//                System.out.println("Meute créée avec succès !");
//                afficherMenu();
//                break;
//            case "3":
//                if (!colonie.getMeutes().isEmpty()) {
//                    System.out.println("Spécifiez le numéro de la meute à supprimer :");
//                    colonie.afficherMeutes();
//                    int numero = getNumero(colonie.getMeutes().size());
//                    colonie.retirerMeute(colonie.getMeutes().get(numero-1));
//                    System.out.println("Meute supprimée avec succès !");
//                } else {
//                    System.out.println("Il n'y a aucune meute à supprimer.");
//                }
//                afficherMenu();
//                break;
//            case "4":
//                if (!colonie.getMeutes().isEmpty()) {
//                    int count = 0;
//                    for (Meute meute : colonie.getMeutes()) {
//                        for (LycanthropeT lycan : meute.getLycanthropes()) {
//                            count++;
//                            lycan.afficherCaracteristiques();
//                        }
//                    }
//                    if (count == 0) {
//                        System.out.println("Il n'y a aucun lycanthrope.");
//                    }
//                } else {
//                    System.out.println("Il n'y a aucune meute.");
//                }
//                afficherMenu();
//                break;
//            case "5":
//                if (!colonie.getMeutes().isEmpty()) {
//                    System.out.println("Spécifiez le numéro de la meute à sélectionner :");
//                    colonie.afficherMeutes();
//                    int numero = getNumero(colonie.getMeutes().size());
//                    currentMeute = colonie.getMeutes().get(numero-1);
//                    afficherMenuMeute();
//                } else {
//                    System.out.println("Il n'y a aucune meute à sélectionner.");
//                    afficherMenu();
//                }
//                break;
//            default:
//                System.out.println("Saisie invalide. Merci d'entrer le numéro de l'action à effectuer !");
//                afficherMenu();
//        }
//    }
//
//    public void getActionLycanthrope() {
//        String action = scanner.nextLine();
//        switch (action) {
//            case "1":
//                currentMeute.afficherLycanthropes();
//                afficherMenuMeute();
//                break;
//            case "2":
//                // TODO
//                System.out.println("Spécifiez le nom du Lycanthrope à créer :");
//                String nom = scanner.nextLine();
//                System.out.println("Spécifiez le sexe :\n1 : Femelle\n2 : Mâle");
//                boolean sexe = getNumero(2) == 1;
//                System.out.println("Spécifiez le rang :");
//                int i = 0;
//                for (char c : currentMeute.getRang().toCharArray()) {
//                    ++i;
//                    System.out.println(i + " " + c);
//                }
//                int indexOfRang = getNumero(i);
//                System.out.println("Spécifiez le facteur d'impétuosité (0 - 99) :");
//                int facteurImpetuosite = getNumero(99);
//                System.out.println("Spécifiez la force (0 - 99) :");
//                int force = getNumero(99);
//                System.out.println("Spécifiez la catégorie d'âge :\n1 : Jeune\n2 : Adulte\n3 : Vieux");
//                int choixAge = getNumero(3);
//                String categorieAge;
//                switch(choixAge) {
//                    case 1:
//                        categorieAge = LycanthropeT.JEUNE;
//                        break;
//                    case 2:
//                        categorieAge = LycanthropeT.ADULTE;
//                        break;
//                    case 3:
//                        categorieAge = LycanthropeT.VIEUX;
//                        break;
//                    default:
//                        categorieAge = LycanthropeT.JEUNE;
//                }
//                currentMeute.addLycanthrope(new LycanthropeT(currentMeute, nom, facteurImpetuosite, 5, currentMeute.getRang().toCharArray()[indexOfRang-1], 1, force, categorieAge, sexe));
//                System.out.println("Lycanthrope créé avec succès !");
//                afficherMenuMeute();
//                break;
//            case "3":
//                if (!colonie.getMeutes().isEmpty()) {
//                    System.out.println("Spécifiez le numéro du lycanthrope à supprimer :");
//                    colonie.afficherMeutes();
//                    int numero = getNumero(currentMeute.getLycanthropes().size());
//                    currentMeute.removeLycanthrope(currentMeute.getLycanthropes().get(numero-1));
//                    System.out.println("Lycanthrope supprimé avec succès !");
//                } else {
//                    System.out.println("Il n'y a aucun lycanthrope à supprimer.");
//                }
//                afficherMenuMeute();
//                break;
//            case "4":
//                if (!colonie.getMeutes().isEmpty()) {
//                    System.out.println("Spécifiez le numéro du lycanthrope à faire hurler :");
//                    int count = 1;
//                    for (LycanthropeT lycan : currentMeute.getLycanthropes()) {
//                        System.out.println(count + " : " + lycan.getNom());
//                        count++;
//                    }
//                    int numero = getNumero(currentMeute.getLycanthropes().size());
//                    System.out.println("Spécifiez le numéro du hurlement :" +
//                            "\n1 : Appartenance" +
//                            "\n2 : Domination");
//                    int numeroH = getNumero(2);
//                    currentMeute.getLycanthropes().get(numero-1).hurler(numeroH == 1 ? Hurlements.APPARTENANCE : Hurlements.DOMINATION);
//                } else {
//                    System.out.println("Il n'y a aucun lycanthrope à faire hurler.");
//                }
//                afficherMenuMeute();
//                break;
//            case "5":
//                if (!colonie.getMeutes().isEmpty()) {
//                    System.out.println("Spécifiez le numéro de la meute à sélectionner :");
//                    colonie.afficherMeutes();
//                    int numero = getNumero(colonie.getMeutes().size());
//                    currentMeute = colonie.getMeutes().get(numero-1);
//                    afficherMenuMeute();
//                } else {
//                    System.out.println("Il n'y a aucune meute à sélectionner.");
//                    afficherMenu();
//                }
//                break;
//            case "6":
//                colonie.lancerSimulation();
//                break;
//            default:
//                System.out.println("Saisie invalide. Merci d'entrer le numéro de l'action à effectuer !");
//                afficherMenuMeute();
//        }
//    }
//
//    public int getNumero(int max) {
//        Scanner scanner = new Scanner(System.in);
//        String input;
//        int number = -1;
//
//        while (true) {
//            input = scanner.nextLine();
//
//            if (input.matches("\\d+")) {
//                number = Integer.parseInt(input);
//
//                if (number >= 1 && number <= max) {
//                    break;
//                } else {
//                    System.out.println("Erreur : le nombre doit être entre 1 et " + max + ".");
//                }
//            } else {
//                System.out.println("Erreur : entrez un nombre entier valide.");
//            }
//        }
//
//        return number;
//    }
//}
