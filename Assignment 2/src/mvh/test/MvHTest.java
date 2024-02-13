package mvh.test;
import mvh.enums.Direction;
import mvh.enums.WeaponType;
import mvh.util.Reader;
import mvh.world.Hero;
import mvh.world.Monster;
import mvh.world.World;
import org.junit.jupiter.api.Test;

/**
 * Class to assist reading in world file
 * @author Jonathan Hudson, Hamza Siddiqui hamza.siddiqui@ucalgary.ca TUT02 10/30/2023
 * @version 1.1
 */

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
public class MvHTest {
    @Test
    public void testWorldString(){

    }

    @Test
    public void testLoaderWorldSimple(){
        World w = Reader.loadWorld(new File("world.txt"));
        assertNotNull(w);
    }
    @Test
    public void testLoadWorldWithNonExistentFile() {
        World world = Reader.loadWorld(new File("nonexistentfile.txt"));
        assertNull(world);
    }
    @Test
    public void testLoadWorldWithHero() {

        File file = new File("heroSampleWorld.txt");
        World world = Reader.loadWorld(file);
        assertNotNull(world);
        assertEquals(Hero.class, world.getEntity(1, 1).getClass());
    }
    @Test
    public void testLoadWorldWithMonster() {

        File file = new File("monsterSampleWorld.txt");
        World world = Reader.loadWorld(file);
        assertNotNull(world);
        assertEquals(Monster.class, world.getEntity(1, 1).getClass());
    }
    @Test
    public void testChooseMoveTowardsMonsterDirection() {
        // Create a 5x5 World with a Monster to the NORTHEAST of the Hero
        World local = new World(5, 5);
        Hero hero = new Hero(100, 'H', 10, 5);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        local.addEntity(2, 2, hero);
        local.addEntity(0, 4, monster);

        Direction moveDirection = hero.chooseMove(local);
        assertEquals(Direction.NORTHEAST, moveDirection);
    }
    @Test
    public void testChooseMoveDefaultNorthwestDirection() {
        // Create a 5x5 World with only the Hero
        World local = new World(5, 5);
        Hero hero = new Hero(100, 'H', 10, 5);
        local.addEntity(2, 2, hero);

        Direction moveDirection = hero.chooseMove(local);
        assertEquals(Direction.NORTHWEST, moveDirection);
    }
    @Test
    public void testAttackWhereMonsterNearby() {
        // Create a 3x3 World with a Monster to the NORTH of the Hero
        World local = new World(3, 3);
        Hero hero = new Hero(100, 'H', 10, 5);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        local.addEntity(1, 1, hero);
        local.addEntity(0, 1, monster);

        Direction attackDirection = hero.attackWhere(local);
        assertEquals(Direction.NORTH, attackDirection);
    }
    @Test
    public void testAttackWhereNoMonsterNearby() {
        // Create a 3x3 World with only the Hero
        World local = new World(3, 3);
        Hero hero = new Hero(100, 'H', 10, 5);
        local.addEntity(1, 1, hero);

        Direction attackDirection = hero.attackWhere(local);
        assertNull(attackDirection);
    }
    @Test
    public void testChooseMoveTowardsHeroDirection() {
        // Create a 5x5 World with a Hero to the SOUTHEAST of the Monster
        World local = new World(5, 5);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        Hero hero = new Hero(100, 'H', 10, 5);
        local.addEntity(2, 2, monster);
        local.addEntity(4, 4, hero);

        Direction moveDirection = monster.chooseMove(local);
        assertEquals(Direction.SOUTHEAST, moveDirection);
    }

    @Test
    public void testChooseMoveDefaultSoutheastDirection() {
        // Create a 5x5 World with only the Monster
        World local = new World(5, 5);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        local.addEntity(2, 2, monster);

        Direction moveDirection = monster.chooseMove(local);
        assertEquals(Direction.SOUTHEAST, moveDirection);
    }

    @Test
    public void testAttackWhereHeroNearby() {
        // Create a 3x3 World with a Hero to the SOUTH of the Monster
        World local = new World(3, 3);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        Hero hero = new Hero(100, 'H', 10, 5);
        local.addEntity(1, 1, monster);
        local.addEntity(2, 1, hero);

        Direction attackDirection = monster.attackWhere(local);
        assertEquals(Direction.SOUTH, attackDirection);
    }

    @Test
    public void testAttackWhereNoHeroNearby() {
        // Create a 3x3 World with only the Monster
        World local = new World(3, 3);
        Monster monster = new Monster(100, 'M', WeaponType.SWORD);
        local.addEntity(1, 1, monster);

        Direction attackDirection = monster.attackWhere(local);
        assertNull(attackDirection);
    }
    @Test
    public void testWorldStringForAlive(){
        String expectedOutput = """
                #####
                #M..#
                #...#
                #..H#
                #####""";

        World w = new World(3,3);
        w.addEntity(0,0,new Monster(10,'M',WeaponType.SWORD));
        w.addEntity(2,2,new Hero(10,'H',3,1));
        String actualOutput = w.worldString().trim();
        System.out.println(w.worldString());
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void testWorldStringForDead(){
        String expectedOutput = """
                #####
                #$..#
                #...#
                #..$#
                #####""";

        World w = new World(3,3);
        w.addEntity(0,0,new Monster(0,'M',WeaponType.SWORD));
        w.addEntity(2,2,new Hero(0,'H',3,1));
        String actualOutput = w.worldString().trim();
        System.out.println(w.worldString());
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testGameStringForEmptyWorld() {
        World world = new World(3, 3); // Create a 3x3 world
        String expectedOutput = """
                #####
                #...#
                #...#
                #...#
                #####
                NAME  	S	H	STATE	INFO""";
        assertEquals(expectedOutput.trim(), world.gameString().trim());
    }

    @Test
    public void testGameStringWithEntities() {
        World world = new World(3, 3); // Create a 3x3 world
        Hero hero = new Hero(10,'H',2,2); // Assuming a Hero class exists with a symbol 'H'
        Monster monster = new Monster(10,'M',WeaponType.AXE); // Assuming a Monster class exists with a symbol 'M'

        world.addEntity(1, 1, hero);
        world.addEntity(2, 2, monster);

        String expectedOutput = """
                #####
                #...#
                #.H.#
                #..M#
                #####
                NAME  	S	H	STATE	INFO
                Hero(1)	H	10	ALIVE	2	2
                Mons(2)	M	10	ALIVE	AXE""";

        assertEquals(expectedOutput.trim(), world.gameString().trim());
    }

}
