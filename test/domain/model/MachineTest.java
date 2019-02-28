package domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MachineTest {
    private Machine machine;
    private Snack snack1 = new Snack("Snicker", 10);
    private Snack snack2 = new Snack("Mars", 20);
    private NonFood nonFood1 = new NonFood("Shampoo", 15, true);
    private NonFood nonFood2 = new NonFood("Scheerapparaat", 100, false);
    private Drink drink1 = new Drink("Cola", 30);
    private Drink drink2 = new Drink("Sprite", 40);
    private final double delta = 0.01;

    @Before
    public void init() {
        machine = new Machine("Automaat 01", "Automaat op de eerste verdieping");
    }

    @Test
    public void test_voeg_toe_initieel() {
        machine.voegProductToe(snack1);
        machine.voegProductToe(nonFood1);
        machine.voegProductToe(drink1);
        assertEquals(3, machine.getProducten().size());
        assertEquals(drink1, machine.vindProduct(drink1));
        assertEquals(snack1, machine.vindProduct(snack1));
        assertEquals(nonFood1, machine.vindProduct(nonFood1));
        System.out.println(machine.toString());
    }

    @Test
    public void test_vul_bestaand_product_aan_legal_case() {
        machine.voegProductToe(snack1);
        assertEquals(1, machine.getProducten().size());
        machine.vulProductAan(snack1, 5);
        assertEquals(1, machine.getProducten().size());
        assertEquals(5, snack1.getAantal());
        machine.vulProductAan(snack1, 7);
        assertEquals(1, machine.getProducten().size());
        assertEquals(12, snack1.getAantal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_vul_niet_bestaand_product_aan_gooit_exception() {
        assertEquals(0, machine.getProducten().size());
        assertEquals(0, snack1.getAantal());
        machine.vulProductAan(snack1, 5);
        assertEquals(0, machine.getProducten().size());
        assertEquals(0, snack1.getAantal());
    }

    @Test
    public void test_totaal_prijs_producten_zonder_korting() {
        machine.voegProductToe(nonFood1);
        machine.voegProductToe(nonFood2);
        assertEquals(0.0, machine.getTotaalPrijs(), delta);
        machine.vulProductAan(nonFood1, 5);
        double expected = 15 * 5;
        assertEquals(expected, machine.getTotaalPrijs(), delta);
        machine.vulProductAan(nonFood2, 7);
        expected += 100 * 7;
        assertEquals(expected, machine.getTotaalPrijs(), delta);
    }

    @Test
    public void test_totaal_prijs_producten_met_korting() {
        machine.voegProductToe(snack1);
        machine.voegProductToe(snack2);
        assertEquals(0.0, machine.getTotaalPrijs(), delta);
        machine.vulProductAan(snack1, 5);
        double expected = 10 * 0.75 * 5;
        assertEquals(expected, machine.getTotaalPrijs(), delta);
        machine.vulProductAan(snack2, 7);
        expected += 20 * 0.75 * 7;
        assertEquals(expected, machine.getTotaalPrijs(), delta);
    }

    @Test
    public void test_voeg_nieuw_product_toe_met_eigenschappen_bestaand_product() {
        Snack snack3 = new Snack("Mars", 20);
        NonFood nonFood3 = new NonFood("Scheerapparaat", 100, false);
        Drink drink3 = new Drink("Sprite", 40);
        machine.voegProductToe(snack2);
        machine.voegProductToe(nonFood2);
        machine.voegProductToe(drink2);
        assertEquals(snack2, machine.vindProduct(snack3));
        assertEquals(nonFood2, machine.vindProduct(nonFood3));
        assertEquals(drink2, machine.vindProduct(drink3));
    }

    @Test
    public void test_voeg_nieuw_product_toe_verkeerde_klasse_zelfde_eigenschappen_succes(){
        // succes omdat checkaanwezig() enkel beschrijving controleert
        // IllegalArgumentException indien checkAanwezig() equals(Object o) zou gebruiken
        Product snack3 = new Product("Mars", 20);
        machine.voegProductToe(snack2);
        assertNotEquals(snack3, snack2);
        assertNotEquals(snack2,snack3);
        machine.vulProductAan(snack3,5);
        assertEquals(5,snack2.getAantal());

    }

}