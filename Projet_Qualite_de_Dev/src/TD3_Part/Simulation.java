package TD3_Part;

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

        service1.ajouterCreature(zombie1);
        service2.ajouterCreature(vampire1);
        service3.ajouterCreature(orque1);
        service3.ajouterCreature(elfe1);

        InterfaceHopital interfaceHopital = new InterfaceHopital(hopital);
        Random rand = new Random();

        int interval = 60;

        Thread thread = new Thread(() -> {
            int count = 0;
            while(true) {
                System.out.println("Lambda : ");
                try {
                    Thread.sleep(interval * 1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            while (true) {
//                System.out.println("Il y a actuellement " + hopital.getNombreCreatures() + " créatures dans l'hôpital");
//                hopital.afficherCreatures();
                interfaceHopital.init();

//                for (ServiceMedical service : hopital.getServices()) {
//                    for (Creature creature : service.getCreatures()) {
//                        double proba = Math.random();
//
//                        System.out.println(proba);
//
//                        if (proba <= 0.5) {
//                            if (creature.getMaladies().isEmpty())
//                                creature.tomberMalade(new Maladie(Maladie.MDC, "MDC", 10));
//                        }
//
//                        proba = Math.random();
//
//                        System.out.println(proba);
//
//                        if (proba <= 0.5) {
//                            if (!creature.getMaladies().isEmpty()) {
//                                creature.getMaladies().get(rand.nextInt(creature.getMaladies().size())).augmenterNiveau();
//                            }
//                        }
//                    }
//                }
            }
        });
        thread2.start();
    }
}