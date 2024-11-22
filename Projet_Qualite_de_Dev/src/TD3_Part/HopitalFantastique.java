package TD3_Part;

import java.util.ArrayList;
import java.util.List;

public class HopitalFantastique {
    private String nom;
    private int nombreMaxServices;
    private List<ServiceMedical> services;
    private List<Medecin> medecins;

    public HopitalFantastique(String nom, int nombreMaxServices) {
        this.nom = nom;
        this.nombreMaxServices = nombreMaxServices;
        this.services = new ArrayList<>();
        this.medecins = new ArrayList<>();
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombreMaxServices() {
        return nombreMaxServices;
    }

    private void setNombreMaxServices(int nombreMaxServices) {
        this.nombreMaxServices = nombreMaxServices;
    }

    public List<ServiceMedical> getServices() {
        return services;
    }

    public void setServices(List<ServiceMedical> services) {
        if (services.size() <= nombreMaxServices) {
            this.services = services;
        } else {
            System.out.println("Erreur : le nombre de services dépasse la limite autorisée.");
        }
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public void ajouterService(ServiceMedical service) {
        if (services.size() < nombreMaxServices) {
            services.add(service);
        } else {
            System.out.println("Impossible d'ajouter le service : capacité maximale atteinte.");
        }
    }

    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    public int getNombreCreatures() {
        int totalCreatures = 0;
        for (ServiceMedical service : services) {
            totalCreatures += service.getCreatures().size();
        }
        return totalCreatures;
    }

    public void afficherServices() {
        for (ServiceMedical service : services) {
            System.out.println("Service : " + service.getNom());
        }
    }
}