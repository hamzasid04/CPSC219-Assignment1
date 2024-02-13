package mvh.test;

import mvh.world.Wall;
import mvh.world.World;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void weaponStrength() {
        Assertions.assertEquals(0, Wall.getWall().weaponStrength());
    }

    @Test
    void armorStrength() {
        assertEquals(0,Wall.getWall().armorStrength());
    }

    @Test
    void chooseMove() {
        assertNull(Wall.getWall().chooseMove(new World(3,3)));
    }

    @Test
    void attackWhere() {
        assertNull(Wall.getWall().attackWhere(new World(3,3)));
    }

    @Test
    void canMoveOnTopOf() {
        assertFalse(Wall.getWall().canMoveOnTopOf());
    }

    @Test
    void canBeAttacked() {
        assertFalse(Wall.getWall().canBeAttacked());
    }
}