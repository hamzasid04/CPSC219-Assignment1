package mvh.util;

import mvh.enums.WeaponType;
import mvh.world.*;

import java.io.*;
import java.util.Scanner;

/**
 * Class to assist reading in world file
 * @author Jonathan Hudson
 * @version 1.0
 */
public final class Reader {

    public static World loadWorld(File file) {
        World w = null;

        if(file == null) {
            Scanner scannerInput = new Scanner(System.in);
            System.out.println("Please enter exact name of the file including the file's extension (.txt,...)");
            String fileName = scannerInput.nextLine();
            file = new File(fileName);
        }
        try (Scanner fileReader = new Scanner(file)) {

            int numOfrows  = Integer.parseInt(fileReader.nextLine());
            int numOfcols = Integer.parseInt(fileReader.nextLine());
            // makes a 2d array with values filled with null.
            w = new World(numOfrows,numOfcols);

            //while it is true that there exists another line
            while (fileReader.hasNextLine()){

                //store the next line as a string
                String lineContents = fileReader.nextLine();
                //split the contents by a comma
                String[] singleParts = lineContents.split(",");

                int specifiedRow = Integer.parseInt(singleParts[0]);
                int specifiedCol = Integer.parseInt(singleParts[1]);

                if(singleParts.length > 2){
                    // common parts of both heroes and mosnters are thier health, the symbol and the name which are located at same index
                    String entityName = singleParts[2].toUpperCase();
                    String entitySymbolString = singleParts[3].toUpperCase();
                    char entitySymbol = entitySymbolString.charAt(0);
                    int entityHealth = Integer.parseInt(singleParts[4]);
                    if (entityName.equals("MONSTER")){
                        String weaponTypeString = singleParts[5].toUpperCase();
                        char weaponTypeChar = weaponTypeString.charAt(0);
                        w.addEntity(specifiedRow,specifiedCol,new Monster(entityHealth,entitySymbol, WeaponType.getWeaponType(weaponTypeChar)));
                    } else if (entityName.equals("HERO")) {
                        int weaponStrength = Integer.parseInt(singleParts[5]);
                        int armorStrength = Integer.parseInt(singleParts[6]);
                        w.addEntity(specifiedRow,specifiedCol,new Hero(entityHealth,entitySymbol,weaponStrength,armorStrength));
                    }

                }


            }
            //error that will be siplayed if file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Make sure you have entered the exact name of the file.");
        }

        System.out.println(w);
        return w;
    }
}
