package mvh.test;

import mvh.Main;
import mvh.enums.Direction;
import mvh.enums.WeaponType;
import mvh.world.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {


    @Test
    void weaponStrength() {
        Hero h1 = new Hero(10, 'H', 2, 10);
        assertEquals(2, h1.weaponStrength());

        Hero h2 = new Hero(10, 'H', 3, 10);
        assertEquals(3, h2.weaponStrength());

        Hero h3 = new Hero(10, 'H', 4, 10);
        assertEquals(4, h3.weaponStrength());
    }

    @Test
    void armorStrength() {
        Hero h1 = new Hero(10, 'H', 2, 1);
        assertEquals(1, h1.armorStrength());

        Hero h2 = new Hero(10, 'H', 3, 2);
        assertEquals(2, h2.armorStrength());

        Hero h3 = new Hero(10, 'H', 4, 3);
        assertEquals(3, h3.armorStrength());
    }


    @Test
    void canMoveOnTopOf() {
        Hero ha = new Hero(10, 'H', 2, 10);
        assertFalse(ha.canMoveOnTopOf());

        Hero hd = new Hero(0, 'H', 2, 10);
        assertTrue(hd.canMoveOnTopOf());
    }

    @Test
    void canBeAttacked() {
        Hero ha = new Hero(10, 'H', 2, 10);
        assertTrue(ha.canBeAttacked());

        Hero hd = new Hero(0, 'H', 2, 10);
        assertFalse(hd.canBeAttacked());
    }

    @Test
    void string() {
        Entity.resetIDCounter();
        Hero hero = new Hero(10, 'H', 10, 10);
        Hero hero2 = new Hero(9, 'A', 8, 7);
        assertEquals("Hero(1)\tH\t10\tALIVE\t10\t10", hero.toString());
        assertEquals("Hero(2)\tA\t9\tALIVE\t8\t7", hero2.toString());
    }



}