package TD3_Part.main;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.Maladie;
import TD3_Part.creatures.specific.*;
import TD3_Part.services.CentreDeQuarantaine;
import TD3_Part.services.Crypte;
import TD3_Part.services.ServiceMedical;
import TD3_Part.values.TypeBudget;
import TD3_Part.values.TypeSexe;
import java.util.Random;
/**
 * La classe Simulation représente une simulation de l'hôpital fantastique.
 */
public class Simulation {

    private static int interval = 30;
    public static int morts = 0;
    private static final int MAX_MORTS = 6;
    private static int iterations = 0;
    public static String events;
    public static boolean partieLycan = true;
    /**
     * Méthode principale pour lancer la simulation.
     * Elle crée un hôpital fantastique et des services médicaux, des médecins et des créatures.
     */
    public void launch() {
        // Création de l'hôpital fantastique
        HopitalFantastique hopital = new HopitalFantastique("Hôpital Fantastique", 11);

        ServiceMedical service1 = new ServiceMedical("Service des Zombies", 500.0, 10, TypeBudget.FAIBLE);
        ServiceMedical service2 = new ServiceMedical("Service des Vampires", 300.0, 5, TypeBudget.FAIBLE);
        ServiceMedical service3 = new ServiceMedical("Service des Orques", 400.0, 8, TypeBudget.MEDIOCRE);
        ServiceMedical service4 = new ServiceMedical("Service des Nains", 400.0, 8, TypeBudget.FAIBLE);
        ServiceMedical service5 = new ServiceMedical("Service des Reptiliens", 400.0, 8, TypeBudget.INSUFFISANT);
        ServiceMedical service6 = new ServiceMedical("Service des Elfes", 400.0, 8, TypeBudget.FAIBLE);
        ServiceMedical service7 = new ServiceMedical("Service des Hommes-Bêtes", 400.0, 8, TypeBudget.FAIBLE);
        ServiceMedical service8 = new ServiceMedical("Service des Lycanthropes", 400.0, 8, TypeBudget.FAIBLE);
        ServiceMedical service9crypte = new Crypte("Crypte", 1000.0, 20, TypeBudget.INEXISTANT);
        ServiceMedical service10quarantaine = new CentreDeQuarantaine("Centre de Quarantaine", 1000.0, 20, TypeBudget.INEXISTANT);
        ServiceMedical service11vide = new ServiceMedical("Service Vide", 1000.0, 20, TypeBudget.INEXISTANT);

//        Colonie colonie = new Colonie();
//
//        Meute meute = new Meute("Meute des Ombres", "Sud");

//        colonie.ajouterMeute(meute);

        hopital.ajouterService(service1);
        hopital.ajouterService(service2);
        hopital.ajouterService(service3);
        hopital.ajouterService(service4);
        hopital.ajouterService(service5);
        hopital.ajouterService(service6);
        hopital.ajouterService(service7);
        hopital.ajouterService(service8);
        hopital.ajouterService(service9crypte);
        hopital.ajouterService(service10quarantaine);
        hopital.ajouterService(service11vide);

        Medecin medecin1 = new Medecin(TypeSexe.MALE, 54, "Dr. Frankenstein");
        hopital.getMedecins().add(medecin1);

        Zombie zombie1 = new Zombie("Zombie1", TypeSexe.MALE, 70.0, 1.8, 30);
        Vampire vampire1 = new Vampire("Vampire1", TypeSexe.FEMELLE, 65.0, 1.75, 120);
        Orques orque1 = new Orques("Orque1", TypeSexe.MALE, 90.0, 2.0, 40);
        Elfe elfe1 = new Elfe("Elfe1", TypeSexe.FEMELLE, 55.0, 1.7, 200);
        Zombie zombie2 = new Zombie("Zombie2", TypeSexe.FEMELLE, 68.0, 1.65, 28);
        Vampire vampire2 = new Vampire("Vampire2", TypeSexe.MALE, 70.0, 1.80, 130);
        Orques orque2 = new Orques("Orque2", TypeSexe.FEMELLE, 85.0, 1.95, 35);
        Elfe elfe2 = new Elfe("Elfe2", TypeSexe.MALE, 60.0, 1.72, 210);
        Nain nain1 = new Nain("Nain1", TypeSexe.MALE, 50.0, 1.5, 150);
        Reptilien reptilien1 = new Reptilien("Reptilien1", TypeSexe.FEMELLE, 70.0, 1.8, 100);
        Nain nain2 = new Nain("Nain2", TypeSexe.FEMELLE, 45.0, 1.45, 160);
        Reptilien reptilien2 = new Reptilien("Reptilien2", TypeSexe.MALE, 75.0, 1.85, 110);
        HommeBete hommeBete1 = new HommeBete("HommeBete1", TypeSexe.MALE, 80.0, 1.9, 50);
        HommeBete hommeBete2 = new HommeBete("HommeBete2", TypeSexe.FEMELLE, 75.0, 1.85, 55);
        Lycanthrope lycanthrope1 = new Lycanthrope("Lycanthrope1", TypeSexe.MALE, 75.0, 1.70, 18);
        Lycanthrope lycanthrope2 = new Lycanthrope("Lycanthrope2", TypeSexe.FEMELLE, 70.0, 1.65, 20);

        service1.ajouterCreature(zombie1);
        service2.ajouterCreature(vampire1);
        service3.ajouterCreature(orque1);
        service6.ajouterCreature(elfe1);
        service4.ajouterCreature(nain1);
        service5.ajouterCreature(reptilien1);
        service4.ajouterCreature(nain2);
        service1.ajouterCreature(zombie2);
        service2.ajouterCreature(vampire2);
        service3.ajouterCreature(orque2);
        service6.ajouterCreature(elfe2);
        service5.ajouterCreature(reptilien2);
        service7.ajouterCreature(hommeBete1);
        service7.ajouterCreature(hommeBete2);
        service8.ajouterCreature(lycanthrope1);
        service8.ajouterCreature(lycanthrope2);

        InterfaceHopital interfaceHopital = new InterfaceHopital(hopital);
        Random rand = new Random();

        // Thread pour les événements aléatoires
        Thread thread1 = new Thread(() -> {
            while (true) {
                simulerEvenementsAleatoires(hopital, rand);
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
            while (true) {
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\nIl y a actuellement " + hopital.getNombreCreatures() + " créatures dans l'hôpital.\n\n");
                hopital.afficherCreatures();
                System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=\n\n");
                InterfaceHopital.resetActions();
                try {
                    Thread.sleep(interval * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
        interfaceHopital.init();
    }
    /**
     * Simule des événements aléatoires pour les créatures de l'hôpital.
     * @param hopital L'objet {@code HopitalFantastique} contenant les services médicaux et créatures.
     * @param rand Instance de {@link Random} utilisée pour générer des valeurs aléatoires.
     */
    private static void simulerEvenementsAleatoires(HopitalFantastique hopital, Random rand) {
        events = "\nÉvénements aléatoires :\n";
        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                if(creature.isMort())
                    continue;

                double proba = Math.random();

                if (Math.random() <= 0.5) {
                    creature.setCompteurAttendre(creature.getCompteurAttendre() + 1);
                    creature.attendre();
                    continue;
                } else {
                    creature.setCompteurAttendre(0);
                }

                // Probabilité de tomber malade
                if (proba <= 0.4) {
                    if (creature.getMaladies().isEmpty()) {
                        int maladieIndex = rand.nextInt(Maladie.maladiesList.size());
                        creature.tomberMalade(new Maladie(Maladie.maladiesList.get(maladieIndex), rand.nextInt(6) + 2));
//                        System.out.println(creature.getNom() + " est tombé malade de " + Maladie.maladiesStrLabels.get(maladieIndex) + " (" + Maladie.maladiesStr.get(maladieIndex) + ").");
                        events += " - (🦠) " + creature.getNom() + " : +" + Maladie.maladiesList.get(maladieIndex).getNomAbrege() + " (" + Maladie.maladiesList.get(maladieIndex).getNomComplet() + ").\n";
                    }
                }

                proba = Math.random();
                if (proba <= 0.3) {
                    creature.sEmporter();
                }

                // Probabilité d'aggraver une maladie existante
                proba = Math.random();
                if (proba <= 0.5) {
                    if (!creature.getMaladies().isEmpty()) {
                        Maladie maladie = creature.getMaladies().get(rand.nextInt(creature.getMaladies().size()));
                        int niveauActuel = maladie.getNiveauActuel();
                        maladie.augmenterNiveau();
//                        System.out.println("La maladie " + maladie.getNomAbrege() + " de " + creature.getNom() + " s'est aggravée (" + niveauActuel + " => " + maladie.getNiveauActuel() + " / " + maladie.getNiveauMax() + ").");
                        events += " - (🦠📈) " + creature.getNom() + " : " + maladie.getNomAbrege() + " s'aggrave (" + niveauActuel + " => " + maladie.getNiveauActuel() + " / " + maladie.getNiveauMax() + ").\n";
                        if (maladie.estLethal()) {
                            events += " - (☠️) " + creature.getNom() + " : mort.\n";
                            morts++;
                            creature.trepasser();
                        }
                    }
                }

                proba = Math.random();
                if (proba <= 0.3) {
                    creature.baisseMoral();
                }

                // Probabilité de guérir d'une maladie
                proba = Math.random();
                if (proba <= 0.1) {
                    if (!creature.getMaladies().isEmpty()) {
                        Maladie maladie = creature.getMaladies().get(rand.nextInt(creature.getMaladies().size()));
                        creature.guerison(maladie);
//                        System.out.println(creature.getNom() + " a guéri de " + maladie.getNomComplet() + ".");
                        events += " - (💊) " + creature.getNom() + " : -" + maladie.getNomAbrege() + " soignée.\n";
                    }
                }
            }
        }

//        if (partieLycan) {
//            for (Meute meute : colonie.getMeutes()) {
//                for (Lycanthrope lycanthrope : meute.getLycanthropes()) {
//                    if (lycanthrope.isMort())
//                        continue;
//
//                    double proba = Math.random();
//                    if (proba <= 0.3) {
//                        lycanthrope.hurler();
//                    }
//                }
//            }
//        }

        System.out.println(events);
        String mortsIcon = "";
        for (int i = 0; i < morts; ++i) {
            mortsIcon += "☠️";
        }
        System.out.println("→ (" + mortsIcon + ") Morts : " + morts + " / " + MAX_MORTS + "\n");

        if (morts >= MAX_MORTS) {
            System.out.println("→ [😶‍🌫️] Le nombre de morts a atteint le maximum autorisé. Fin de la simulation.\n\n[📈]1 Score : " + iterations + " tours");
            System.exit(0);
        }
        iterations++;
        Creature.compteurAttendreEspece.clear();
    }
}