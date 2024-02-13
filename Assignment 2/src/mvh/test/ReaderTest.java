package mvh.test;

import mvh.Menu;
import mvh.enums.WeaponType;
import mvh.util.Logger;
import mvh.util.Reader;
import mvh.world.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    public void loadWorldWrongFile(){

        File file = new File("WrongFileName.txt");
        String expectedErrorMessage = "Please enter exact name of the file including the file's extension (.txt,...)";

        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            World w  = Reader.loadWorld(file);

        });
        assertTrue(exception.getMessage().contains("File not found. Make sure you have entered the exact name of the file."));
    }


}
