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

    @Nested
    class ChooseMove {
        @Test
        void chooseMoveEmpty() {
            Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
            World world = new World(5, 5);
            world.addEntity(2, 2, m1);
            assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
        }

        @Nested
        class OneEnemy {
            @Test
            void chooseMoveNE1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveNE2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveNE3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }


            @Test
            void chooseMoveN1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTH, m1.chooseMove(world));
            }


            @Test
            void chooseMoveNW1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }


            @Test
            void chooseMoveNW2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveNW3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }


            @Test
            void chooseMoveE1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.WEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveW1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.EAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSE1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSE2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSE3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(4, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveS1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTH, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSW1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSW2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(4, 3, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveSW3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(4, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }
        }

        @Nested
        class First {
            @Test
            void chooseMoveFirst1() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 3, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTH, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst4() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst5() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst6() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst7() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(3, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst8() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.EAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst9() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.WEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst10() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst11() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst12() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 4, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst13() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 3, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst14() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTH, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst15() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveFirst16() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }
        }

        @Nested
        class Ignore {
            @Test
            void chooseMoveIgnoreDead() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
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
                world.addEntity(4, 4, new Hero(0, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveIgnoreWalls() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
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
                world.addEntity(4, 4, Wall.getWall());
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }

            @Test
            void chooseMoveIgnoreMonsters() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
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
                assertEquals(Direction.NORTHWEST, m1.chooseMove(world));
            }
            @Test
            void chooseMoveOption2() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(3, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.chooseMove(world));
            }
            @Test
            void chooseMoveOption3() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(3, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }
            @Test
            void chooseMoveBlockedSoLookAtSecondOpponent() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(3, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTH, m1.chooseMove(world));
            }
            @Test
            void chooseMoveDefault() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                world.addEntity(2, 2, m1);
                world.addEntity(1, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.chooseMove(world));
            }
            @Test
            void chooseMoveRandom() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                Main.random = new Random(54321);
                world.addEntity(2, 2, m1);
                world.addEntity(1, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.WEST, m1.chooseMove(world));
            }
            @Test
            void chooseMoveStay() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(5, 5);
                Main.random = new Random(54321);
                world.addEntity(2, 2, m1);
                world.addEntity(1, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(3, 3, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(4, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.STAY, m1.chooseMove(world));
            }
        }
    }

    @Nested
    class AttackWhere {
        @Test
        void attackWhereEmpty() {
            Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
            World world = new World(3, 3);
            world.addEntity(1, 1, m1);
            assertNull(m1.attackWhere(world));
        }

        @Nested
        class OneEnemy {
            @Test
            void attackWhereNE() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereN() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTH, m1.attackWhere(world));
            }

            @Test
            void attackWhereNW() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.attackWhere(world));
            }

            @Test
            void attackWhereE() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.WEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereW() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(1, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.EAST, m1.attackWhere(world));
            }

            @Test
            void attackWhereSE() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereS() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(2, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTH, m1.attackWhere(world));
            }

            @Test
            void attackWhereSW() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(2, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.attackWhere(world));
            }
        }

        @Nested
        class First {

            @Test
            void attackWhereSWFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHEAST, m1.attackWhere(world));
            }

            @Test
            void attackWhereSFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTH, m1.attackWhere(world));
            }

            @Test
            void attackWhereSEFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.SOUTHWEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereWFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.EAST, m1.attackWhere(world));
            }

            @Test
            void attackWhereEFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.WEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereNWFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHEAST, m1.attackWhere(world));
            }

            @Test
            void attackWhereNFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTH, m1.attackWhere(world));
            }

            @Test
            void attackWhereNEFirst() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.attackWhere(world));
            }
        }

        @Nested
        class Ignore {
            @Test
            void attackWhereNEFirstIgnoreDead() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Hero(0, 'H', 10, 10));
                world.addEntity(0, 2, new Hero(0, 'H', 10, 10));
                world.addEntity(1, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(1, 2, new Hero(0, 'H', 10, 10));
                world.addEntity(2, 0, new Hero(0, 'H', 10, 10));
                world.addEntity(2, 1, new Hero(0, 'H', 10, 10));
                world.addEntity(2, 2, new Hero(0, 'H', 10, 10));
                assertEquals(Direction.NORTHWEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereNEFirstIgnoreWall() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, Wall.getWall());
                world.addEntity(0, 2, Wall.getWall());
                world.addEntity(1, 0, Wall.getWall());
                world.addEntity(1, 2, Wall.getWall());
                world.addEntity(2, 0, Wall.getWall());
                world.addEntity(2, 1, Wall.getWall());
                world.addEntity(2, 2, Wall.getWall());
                assertEquals(Direction.NORTHWEST, m1.attackWhere(world));
            }

            @Test
            void attackWhereNEFirstIgnoreMonsters() {
                Monster m1 = new Monster(10, 'M', WeaponType.getWeaponType('C'));
                World world = new World(3, 3);
                world.addEntity(1, 1, m1);
                world.addEntity(0, 0, new Hero(10, 'H', 10, 10));
                world.addEntity(0, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(0, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(1, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 0, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 1, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                world.addEntity(2, 2, new Monster(10, 'M', WeaponType.getWeaponType('C')));
                assertEquals(Direction.NORTHWEST, m1.attackWhere(world));
            }
        }
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