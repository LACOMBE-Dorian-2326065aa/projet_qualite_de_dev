package tests;

import TD4.lycanthropes.Lycanthrope2;
import TD4.lycanthropes.Meute;
import TD3_Part.values.TypeSexe;
import TD4.values.TypeRangDomination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MeuteTest {

    private Meute meute;

    @BeforeEach
    void setUp() {
        meute = new Meute("Meute Test", "Forêt");
    }

    @Test
    void testAddLycanthrope() {
        Lycanthrope2 lycanthrope = new Lycanthrope2("Loup Test", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_10, 5, meute);
        meute.addLycanthrope(lycanthrope);
        assertTrue(meute.getLycanthropes().contains(lycanthrope));
    }

    @Test
    void testRemoveLycanthrope() {
        Lycanthrope2 lycanthrope = new Lycanthrope2("Loup Test", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_10, 5, meute);
        meute.addLycanthrope(lycanthrope);
        meute.removeLycanthrope(lycanthrope);
        assertFalse(meute.getLycanthropes().contains(lycanthrope));
    }

    @Test
    void testSetCouple() {
        Lycanthrope2 maleAlpha = new Lycanthrope2("Alpha Male", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_24, 5, meute);
        Lycanthrope2 femelleAlpha = new Lycanthrope2("Alpha Femelle", TypeSexe.FEMELLE, 70.0, 1.7, 18, 45, 8, TypeRangDomination.RANG_24, 4, meute);
        meute.addLycanthrope(maleAlpha);
        meute.addLycanthrope(femelleAlpha);
        meute.setCouple();
        assertNotNull(meute.getCouple());
    }

    @Test
    void testOrderMeute() {
        Lycanthrope2 lycanthrope1 = new Lycanthrope2("Loup 1", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_10, 5, meute);
        Lycanthrope2 lycanthrope2 = new Lycanthrope2("Loup 2", TypeSexe.FEMELLE, 70.0, 1.7, 18, 45, 8, TypeRangDomination.RANG_5, 4, meute);
        meute.addLycanthrope(lycanthrope1);
        meute.addLycanthrope(lycanthrope2);
        meute.orderMeute();
        assertEquals(lycanthrope2, meute.getLycanthropes().get(0));
    }

    @Test
    void testAfficherLycanthropes() {
        meute.afficherLycanthropes();
        // Add assertions to verify the expected output
    }
}