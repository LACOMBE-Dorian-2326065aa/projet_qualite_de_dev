package TD3_Part.main;

import TD3_Part.creatures.Creature;
import TD3_Part.services.ServiceMedical;
import TD3_Part.values.TypeBudget;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * L'interface {@code MedecinActions} fournit un ensemble d'actions qu'un médecin peut réaliser
 * dans le cadre de la gestion d'un hôpital fantastique. Ces actions incluent le soin des créatures,
 * le transfert de créatures entre services, l'examen des services et la révision des budgets.
 *
 * Les méthodes de cette interface sont définies par défaut pour offrir une implémentation standard
 * de ces actions.
 */
public interface MedecinActions {
    Scanner scanner = new Scanner(System.in);

    /**
     * Soigne toutes les créatures d'un service médical sélectionné dans l'hôpital.
     *
     * @param hopital L'objet {@code HopitalFantastique} contenant les services médicaux et créatures.
     */
    default void soigner(HopitalFantastique hopital) {
        if (hopital.getServices().isEmpty()) {
            System.out.println("[⛔] Aucun service médical disponible.\n");
            return;
        }
        System.out.print("[❓] Quel service voulez-vous soigner :\n");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + ". " + service.getNom());
            count++;
        }
        int choix = InterfaceHopital.getNumero(count);
        hopital.getServices().get(choix - 1).soignerCreatures();
        System.out.println("[❤️] Les créatures du service " + hopital.getServices().get(choix - 1).getNom() + " ont été soignées !");
    }

    /**
     * Transfère une créature d'un service médical à un autre.
     *
     * @param hopital L'objet {@code HopitalFantastique} contenant les services médicaux et créatures.
     */
    default void transfererCreature(HopitalFantastique hopital) {
        System.out.println("[❓] Choisissez une créature à transférer :\n");
        int count = 1;
        ArrayList<Creature> creatures = new ArrayList<>();
        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                System.out.println(count + ". " + creature.getNom() + " (" + service.getNom() + ")");
                creatures.add(creature);
                count++;
            }
        }
        int choixCreature = InterfaceHopital.getNumero(count);
        Creature creatureChosen = creatures.get(choixCreature - 1);

        int count2 = 1;
        ServiceMedical initialService = null;
        for (ServiceMedical service : hopital.getServices()) {
            if (service.getCreatures().contains(creatureChosen)) {
                initialService = service;
                break;
            }
        }

        System.out.println("[❓] Choisissez le service médical de destination :\n");
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count2 + ". " + service.getNom());
            count2++;
        }
        int choixService = InterfaceHopital.getNumero(count2);
        ServiceMedical newService = hopital.getServices().get(choixService - 1);

        if (newService.ajouterCreature(creatureChosen)) {
            initialService.retirerCreature(creatureChosen);
            System.out.println("[↔️] La créature " + creatureChosen.getNom() + " a été déplacée de " + initialService.getNom() + " à " + newService.getNom() + " !");
        } else {
            System.out.println("[⛔] Le transfert de la créature a échoué.");
        }
    }

    /**
     * Examine un service médical pour afficher ses détails.
     *
     * @param hopital L'objet {@code HopitalFantastique} contenant les services médicaux.
     */
    default void examinerService(HopitalFantastique hopital) {
        if (hopital.getServices().isEmpty()) {
            System.out.println("[⛔] Aucun service médical disponible.\n");
            return;
        }
        System.out.print("[❓] Quel service voulez-vous examiner :\n");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + ". " + service.getNom());
            count++;
        }
        int choix = InterfaceHopital.getNumero(count);
        hopital.getServices().get(choix - 1).afficherDetails();
    }

    /**
     * Révise le budget d'un service médical sélectionné.
     *
     * @param hopital L'objet {@code HopitalFantastique} contenant les services médicaux.
     */
    default void reviserBudget(HopitalFantastique hopital) {
        if (hopital.getServices().isEmpty()) {
            System.out.println("[⛔] Aucun service médical disponible.\n");
            return;
        }
        System.out.print("[❓] Quel service voulez-vous réviser le budget :\n");
        int count = 1;
        for (ServiceMedical service : hopital.getServices()) {
            System.out.println(count + ". " + service.getNom());
            count++;
        }
        int choix = InterfaceHopital.getNumero(count);
        ServiceMedical service = hopital.getServices().get(choix - 1);

        System.out.print("[❓] Entrez le nouveau budget pour " + service.getNom() + " :\n");
        int countBudget = 1;
        for (TypeBudget budget : TypeBudget.values()) {
            System.out.println(countBudget + ". " + budget);
            countBudget++;
        }
        int budget = InterfaceHopital.getNumero(ServiceMedical.budgets.size());
        service.setBudget(ServiceMedical.budgets.get(budget - 1));
        System.out.println("[💲] Le budget de " + service.getNom() + " a été révisé à " + service.getBudget().getNom() + " !");
    }
}
