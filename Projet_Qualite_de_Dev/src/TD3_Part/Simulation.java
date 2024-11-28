package TD3_Part;

import TD3_Part.creatures.Creature;
import TD3_Part.creatures.specific.Elfe;
import TD3_Part.creatures.specific.Orques;
import TD3_Part.creatures.specific.Vampire;
import TD3_Part.creatures.specific.Zombie;
import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        // Création de l'hôpital fantastique
        HopitalFantastique hopital = new HopitalFantastique("Hôpital Fantastique", 10);

        ServiceMedical service1 = new ServiceMedical("Service des Zombies", 500.0, 10, "100000");
        ServiceMedical service2 = new ServiceMedical("Service des Vampires", 300.0, 5, "50000");
        ServiceMedical service3 = new ServiceMedical("Service des Orques", 400.0, 8, "75000");

        hopital.ajouterService(service1);
        hopital.ajouterService(service2);
        hopital.ajouterService(service3);

        Medecin medecin1 = new Medecin("Dr. Frankenstein", "Homme", 45);
        Medecin medecin2 = new Medecin("Dr. Acula", "Femme", 38);

        hopital.ajouterMedecin(medecin1);
        hopital.ajouterMedecin(medecin2);

        Zombie zombie1 = new Zombie("Zombie1", "Homme", 70.0, 1.8, 30);
        Vampire vampire1 = new Vampire("Vampire1", "Femme", 65.0, 1.75, 120);
        Orques orque1 = new Orques("Orque1", "Homme", 90.0, 2.0, 40);
        Elfe elfe1 = new Elfe("Elfe1", "Femme", 55.0, 1.7, 200);
        Zombie zombie2 = new Zombie("Zombie2", "Femme", 68.0, 1.65, 28);
        Vampire vampire2 = new Vampire("Vampire2", "Homme", 70.0, 1.80, 130);
        Orques orque2 = new Orques("Orque2", "Femme", 85.0, 1.95, 35);
        Elfe elfe2 = new Elfe("Elfe2", "Homme", 60.0, 1.72, 210);

        service1.ajouterCreature(zombie2);
        service2.ajouterCreature(vampire2);
        service3.ajouterCreature(orque2);
        service3.ajouterCreature(elfe2);
        service1.ajouterCreature(zombie1);
        service2.ajouterCreature(vampire1);
        service3.ajouterCreature(orque1);
        service3.ajouterCreature(elfe1);

        InterfaceHopital interfaceHopital = new InterfaceHopital(hopital);
        Random rand = new Random();

        int interval = 30;

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

        // Thread pour les actions de l'utilisateur
        Thread thread2 = new Thread(() -> {
            while (true) {
                interfaceHopital.init();
                try {
                    Thread.sleep(interval * 100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();
    }

    private static void simulerEvenementsAleatoires(HopitalFantastique hopital, Random rand) {
        for (ServiceMedical service : hopital.getServices()) {
            for (Creature creature : service.getCreatures()) {
                double proba = Math.random();

                // Probabilité de tomber malade
                if (proba <= 0.4) {
                    if (creature.getMaladies().isEmpty()) {
                        creature.tomberMalade(new Maladie(Maladie.MDC, "MDC", 10));
                        System.out.println(creature.getNom() + " est tombé malade de MDC.");
                    }
                }

                // Probabilité d'aggraver une maladie existante
                proba = Math.random();
                if (proba <= 0.9) {
                    if (!creature.getMaladies().isEmpty()) {
                        Maladie maladie = creature.getMaladies().get(rand.nextInt(creature.getMaladies().size()));
                        maladie.augmenterNiveau();
                        System.out.println("La maladie de " + creature.getNom() + " s'est aggravée.");
                        if (maladie.estLethal()) {
                            creature.trepasser();
                        }
                    }
                }

                // Probabilité de guérir d'une maladie
                proba = Math.random();
                if (proba <= 0.1) {
                    if (!creature.getMaladies().isEmpty()) {
                        Maladie maladie = creature.getMaladies().get(rand.nextInt(creature.getMaladies().size()));
                        creature.guerison(maladie);
                        System.out.println(creature.getNom() + " a guéri de " + maladie.getNomComplet() + ".");
                    }
                }
            }
        }
    }
}