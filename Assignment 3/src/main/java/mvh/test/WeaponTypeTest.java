package mvh.test;

import mvh.enums.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTypeTest {

    @Test
    void getWeaponType() {
        assertEquals(WeaponType.CLUB, WeaponType.getWeaponType('C'));
        assertEquals(WeaponType.AXE, WeaponType.getWeaponType('A'));
        assertEquals(WeaponType.SWORD, WeaponType.getWeaponType('S'));
        assertThrows(IllegalArgumentException.class, () -> WeaponType.getWeaponType('X'));
    }

    @Test
    void getWeaponStrength() {
        assertEquals(2,WeaponType.CLUB.getWeaponStrength());
        assertEquals(3,WeaponType.AXE.getWeaponStrength());
        assertEquals(4,WeaponType.SWORD.getWeaponStrength());
    }
}