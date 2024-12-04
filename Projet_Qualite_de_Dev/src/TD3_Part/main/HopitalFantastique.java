package TD3_Part.main;

import TD3_Part.creatures.specific.Medecin;
import TD3_Part.services.ServiceMedical;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe HopitalFantastique représente un hôpital fantastique avec des services médicaux et des médecins.
 * Elle fournit des méthodes pour ajouter un service, obtenir le nombre de créatures, afficher les services et les créatures.
 */
public class HopitalFantastique {
    private String nom;
    private int nombreMaxServices;
    private List<ServiceMedical> services;
    private List<Medecin> medecins;
    /**
     * Constructeur de la classe HopitalFantastique.
     * @param nom Le nom de l'hôpital.
     * @param nombreMaxServices Le nombre maximal de services autorisés.
     */
    public HopitalFantastique(String nom, int nombreMaxServices) {
        this.nom = nom;
        this.nombreMaxServices = nombreMaxServices;
        this.services = new ArrayList<>();
        this.medecins = new ArrayList<>();
    }

    /**
     * Obtient le nom de l'hôpital.
     * @return Une chaîne de caractères représentant le nom de l'hôpital.
     */
    public String getNom() {
        return nom;
    }
    /**
     * Définit le nom de l'hôpital.
     * @param nom Le nom de l'hôpital.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * Obtient le nombre maximal de services autorisés.
     * @return Un entier représentant le nombre maximal de services autorisés.
     */
    public int getNombreMaxServices() {
        return nombreMaxServices;
    }
    /**
     * Définit le nombre maximal de services autorisés.
     * @param nombreMaxServices Le nombre maximal de services autorisés.
     */
    private void setNombreMaxServices(int nombreMaxServices) {
        this.nombreMaxServices = nombreMaxServices;
    }
    /**
     * Obtient la liste des services de l'hôpital.
     * @return Une liste de services médicaux.
     */
    public List<ServiceMedical> getServices() {
        return services;
    }
    /**
     * Définit la liste des services de l'hôpital.
     * @param services Une liste de services médicaux.
     */
    public void setServices(List<ServiceMedical> services) {
        if (services.size() <= nombreMaxServices) {
            this.services = services;
        } else {
            System.out.println("Erreur : le nombre de services dépasse la limite autorisée.");
        }
    }
    /**
     * Obtient la liste des médecins de l'hôpital.
     * @return Une liste de médecins.
     */
    public List<Medecin> getMedecins() {
        return medecins;
    }
    /**
     * Définit la liste des médecins de l'hôpital.
     * @param medecins Une liste de médecins.
     */
    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
    /**
     * ajoute un service médical.
     * @param service Le service médical à ajouter. 
     */
    public void ajouterService(ServiceMedical service) {
        if (services.size() < nombreMaxServices) {
            services.add(service);
        } else {
            System.out.println("Impossible d'ajouter le service : capacité maximale atteinte.");
        }
    }
    /**
     * Obtient le nombre total de créatures dans l'hôpital.
     */
    public int getNombreCreatures() {
        int totalCreatures = 0;
        for (ServiceMedical service : services) {
            totalCreatures += service.getCreatures().size();
        }
        return totalCreatures;
    }
    /**
     * Affiche les services de l'hôpital.
     */
    public void afficherServices() {
        for (ServiceMedical service : services) {
            System.out.println("Service : " + service.getNom());
        }
    }
    /**
     * Affiche les créatures de l'hôpital.
     */
    public void afficherCreatures() {
        System.out.println("= Liste des créatures de l'hôpital =");
        for (ServiceMedical service : services) {
            System.out.println("Service : " + service.getNom());
            service.afficherCreatures();
        }
    }
}