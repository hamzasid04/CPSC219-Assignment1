package mvh.test;

import mvh.enums.Symbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTest {

    @Test
    void getSymbol() {
        assertEquals('$', Symbol.DEAD.getSymbol());
        assertEquals('#', Symbol.WALL.getSymbol());
        assertEquals('.', Symbol.FLOOR.getSymbol());
    }
}