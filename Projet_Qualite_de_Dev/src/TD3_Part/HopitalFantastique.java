package TD3_Part;

import java.util.ArrayList;
import java.util.List;

public class HopitalFantastique {
    private String nom;
    private List<ServiceMedical> services;
    private List<Medecin> medecins;

    public HopitalFantastique(String nom) {
        this.nom = nom;
        this.services = new ArrayList<>();
        this.medecins = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public List<ServiceMedical> getServices() {
        return services;
    }

    public void setServices(List<ServiceMedical> services) {
        this.services = services;
    }

    public void ajouterService(ServiceMedical service) {
        services.add(service);
    }

    public void ajouterMedecin(Medecin medecin) {
        medecins.add(medecin);
    }

    public void afficherCreatures() {
        for (ServiceMedical service : services) {
            service.afficherDetails();
        }
    }
}
