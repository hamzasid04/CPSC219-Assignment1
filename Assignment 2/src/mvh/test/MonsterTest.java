package mvh.test;

import mvh.Main;
import mvh.enums.Direction;
import mvh.enums.WeaponType;
import mvh.world.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    void weaponStrength() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        assertEquals(2, mc.weaponStrength());

        Monster ma = new Monster(10, 'M', WeaponType.getWeaponType('A'));
        assertEquals(3, ma.weaponStrength());

        Monster ms = new Monster(10, 'M', WeaponType.getWeaponType('S'));
        assertEquals(4, ms.weaponStrength());
    }

    @Test
    void armorStrength() {
        Monster mc = new Monster(10, 'M', WeaponType.getWeaponType('C'));
        assertEquals(2, mc.armorStrength());

        Monster ma = new Monster(10, 'M', WeaponType.getWeaponType('A'));
        assertEquals(2, ma.armorStrength());

        Monster ms = new Monster(10, 'M', WeaponType.getWeaponType('S'));
        assertEquals(2, ms.armorStrength());

    }

    @Test
    void canMoveOnTopOf() {
        Monster ma = new Monster(10, 'M', WeaponType.getWeaponType('S'));
        assertFalse(ma.canMoveOnTopOf());

        Monster md = new Monster(0, 'M', WeaponType.getWeaponType('S'));
        assertTrue(md.canMoveOnTopOf());
    }

    @Test
    void canBeAttacked() {
        Monster ma = new Monster(10, 'M', WeaponType.getWeaponType('S'));
        assertTrue(ma.canBeAttacked());

        Monster md = new Monster(0, 'M', WeaponType.getWeaponType('S'));
        assertFalse(md.canBeAttacked());
    }

    @Test
    void string(){
        Entity.resetIDCounter();
        Monster monster = new Monster(10,'M', WeaponType.CLUB);
        Monster monster2 = new Monster(0,'B', WeaponType.AXE);
        assertEquals("Mons(1)\tM\t10\tALIVE\tCLUB", monster.toString());
        assertEquals("Mons(2)\tB\t0\tDEAD\tAXE", monster2.toString());
    }


}