package tests;

import TD3_Part.values.TypeSexe;
import TD4.values.TypeAge;
import TD4.values.TypeHurlement;
import TD4.values.TypeRangDomination;
import TD4.lycanthropes.Lycanthrope2;
import TD4.lycanthropes.Meute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Lycanthrope2Test {

    private Lycanthrope2 lycanthrope;
    private Meute meute;

    @BeforeEach
    void setUp() {
        meute = new Meute("Meute Test", "Forêt");
        lycanthrope = new Lycanthrope2("Loup Test", TypeSexe.MALE, 80.0, 1.8, 20, 50, 10, TypeRangDomination.RANG_10, 5, meute);
    }

    @Test
    void testGetCategorieAge() {
        assertEquals(TypeAge.ADULTE, lycanthrope.getCategorieAge());
    }

    @Test
    void testSetCategorieAge() {
        lycanthrope.setCategorieAge(TypeAge.VIEUX);
        assertEquals(TypeAge.VIEUX, lycanthrope.getCategorieAge());
    }

    @Test
    void testGetForce() {
        assertEquals(50, lycanthrope.getForce());
    }

    @Test
    void testSetForce() {
        lycanthrope.setForce(60);
        assertEquals(60, lycanthrope.getForce());
    }

    @Test
    void testGetFacteurDomination() {
        assertEquals(10, lycanthrope.getFacteurDomination());
    }

    @Test
    void testSetFacteurDomination() {
        lycanthrope.setFacteurDomination(15);
        assertEquals(15, lycanthrope.getFacteurDomination());
    }

    @Test
    void testHurler() {
        lycanthrope.hurler();
        // Add assertions to verify the expected behavior of hurler method
    }

    @Test
    void testVieillir() {
        lycanthrope.vieillir();
        // Add assertions to verify the expected behavior of vieillir method
    }

    @Test
    void testSetMort() {
        lycanthrope.setMort(true);
        assertTrue(lycanthrope.isMort());
        assertNull(lycanthrope.getMeute());
    }
}