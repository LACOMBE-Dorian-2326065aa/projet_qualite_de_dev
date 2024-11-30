package TD3_Part;

public interface Medecin {

    public default void examinerService(ServiceMedical service) {
        service.afficherDetails();
    }

    public default void soigner(ServiceMedical service) {
        service.soignerCreatures();
    }

}
