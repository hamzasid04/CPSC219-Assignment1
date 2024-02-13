package mvh.util;

import mvh.world.*;

import java.io.*;


public final class Writer {

    /**
     * Saves the current state of the world to a file.
     *
     * @param world The world object to be saved.
     * @param file  The file to which the world data will be written.
     * @throws IOException If there is an issue writing to the file.
     */
    public static void saveWorld(World world, File file) throws IOException {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
            // Write the dimensions of the world
            fileWriter.write(world.getRows() + System.lineSeparator());
            fileWriter.write(world.getColumns() + System.lineSeparator());

            // Iterate over each cell in the world
            for (int row = 0; row < world.getRows(); row++) {
                for (int col = 0; col < world.getColumns(); col++) {
                    Entity entity = world.getEntity(row, col);
                    if (entity != null) {  // Check if there is an entity at this position
                        fileWriter.write(row + "," + col + ",");
                        fileWriter.write(entity.getClass().getSimpleName().toUpperCase() + ",");
                        fileWriter.write(entity.getSymbol() + ",");
                        fileWriter.write(entity.getHealth() + "");

                        // Additional attributes for specific entity types
                        if (entity instanceof Monster) {
                            Monster monster = (Monster) entity;
                            char monsWeaponChar = monster.getWeaponType().name().charAt(0);
                            fileWriter.write("," + monsWeaponChar);
                        } else if (entity instanceof Hero) {
                            Hero hero = (Hero) entity;
                            fileWriter.write("," + hero.weaponStrength());
                            fileWriter.write("," + hero.armorStrength());
                        }
                        fileWriter.newLine(); // Finish the line for this entity
                    } else {
                        fileWriter.write(row + "," + col);
                        fileWriter.newLine();
                    }
                }
            }
            fileWriter.flush(); // Ensure all data is written to the file
        }
    }
}
