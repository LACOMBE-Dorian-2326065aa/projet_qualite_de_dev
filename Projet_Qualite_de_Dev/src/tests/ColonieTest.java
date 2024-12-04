package tests;

import TD4.lycanthropes.Colonie;
import TD4.lycanthropes.Meute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ColonieTest {

    private Colonie colonie;

    @BeforeEach
    void setUp() {
        colonie = new Colonie();
    }

    @Test
    void testAjouterMeute() {
        Meute meute = new Meute("Meute Test", "Forêt");
        colonie.ajouterMeute(meute);
        assertTrue(colonie.getMeutes().contains(meute));
    }

    @Test
    void testRetirerMeute() {
        Meute meute = new Meute("Meute Test", "Forêt");
        colonie.ajouterMeute(meute);
        colonie.retirerMeute(meute);
        assertFalse(colonie.getMeutes().contains(meute));
    }

    @Test
    void testInit() {
        colonie.init();
        assertEquals(4, colonie.getMeutes().size());
    }
    @Test
    void testCreerMeute() {
        colonie.creerMeute("Meute Test", "Forêt");
        assertEquals(1, colonie.getMeutes().size());
    }
}