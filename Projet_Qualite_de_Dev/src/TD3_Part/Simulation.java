package TD3_Part;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.specific.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Simulation {

    private static int interval = 30;
    public static int morts = 0;
    private static final int MAX_MORTS = 6;
    private static int iterations = 0;
    public static String events;

    public static void main(String[] args) {
        // Création de l'hôpital fantastique
        HopitalFantastique hopital = new HopitalFantastique("Hôpital Fantastique", 10);

        ServiceMedical service1 = new ServiceMedical("Service des Zombies", 500.0, 10, "100000");
        ServiceMedical service2 = new ServiceMedical("Service des Vampires", 300.0, 5, "50000");
        ServiceMedical service3 = new ServiceMedical("Service des Orques", 400.0, 8, "75000");
        ServiceMedical service4 = new ServiceMedical("Service des Nains", 400.0, 8, "75000");
        ServiceMedical service5 = new ServiceMedical("Service des Reptiliens", 400.0, 8, "75000");

        hopital.ajouterService(service1);
        hopital.ajouterService(service2);
        hopital.ajouterService(service3);
        hopital.ajouterService(service4);
        hopital.ajouterService(service5);

        Zombie zombie1 = new Zombie("Zombie1", "Homme", 70.0, 1.8, 30);
        Vampire vampire1 = new Vampire("Vampire1", "Femme", 65.0, 1.75, 120);
        Orques orque1 = new Orques("Orque1", "Homme", 90.0, 2.0, 40);
        Elfe elfe1 = new Elfe("Elfe1", "Femme", 55.0, 1.7, 200);
        Zombie zombie2 = new Zombie("Zombie2", "Femme", 68.0, 1.65, 28);
        Vampire vampire2 = new Vampire("Vampire2", "Homme", 70.0, 1.80, 130);
        Orques orque2 = new Orques("Orque2", "Femme", 85.0, 1.95, 35);
        Elfe elfe2 = new Elfe("Elfe2", "Homme", 60.0, 1.72, 210);
        Nain nain1 = new Nain("Nain1", "Homme", 50.0, 1.5, 150);
        Reptilien reptilien1 = new Reptilien("Reptilien1", "Femme", 70.0, 1.8, 100);
        Nain nain2 = new Nain("Nain2", "Femme", 45.0, 1.45, 160);
        Reptilien reptilien2 = new Reptilien("Reptilien2", "Homme", 75.0, 1.85, 110);

        service1.ajouterCreature(zombie2);
        service2.ajouterCreature(vampire2);
        service3.ajouterCreature(orque2);
        service3.ajouterCreature(elfe2);
        service1.ajouterCreature(zombie1);
        service2.ajouterCreature(vampire1);
        service3.ajouterCreature(orque1);
        service3.ajouterCreature(elfe1);
        service4.ajouterCreature(nain1);
        service4.ajouterCreature(nain2);
        service5.ajouterCreature(reptilien1);
        service5.ajouterCreature(reptilien2);

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
                interfaceHopital.init();
                InterfaceHopital.resetActions();
                try {
                    Thread.sleep(interval * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
    }

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
                        int maladieIndex = rand.nextInt(Maladie.maladiesStr.size());
                        creature.tomberMalade(new Maladie(Maladie.maladiesStr.get(maladieIndex), Maladie.maladiesStrLabels.get(maladieIndex), rand.nextInt(6) + 2));
//                        System.out.println(creature.getNom() + " est tombé malade de " + Maladie.maladiesStrLabels.get(maladieIndex) + " (" + Maladie.maladiesStr.get(maladieIndex) + ").");
                        events += " - (🦠) " + creature.getNom() + " : +" + Maladie.maladiesStrLabels.get(maladieIndex) + " (" + Maladie.maladiesStr.get(maladieIndex) + ").\n";
                    }
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
        System.out.println(events);
        String mortsIcon = "";
        for (int i = 0; i < morts; ++i) {
            mortsIcon += "☠️";
        }
        System.out.println("→ (" + mortsIcon + ") Morts : " + morts + " / " + MAX_MORTS + "\n");

        if (morts >= MAX_MORTS) {
            System.out.println("→ Le nombre de morts a atteint le maximum autorisé. Fin de la simulation.\n\n📈 - Score : " + iterations + " tours");
            System.exit(0);
        }
        iterations++;
        Creature.compteurAttendreEspece.clear();
    }
}