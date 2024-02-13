package mvh.test;

import mvh.enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void getRowChange() {
        assertEquals(-1, Direction.NORTHWEST.getRowChange());
        assertEquals(-1, Direction.NORTH.getRowChange());
        assertEquals(-1, Direction.NORTHEAST.getRowChange());
        assertEquals(0, Direction.WEST.getRowChange());
        assertEquals(0, Direction.STAY.getRowChange());
        assertEquals(0, Direction.EAST.getRowChange());
        assertEquals(1, Direction.SOUTHWEST.getRowChange());
        assertEquals(1, Direction.SOUTH.getRowChange());
        assertEquals(1, Direction.SOUTHEAST.getRowChange());
    }

    @Test
    void getColumnChange() {
        assertEquals(-1, Direction.NORTHWEST.getColumnChange());
        assertEquals(0, Direction.NORTH.getColumnChange());
        assertEquals(1, Direction.NORTHEAST.getColumnChange());
        assertEquals(-1, Direction.WEST.getColumnChange());
        assertEquals(0, Direction.STAY.getColumnChange());
        assertEquals(1, Direction.EAST.getColumnChange());
        assertEquals(-1, Direction.SOUTHWEST.getColumnChange());
        assertEquals(0, Direction.SOUTH.getColumnChange());
        assertEquals(1, Direction.SOUTHEAST.getColumnChange());
    }

    @Test
    void getDirection() {
        assertEquals(Direction.NORTHWEST, Direction.getDirection(-1,-1));
        assertEquals(Direction.NORTH, Direction.getDirection(-1,0));
        assertEquals(Direction.NORTHEAST, Direction.getDirection(-1,1));
        assertEquals(Direction.WEST, Direction.getDirection(0,-1));
        assertEquals(Direction.STAY, Direction.getDirection(0,0));
        assertEquals(Direction.EAST, Direction.getDirection(0,1));
        assertEquals(Direction.SOUTHWEST, Direction.getDirection(1,-1));
        assertEquals(Direction.SOUTH, Direction.getDirection(1,0));
        assertEquals(Direction.SOUTHEAST, Direction.getDirection(1,1));
    }

    @Test
    void getDirections() {
        assertEquals(Direction.NORTHWEST, Direction.getDirections(-1,-1)[0]);
        assertEquals(Direction.NORTH, Direction.getDirections(-1,-1)[1]);
        assertEquals(Direction.WEST, Direction.getDirections(-1,-1)[2]);
        assertEquals(Direction.NORTH, Direction.getDirections(-1,0)[0]);
        assertEquals(Direction.NORTHWEST, Direction.getDirections(-1,0)[1]);
        assertEquals(Direction.NORTHEAST, Direction.getDirections(-1,0)[2]);
        assertEquals(Direction.NORTHEAST, Direction.getDirections(-1,1)[0]);
        assertEquals(Direction.NORTH, Direction.getDirections(-1,1)[1]);
        assertEquals(Direction.EAST, Direction.getDirections(-1,1)[2]);
        assertEquals(Direction.WEST, Direction.getDirections(0,-1)[0]);
        assertEquals(Direction.NORTHWEST, Direction.getDirections(0,-1)[1]);
        assertEquals(Direction.SOUTHWEST, Direction.getDirections(0,-1)[2]);
        assertEquals(Direction.STAY, Direction.getDirections(0,0)[0]);
        assertEquals(Direction.EAST, Direction.getDirections(0,1)[0]);
        assertEquals(Direction.NORTHEAST, Direction.getDirections(0,1)[1]);
        assertEquals(Direction.SOUTHEAST, Direction.getDirections(0,1)[2]);
        assertEquals(Direction.SOUTHWEST, Direction.getDirections(1,-1)[0]);
        assertEquals(Direction.SOUTH, Direction.getDirections(1,-1)[1]);
        assertEquals(Direction.WEST, Direction.getDirections(1,-1)[2]);
        assertEquals(Direction.SOUTH, Direction.getDirections(1,0)[0]);
        assertEquals(Direction.SOUTHWEST, Direction.getDirections(1,0)[1]);
        assertEquals(Direction.SOUTHEAST, Direction.getDirections(1,0)[2]);
        assertEquals(Direction.SOUTHEAST, Direction.getDirections(1,1)[0]);
        assertEquals(Direction.SOUTH, Direction.getDirections(1,1)[1]);
        assertEquals(Direction.EAST, Direction.getDirections(1,1)[2]);
    }
}