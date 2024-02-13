package mvh.test;

import mvh.enums.WeaponType;
import mvh.world.Entity;
import mvh.world.Hero;
import mvh.world.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void getSymbol() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        assertEquals('M', mc.getSymbol());
        Hero h1 = new Hero(10, 'H', 2, 10);
        assertEquals('H', h1.getSymbol());
    }

    @Test
    void getHealth() {
        Monster mc = new Monster(11, 'M', WeaponType.getWeaponType('C'));
        assertEquals(11, mc.getHealth());
        Hero h1 = new Hero(10, 'H', 2, 10);
        assertEquals(10, h1.getHealth());
    }

    @Test
    void isAlive() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        assertTrue(mc.isAlive());
        Hero h1 = new Hero(0, 'H', 2, 10);
        assertFalse(h1.isAlive());
    }

    @Test
    void isDead() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        assertFalse(mc.isDead());
        Hero h1 = new Hero(0, 'H', 2, 10);
        assertTrue(h1.isDead());
    }

    @Test
    void damage() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        mc.damage(5);
        assertEquals(5,mc.getHealth());
        assertTrue(mc.isAlive());
        mc.damage(4);
        assertEquals(1,mc.getHealth());
        assertTrue(mc.isAlive());
        mc.damage(1);
        assertEquals(0,mc.getHealth());
        assertFalse(mc.isAlive());
        Hero h1 = new Hero(10, 'H', 2, 10);
        assertTrue(h1.isAlive());
        h1.damage(5);
        assertEquals(5,h1.getHealth());
        assertTrue(h1.isAlive());
        h1.damage(4);
        assertEquals(1,h1.getHealth());
        assertTrue(h1.isAlive());
        h1.damage(10);
        assertEquals(0,h1.getHealth());
        assertFalse(h1.isAlive());
    }

    @Test
    void shortString() {
        Entity.resetIDCounter();
        Hero hero = new Hero(10,'H',10,10);
        Monster monster = new Monster(10,'M', WeaponType.CLUB);
        Hero hero2 = new Hero(9,'A',8,7);
        Monster monster2 = new Monster(0,'B', WeaponType.AXE);
        assertEquals("Hero(1)", hero.shortString());
        assertEquals("Mons(2)", monster.shortString());
        assertEquals("Hero(3)", hero2.shortString());
        assertEquals("Mons(4)", monster2.shortString());
    }

    @Test
    void testToString() {
        Entity.resetIDCounter();
        Hero hero = new Hero(10,'H',10,10);
        Monster monster = new Monster(10,'M', WeaponType.CLUB);
        Hero hero2 = new Hero(9,'A',8,7);
        Monster monster2 = new Monster(0,'B', WeaponType.AXE);
        assertEquals("Hero(1)\tH\t10\tALIVE", hero.toString().substring(0,18));
        assertEquals("Mons(2)\tM\t10\tALIVE", monster.toString().substring(0,18));
        assertEquals("Hero(3)\tA\t9\tALIVE", hero2.toString().substring(0,17));
        assertEquals("Mons(4)\tB\t0\tDEAD", monster2.toString().substring(0,16));
    }
}