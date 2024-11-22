package TD3_Part;

public class Simulation {
    public static void main(String[] args) {
        // Création de l'hôpital fantastique
        HopitalFantastique hopital = new HopitalFantastique("Hôpital Fantastique", 10);

        // Création des services médicaux
        ServiceMedical service1 = new ServiceMedical("Service des Zombies", 500.0, 10, "100000");
        ServiceMedical service2 = new ServiceMedical("Service des Vampires", 300.0, 5, "50000");
        ServiceMedical service3 = new ServiceMedical("Service des Orques", 400.0, 8, "75000");

        // Ajout des services à l'hôpital
        hopital.ajouterService(service1);
        hopital.ajouterService(service2);
        hopital.ajouterService(service3);

        // Création des médecins
        Medecin medecin1 = new Medecin("Dr. Frankenstein", "Homme", 45);
        Medecin medecin2 = new Medecin("Dr. Acula", "Femme", 38);

        // Ajout des médecins à l'hôpital
        hopital.ajouterMedecin(medecin1);
        hopital.ajouterMedecin(medecin2);

        // Création des créatures
        Zombie zombie1 = new Zombie("Zombie1", "Homme", 70.0, 1.8, 30);
        Vampire vampire1 = new Vampire("Vampire1", "Femme", 65.0, 1.75, 120);
        Orques orque1 = new Orques("Orque1", "Homme", 90.0, 2.0, 40);
        Elfe elfe1 = new Elfe("Elfe1", "Femme", 55.0, 1.7, 200);

        // Ajout des créatures aux services médicaux
        service1.ajouterCreature(zombie1);
        service2.ajouterCreature(vampire1);
        service3.ajouterCreature(orque1);
        service3.ajouterCreature(elfe1);

        // Affichage des détails de l'hôpital
        hopital.afficherServices();

        // Simulation des actions
        medecin1.examinerService(service1);
        medecin2.soigner(service2);

        zombie1.tomberMalade("Grippe");
        vampire1.tomberMalade("Anémie");
        orque1.tomberMalade("Infection");
        elfe1.tomberMalade("Dépression");

        zombie1.regen();
        vampire1.regen();
        orque1.attendre();
        elfe1.attendre();

        zombie1.trepasser();
        vampire1.trepasserVampire();
        orque1.trepasserOrques();
        elfe1.trepasserElfe();
    }
}