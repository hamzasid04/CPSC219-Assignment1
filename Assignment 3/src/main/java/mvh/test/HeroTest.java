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


    @Nested
    class chooseMove {
        @Test
        void chooseMoveEmpty() {
            Hero h1 = new Hero(10, 'H', 2, 10);
            World world = new World(5, 5);
            world.addEntity(2, 2, h1);
            assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
        }

        @Nested
        class OneEnemy {
            @Test
            void chooseMoveNW1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveNW2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveNW3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }


            @Test
            void chooseMoveN1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTH, h1.chooseMove(world));
            }


            @Test
            void chooseMoveNE1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }


            @Test
            void chooseMoveNE2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveNE3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }


            @Test
            void chooseMoveW1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.WEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveE1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.EAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSW1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSW2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSW3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveS1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTH, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSE1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSE2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveSE3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }
        }

        @Nested
        class First {
            @Test
            void chooseMoveFirst1() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTH, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst4() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst5() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst6() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst7() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst8() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.WEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst9() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(2, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.EAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst10() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst11() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst12() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst13() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst14() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTH, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst15() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst16() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }
        }

        @Nested
        class Ignore {

            @Test
            void chooseMoveIgnoreDead() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(0, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(0, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(0, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(0, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(0, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(0, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(0, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(4, 1, new Hero(0, 'H', 10, 10));
                world.addEntity(4, 2, new Hero(0, 'H', 10, 10));
                world.addEntity(4, 3, new Hero(0, 'H', 10, 10));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveIgnoreWalls() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 0, Wall.getWall());
                world.addEntity(0, 1, Wall.getWall());
                world.addEntity(0, 2, Wall.getWall());
                world.addEntity(0, 3, Wall.getWall());
                world.addEntity(0, 4, Wall.getWall());
                world.addEntity(1, 0, Wall.getWall());
                world.addEntity(1, 4, Wall.getWall());
                world.addEntity(2, 0, Wall.getWall());
                world.addEntity(2, 4, Wall.getWall());
                world.addEntity(3, 0, Wall.getWall());
                world.addEntity(3, 4, Wall.getWall());
                world.addEntity(4, 0, Wall.getWall());
                world.addEntity(4, 1, Wall.getWall());
                world.addEntity(4, 2, Wall.getWall());
                world.addEntity(4, 3, Wall.getWall());
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveIgnoreHeroes() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(0, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 4, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }

            @Test
            void chooseMoveOption2() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.chooseMove(world));
            }
            @Test
            void chooseMoveOption3() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.chooseMove(world));
            }
            @Test
            void chooseMoveBlockedSoLookAtSecondOpponent() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTH, h1.chooseMove(world));
            }
            @Test
            void chooseMoveDefault() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.chooseMove(world));
            }
            @Test
            void chooseMoveRandom() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                Main.random = new Random(54321);
                world.addEntity(2, 2, h1);
                world.addEntity(3, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.WEST, h1.chooseMove(world));
            }
            @Test
            void chooseMoveStay() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(5, 5);
                Main.random = new Random(54321);
                world.addEntity(2, 2, h1);
                world.addEntity(1, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(3, 3, new Hero(10, 'H', 2, 10));
                world.addEntity(4, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.STAY, h1.chooseMove(world));
            }
        }
    }

    @Nested
    class AttackWhere {
        @Test
        void attackWhereEmpty() {
            Hero h1 = new Hero(10, 'H', 2, 10);
            World world = new World(3, 3);
            world.addEntity(1, 1, h1);
            assertNull(h1.attackWhere(world));
        }

        @Nested
        class OneEnemy {
            @Test
            void attackWhereNW() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereN() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTH, h1.attackWhere(world));
            }

            @Test
            void attackWhereNE() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereW() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.WEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereE() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.EAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereSW() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereS() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTH, h1.attackWhere(world));
            }

            @Test
            void attackWhereSE() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.attackWhere(world));
            }
        }

        @Nested
        class Order {
            @Test
            void attackWhereNWFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereNFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTH, h1.attackWhere(world));
            }

            @Test
            void attackWhereNEFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHEAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereWFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.WEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereEFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.EAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereSWFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHWEST, h1.attackWhere(world));
            }

            @Test
            void attackWhereSFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTH, h1.attackWhere(world));
            }

            @Test
            void attackWhereSEFirst() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.attackWhere(world));
            }
        }

        @Nested
        class Ignore {
            @Test
            void attackWhereSEFirstIgnoreDead() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 0, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 1, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(0, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereSEFirstIgnoreWall() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 0, Wall.getWall());
                world.addEntity(0, 1, Wall.getWall());
                world.addEntity(0, 2, Wall.getWall());
                world.addEntity(1, 0, Wall.getWall());
                world.addEntity(1, 2, Wall.getWall());
                world.addEntity(2, 0, Wall.getWall());
                world.addEntity(2, 1, Wall.getWall());
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.attackWhere(world));
            }

            @Test
            void attackWhereSEFirstIgnoreHeroes() {
                Hero h1 = new Hero(10, 'H', 2, 10);
                World world = new World(3, 3);
                world.addEntity(1, 1, h1);
                world.addEntity(0, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 1, new Hero(10, 'H', 2, 10));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.SOUTHEAST, h1.attackWhere(world));
            }
        }
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