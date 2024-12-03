import TD3_Part.main.Simulation;
import TD4.lycanthropes.Colonie;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenue dans le notre simulateur !\nChoisissez une simulation à lancer :\n1 : Hôpital Fantastique\n2 : Colonie de Lycanthropes");
        firstAsk();
    }

    public static void firstAsk() {
        switch (scanner.nextLine()) {
            case "1":
                Simulation simulation = new Simulation();
                simulation.launch();
                break;
            case "2":
                Colonie colonie = new Colonie();
                colonie.init();
                colonie.lancerSimulation();
                break;
            default:
                System.out.println("Choix invalide, veuillez réessayer.");
                firstAsk();
                break;
        }
    }

}
