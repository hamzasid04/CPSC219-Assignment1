package mvh.test;

import mvh.enums.Direction;
import mvh.enums.WeaponType;
import mvh.world.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void isActive() {
        World w1 = new World(3,3);
        assertTrue(w1.isActive());
    }

    @Test
    void endSimulation() {
        World w1 = new World(3,3);
        assertTrue(w1.isActive());
        w1.endSimulation();
        assertFalse(w1.isActive());
    }

    @Test
    void getLocal3x3() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        Entity e2 = new Monster(0,'M', WeaponType.AXE);
        Entity e3 = Wall.getWall();
        Entity e5 = new Hero(10,'H', 10,10);
        Entity e6 = new Hero(0,'H', 10,10);
        w1.addEntity(0,0,e1);
        w1.addEntity(0,1,e2);
        w1.addEntity(1,0,e3);
        w1.addEntity(2,0,e5);
        w1.addEntity(2,1,e6);
        World local = w1.getLocal(3,1,1);
        assertSame(e1, local.getEntity(0,0));
        assertSame(e2, local.getEntity(0,1));
        assertSame(null, local.getEntity(0,2));
        assertSame(e3, local.getEntity(1,0));
        assertSame(null, local.getEntity(1,1));
        assertSame(null, local.getEntity(1,2));
        assertSame(e5, local.getEntity(2,0));
        assertSame(e6, local.getEntity(2,1));
        assertSame(null, local.getEntity(2,2));
    }
    @Test
    void getLocal3x3ShiftNE() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        Entity e2 = new Monster(0,'M', WeaponType.AXE);
        Entity e3 = Wall.getWall();
        Entity e5 = new Hero(10,'H', 10,10);
        Entity e6 = new Hero(0,'H', 10,10);
        w1.addEntity(0,0,e1);
        w1.addEntity(0,1,e2);
        w1.addEntity(1,0,e3);
        w1.addEntity(2,0,e5);
        w1.addEntity(2,1,e6);
        World local = w1.getLocal(3,0,0);
        assertSame(e1, local.getEntity(1,1));
        assertSame(e2, local.getEntity(1,2));
        assertSame(e3, local.getEntity(2,1));
        assertSame(null, local.getEntity(2,2));
        assertSame(Wall.getWall(), local.getEntity(0,0));
        assertSame(Wall.getWall(), local.getEntity(0,1));
        assertSame(Wall.getWall(), local.getEntity(0,2));
        assertSame(Wall.getWall(), local.getEntity(1,0));
        assertSame(Wall.getWall(), local.getEntity(2,0));
    }
    @Test
    void getLocal3x3ShiftSW() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        Entity e2 = new Monster(0,'M', WeaponType.AXE);
        Entity e3 = Wall.getWall();
        Entity e5 = new Hero(10,'H', 10,10);
        Entity e6 = new Hero(0,'H', 10,10);
        w1.addEntity(0,0,e1);
        w1.addEntity(0,1,e2);
        w1.addEntity(1,0,e3);
        w1.addEntity(2,0,e5);
        w1.addEntity(2,1,e6);
        World local = w1.getLocal(3,2,2);
        assertSame(null, local.getEntity(0,0));
        assertSame(null, local.getEntity(0,1));
        assertSame(e6, local.getEntity(1,0));
        assertSame(null, local.getEntity(1,1));
        assertSame(Wall.getWall(), local.getEntity(0,2));
        assertSame(Wall.getWall(), local.getEntity(1,2));
        assertSame(Wall.getWall(), local.getEntity(2,0));
        assertSame(Wall.getWall(), local.getEntity(2,1));
        assertSame(Wall.getWall(), local.getEntity(2,2));
    }
    @Test
    void getLocal5x5() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        Entity e2 = new Monster(0,'M', WeaponType.AXE);
        Entity e3 = Wall.getWall();
        Entity e5 = new Hero(10,'H', 10,10);
        Entity e6 = new Hero(0,'H', 10,10);
        w1.addEntity(0,0,e1);
        w1.addEntity(0,1,e2);
        w1.addEntity(1,0,e3);
        w1.addEntity(2,0,e5);
        w1.addEntity(2,1,e6);
        World local = w1.getLocal(5,1,1);
        assertSame(e1, local.getEntity(1,1));
        assertSame(e2, local.getEntity(1,2));
        assertSame(null, local.getEntity(1,3));
        assertSame(e3, local.getEntity(2,1));
        assertSame(null, local.getEntity(2,2));
        assertSame(null, local.getEntity(2,3));
        assertSame(e5, local.getEntity(3,1));
        assertSame(e6, local.getEntity(3,2));
        assertSame(null, local.getEntity(3,3));
        assertSame(Wall.getWall(), local.getEntity(0,0));
        assertSame(Wall.getWall(), local.getEntity(0,1));
        assertSame(Wall.getWall(), local.getEntity(0,2));
        assertSame(Wall.getWall(), local.getEntity(0,3));
        assertSame(Wall.getWall(), local.getEntity(0,4));
        assertSame(Wall.getWall(), local.getEntity(1,0));
        assertSame(Wall.getWall(), local.getEntity(1,4));
        assertSame(Wall.getWall(), local.getEntity(2,0));
        assertSame(Wall.getWall(), local.getEntity(2,4));
        assertSame(Wall.getWall(), local.getEntity(3,0));
        assertSame(Wall.getWall(), local.getEntity(3,4));
        assertSame(Wall.getWall(), local.getEntity(4,0));
        assertSame(Wall.getWall(), local.getEntity(4,1));
        assertSame(Wall.getWall(), local.getEntity(4,2));
        assertSame(Wall.getWall(), local.getEntity(4,3));
        assertSame(Wall.getWall(), local.getEntity(4,4));
    }

    @Test
    void advanceSimulationEnd() {
        World w1 = new World(3,3);
        assertTrue(w1.isActive());
        w1.advanceSimulation();
        assertFalse(w1.isActive());
    }

    @Test
    void moveEntity() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        w1.addEntity(0,0,e1);
        assertSame(e1,w1.getEntity(0,0));
        w1.moveEntity(0,0,Direction.SOUTHEAST);
        assertNull(w1.getEntity(0,0));
        assertSame(e1,w1.getEntity(1,1));
        w1.moveEntity(1,1,Direction.NORTH);
        assertNull(w1.getEntity(1,1));
        assertSame(e1,w1.getEntity(0,1));
    }


    @Test
    void getEntity() {
        World w1 = new World(3,3);
        Entity e1 = new Monster(10,'M', WeaponType.AXE);
        Entity e2 = new Monster(0,'M', WeaponType.AXE);
        Entity e3 = Wall.getWall();
        Entity e5 = new Hero(10,'H', 10,10);
        Entity e6 = new Hero(0,'H', 10,10);
        w1.addEntity(0,0,e1);
        w1.addEntity(0,1,e2);
        w1.addEntity(1,0,e3);
        w1.addEntity(2,0,e5);
        w1.addEntity(2,1,e6);
        assertSame(e1,w1.getEntity(0,0));
        assertSame(e2,w1.getEntity(0,1));
        assertSame(e3,w1.getEntity(1,0));
        assertNull(w1.getEntity(1,1));
        assertSame(e5,w1.getEntity(2,0));
        assertSame(e6,w1.getEntity(2,1));
        assertSame(e1,w1.getEntity(1,1, Direction.NORTHWEST));
        assertSame(e2,w1.getEntity(1,2, Direction.NORTHWEST));
        assertSame(e3,w1.getEntity(2,1, Direction.NORTHWEST));
        assertNull(w1.getEntity(2,2, Direction.NORTHWEST));
        assertSame(e5,w1.getEntity(3,1, Direction.NORTHWEST));
        assertSame(e6,w1.getEntity(3,2, Direction.NORTHWEST));
    }

    @Test
    void canMoveOnTopOf() {
        World w1 = new World(3,3);
        w1.addEntity(0,0,new Monster(10,'M', WeaponType.AXE));
        w1.addEntity(0,1,new Monster(0,'M', WeaponType.AXE));
        w1.addEntity(1,0,Wall.getWall());
        w1.addEntity(2,0,new Hero(10,'H', 10,10));
        w1.addEntity(2,1,new Hero(0,'H', 10,10));
        assertFalse(w1.canMoveOnTopOf(0,0));
        assertTrue(w1.canMoveOnTopOf(0,1));
        assertFalse(w1.canMoveOnTopOf(1,0));
        assertTrue(w1.canMoveOnTopOf(1,1));
        assertFalse(w1.canMoveOnTopOf(2,0));
        assertTrue(w1.canMoveOnTopOf(2,1));
        assertFalse(w1.canMoveOnTopOf(1,1, Direction.NORTHWEST));
        assertTrue(w1.canMoveOnTopOf(1,2, Direction.NORTHWEST));
        assertFalse(w1.canMoveOnTopOf(2,1, Direction.NORTHWEST));
        assertTrue(w1.canMoveOnTopOf(2,2, Direction.NORTHWEST));
        assertFalse(w1.canMoveOnTopOf(3,1, Direction.NORTHWEST));
        assertTrue(w1.canMoveOnTopOf(3,2, Direction.NORTHWEST));
    }

    @Test
    void canBeAttacked() {
        World w1 = new World(3,3);
        w1.addEntity(0,0,new Monster(10,'M', WeaponType.AXE));
        w1.addEntity(0,1,new Monster(0,'M', WeaponType.AXE));
        w1.addEntity(1,0,Wall.getWall());
        w1.addEntity(2,0,new Hero(10,'H', 10,10));
        w1.addEntity(2,1,new Hero(0,'H', 10,10));
        assertTrue(w1.canBeAttacked(0,0));
        assertFalse(w1.canBeAttacked(0,1));
        assertFalse(w1.canBeAttacked(1,0));
        assertFalse(w1.canBeAttacked(1,1));
        assertTrue(w1.canBeAttacked(2,0));
        assertFalse(w1.canBeAttacked(2,1));
        assertTrue(w1.canBeAttacked(1,1, Direction.NORTHWEST));
        assertFalse(w1.canBeAttacked(1,2, Direction.NORTHWEST));
        assertFalse(w1.canBeAttacked(2,1, Direction.NORTHWEST));
        assertFalse(w1.canBeAttacked(2,2, Direction.NORTHWEST));
        assertTrue(w1.canBeAttacked(3,1, Direction.NORTHWEST));
        assertFalse(w1.canBeAttacked(3,2, Direction.NORTHWEST));
    }

    @Test
    void isHero() {
        World w1 = new World(3,3);
        w1.addEntity(0,0,new Monster(10,'M', WeaponType.AXE));
        w1.addEntity(0,1,new Monster(0,'M', WeaponType.AXE));
        w1.addEntity(1,0,Wall.getWall());
        w1.addEntity(2,0,new Hero(10,'H', 10,10));
        w1.addEntity(2,1,new Hero(0,'H', 10,10));
        assertFalse(w1.isHero(0,0));
        assertFalse(w1.isHero(0,1));
        assertFalse(w1.isHero(1,0));
        assertFalse(w1.isHero(1,1));
        assertTrue(w1.isHero(2,0));
        assertTrue(w1.isHero(2,1));
    }

    @Test
    void isMonster() {
        World w1 = new World(3,3);
        w1.addEntity(0,0,new Monster(10,'M', WeaponType.AXE));
        w1.addEntity(0,1,new Monster(0,'M', WeaponType.AXE));
        w1.addEntity(1,0,Wall.getWall());
        w1.addEntity(2,0,new Hero(10,'H', 10,10));
        w1.addEntity(2,1,new Hero(0,'H', 10,10));
        assertTrue(w1.isMonster(0,0));
        assertTrue(w1.isMonster(0,1));
        assertFalse(w1.isMonster(1,0));
        assertFalse(w1.isMonster(1,1));
        assertFalse(w1.isMonster(2,0));
        assertFalse(w1.isMonster(2,1));
    }



}