package mvh.test;

import mvh.Menu;
import mvh.enums.WeaponType;
import mvh.util.Logger;
import mvh.util.Reader;
import mvh.world.*;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void testFile(){
        Menu.setup(new File("testlog.txt"));
        Monster e1 = new Monster(10,'M', WeaponType.SWORD);
        Hero e6 = new Hero(10,'H', 3,1);
        World loaded = Reader.loadWorld(new File("world.txt"));
        assertNull(loaded.getEntity(0,1));
        assertNull(loaded.getEntity(0,2));
        assertNull(loaded.getEntity(1,0));
        assertNull(loaded.getEntity(1,1));
        assertNull(loaded.getEntity(1,2));
        assertNull(loaded.getEntity(2,0));
        assertNull(loaded.getEntity(2,1));
        Monster l1 = (Monster)loaded.getEntity(0,0);
        Hero l6 = (Hero)loaded.getEntity(2,2);
        assertEquals(l1.getSymbol(), e1.getSymbol());
        assertEquals(l1.getHealth(), e1.getHealth());
        assertEquals(l1.getWeaponType(), e1.getWeaponType());
        assertEquals(l6.getSymbol(), e6.getSymbol());
        assertEquals(l6.getHealth(), e6.getHealth());
        assertEquals(l6.armorStrength(), e6.armorStrength());
        assertEquals(l6.weaponStrength(), e6.weaponStrength());
        assertEquals(3, loaded.getRows());
        assertEquals(3, loaded.getColumns());
    }


    @Test
    void testFileBig(){
        Menu.setup(new File("testlog.txt"));
        Monster e1 = new Monster(10,'A', WeaponType.AXE);
        Monster e2 = new Monster(9,'B', WeaponType.SWORD);
        Monster e3 = new Monster(8,'C', WeaponType.CLUB);
        Hero e4 = new Hero(8,'D', 5,2);
        Hero e5 = new Hero(7,'E', 4,1);
        Hero e6 = new Hero(6,'F', 3,1);
        World loaded = Reader.loadWorld(new File("worldbig.txt"));
        assertNull(loaded.getEntity(0,1));
        assertNull(loaded.getEntity(0,3));
        assertNull(loaded.getEntity(1,0));
        assertNull(loaded.getEntity(1,1));
        assertNull(loaded.getEntity(1,3));
        assertNull(loaded.getEntity(2,0));
        assertNull(loaded.getEntity(2,1));
        assertNull(loaded.getEntity(2,2));
        assertNull(loaded.getEntity(2,3));
        assertNull(loaded.getEntity(3,0));
        assertNull(loaded.getEntity(3,1));
        assertNull(loaded.getEntity(3,2));
        assertNull(loaded.getEntity(3,3));
        assertNull(loaded.getEntity(4,0));
        Monster l1 = (Monster)loaded.getEntity(0,0);
        Monster l2 = (Monster)loaded.getEntity(0,2);
        Monster l3 = (Monster)loaded.getEntity(1,2);
        Hero l4 = (Hero)loaded.getEntity(4,1);
        Hero l5 = (Hero)loaded.getEntity(4,2);
        Hero l6 = (Hero)loaded.getEntity(4,3);
        assertEquals(l1.getSymbol(), e1.getSymbol());
        assertEquals(l1.getHealth(), e1.getHealth());
        assertEquals(l1.getWeaponType(), e1.getWeaponType());
        assertEquals(l2.getSymbol(), e2.getSymbol());
        assertEquals(l2.getHealth(), e2.getHealth());
        assertEquals(l2.getWeaponType(), e2.getWeaponType());
        assertEquals(l3.getSymbol(), e3.getSymbol());
        assertEquals(l3.getHealth(), e3.getHealth());
        assertEquals(l3.getWeaponType(), e3.getWeaponType());
        assertEquals(l4.getSymbol(), e4.getSymbol());
        assertEquals(l4.getHealth(), e4.getHealth());
        assertEquals(l4.armorStrength(), e4.armorStrength());
        assertEquals(l4.weaponStrength(), e4.weaponStrength());
        assertEquals(l5.getSymbol(), e5.getSymbol());
        assertEquals(l5.getHealth(), e5.getHealth());
        assertEquals(l5.armorStrength(), e5.armorStrength());
        assertEquals(l5.weaponStrength(), e5.weaponStrength());
        assertEquals(l6.getSymbol(), e6.getSymbol());
        assertEquals(l6.getHealth(), e6.getHealth());
        assertEquals(l6.armorStrength(), e6.armorStrength());
        assertEquals(l6.weaponStrength(), e6.weaponStrength());
        assertEquals(5, loaded.getRows());
        assertEquals(4, loaded.getColumns());
    }

}
