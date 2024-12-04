package tests;

import TD3_Part.values.TypeSexe;
import TD4.values.TypeRangDomination;
import TD4.lycanthropes.Couple;
import TD4.lycanthropes.Lycanthrope2;
import TD4.lycanthropes.Meute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoupleTest {

    private Couple couple;
    private Lycanthrope2 male;
    private Lycanthrope2 female;
    private Meute meute;

    @BeforeEach
    void setUp() {
        meute = new Meute("Meute Test", "Forêt");
        male = new Lycanthrope2("Alpha Male", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_24, 5, meute);
        female = new Lycanthrope2("Alpha Femelle", TypeSexe.FEMELLE, 70.0, 1.7, 18, 45, 8, TypeRangDomination.RANG_24, 4, meute);
        couple = new Couple(male, female);
    }

    @Test
    void testReproduction() {
        couple.reproduction();
        assertTrue(meute.getLycanthropes().size() > 2);
    }
}