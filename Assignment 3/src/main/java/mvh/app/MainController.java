/**
 * Name : Hamza Siddiqui
 * hamza.siddiqui@ucalgary.ca
 * Date:  29-Nov-2023
 * TUT 02
 * */

package mvh.app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvh.enums.WeaponType;
import mvh.util.Reader;
import mvh.util.Writer;
import mvh.world.Entity;
import mvh.world.Hero;
import mvh.world.Monster;
import mvh.world.World;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    //Store the data of editor
    private World world;
    private Entity entity;
    private Monster monster;

    /**
     * Set up the window state
     */
    @FXML
    public void initialize() {
    }

    @FXML
    private Label status_display;
    @FXML
    private TextField hero_row;
    @FXML
    private TextField hero_col;

    @FXML
    private TextField mons_col;

    @FXML
    private TextField mons_row;

    @FXML
    private TextField hero_armorStrength;

    @FXML
    private TextArea grid_display;
    @FXML
    private TextField deletion_Col;

    @FXML
    private TextField deletion_row;

    @FXML
    private TextField hero_health;

    @FXML
    private TextField hero_symbol;

    @FXML
    private TextField lookup_col;

    @FXML
    private TextArea lookup_display;

    @FXML
    private TextField lookup_row;

    @FXML
    private TextField hero_weaponStrength;

    @FXML
    private TextField mons_health;

    @FXML
    private TextField mons_symbol;

    @FXML
    private ChoiceBox<String> mons_weaponType;

    private String[] weapons = {"AXE", "SWORD", "CLUB"};

    @FXML
    private TextField world_Col;

    @FXML
    private TextField world_Row;


    @FXML
    private Font x1;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
    /**
     * Displays details of the entity located at the given row and column in the world.
     * It shows the information in a dedicated text area on the GUI.
     *
     * @param event The event or "lookup button"  that triggered the method call.
     */
    @FXML
    void lookup_info(ActionEvent event) {
        try {


            int lookupRow = Integer.parseInt(lookup_row.getText());
            int lookupCol = Integer.parseInt(lookup_col.getText());

            entity = world.getEntity(lookupRow, lookupCol);
            if (entity instanceof Monster) {
                WeaponType weaponType = ((Monster) entity).getWeaponType();
                lookup_display.setText("Entity: Monster \n" +
                        "Symbol: " + entity.getSymbol() + "\n" +
                        "Health: " + entity.getHealth() + "\n" +
                        "Weapon type: " + ((Monster) entity).getWeaponType() + "\n"
                );
                status_display.setText("Displayed details of Monster entity");
            } else if (entity instanceof Hero) {
                lookup_display.setText("Entity: Hero\n" +
                        "Symbol: " + entity.getSymbol() + '\n' +
                        "Health: " + entity.getHealth() + '\n' +
                        "Weapon Strength: " + entity.weaponStrength() + '\n' +
                        "Armor Strength: " + entity.armorStrength() + '\n'
                );
                status_display.setText("Displayed details of Hero entity");
            } else if (entity == null) {
                lookup_display.setText("No entity is present at given location");
                status_display.setText("No entity found");}
            } catch(NumberFormatException e){
                status_display.setText("Error: World dimensions must be integers.");
            } catch(IllegalArgumentException e){
                status_display.setText("Error: " + e.getMessage());
            }
}
/**
 * Displays the basic information about the program, the author and his email
 * @param event The event or "create world" button that triggers the method call.
 * */
    @FXML
    void about(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this program");
        alert.setHeaderText("Author: Hamza Siddiqui\nEmail: hamza.siddiqui@ucalgary.ca");
        alert.setContentText("Version 1.0\nThis program is designed to simulate a game involving monsters and heroes fighting one another and which one wins. Monsters have ability to choose health and weapon type among several while heroes have option to choose health, armor strength and weapon strength of default sword only. Monster and Heroes are able to attack one another when they are in range of one another. They are surrounded by walls on all 4 sides. It is all displayed and interacted graphically now instead of displaying and interacting it with the console");
        alert.showAndWait();
    }

    /**
     * Creates a new world with the specified number of rows and columns.
     * It updates the grid display to show the newly created world.
     *
     * @param event The event or 'create world button' that triggered the method call.
     */
    @FXML
    void create_world(ActionEvent event) {
        try {
            int worldRow = Integer.parseInt(world_Row.getText());
            int worldCol = Integer.parseInt(world_Col.getText());
            // Add additional conditions if necessary to validate the row and column inputs
            world = new World(worldRow, worldCol);
            grid_display.setText(world.worldString());
            status_display.setText("Successfully created a world with " + worldRow + " rows and " + worldCol + " columns.");
        } catch (NumberFormatException e) {
            status_display.setText("Error: World dimensions must be integers.");
        } catch (IllegalArgumentException e) {
            status_display.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    void file(ActionEvent event) {

    }

    @FXML
    void help(ActionEvent event) {

    }
/**
 * Loads the world from user selected file following the structure of how a basic file is read in this program
 * @param event or option that loads file which triggers this method
 * */

    @FXML
    void load_file(ActionEvent event) {
        Reader reader = new Reader();
        FileChooser fc = new FileChooser();
        fc.setTitle("Load a file");
        fc.setInitialDirectory(new File("."));
        fc.setInitialFileName("test.txt");
        File file = fc.showOpenDialog(new Stage());

        if (file != null) {
            try {
                Reader.loadWorld(file);
                world = Reader.loadWorld(file);

                if (world != null) {
                    grid_display.setText(world.worldString());
                    status_display.setText("Successfully Loaded file: " + file.getName());
                } else {
                    status_display.setText("Failed to load world from file.");
                }
            } catch (Exception e) {
                status_display.setText("Failed to load file: " + e.getMessage());
            }
        } else {
            status_display.setText("File loading was cancelled.");
        }
    }
    /**
     * Closes the application.
     *
     * @param event The event that triggered the method call.
     */
    @FXML
    void quit(ActionEvent event) {
        Platform.exit();

    }

    /**
     * Places a monster entity on the game world based on user input.
     * Retrieves details such as row, column, health, symbol, and weapon type from the user interface,
     * validates them, and then adds a new Monster entity to the game world at the specified location.
     * Displays an error message if the input is invalid or out of bounds.
     *
     * @param event The action event triggered by the user interaction.
     */
    @FXML
    void place_mons_entity(ActionEvent event) {
        try {
            int monsRow = Integer.parseInt(mons_row.getText());
            int monsCol = Integer.parseInt(mons_col.getText());
            // Additional validation can be added here to check if the row and column are within the bounds
            int monsHealth = Integer.parseInt(mons_health.getText());
            char monSymbol = mons_symbol.getCharacters().charAt(0);
            char choiceboxWeaponTypeSelection = mons_weaponType.getValue().charAt(0);

            if (monsRow >= world.getRows() || monsCol >= world.getColumns()) {
                status_display.setText("Error: Deletion position out of bounds.");
                return;
            }


            world.addEntity(monsRow, monsCol, new Monster(monsHealth, monSymbol, WeaponType.getWeaponType(choiceboxWeaponTypeSelection)));
            ;
            grid_display.setText(world.worldString());
            status_display.setText("Added a monster entity at " + monsRow + "," + monsCol);
        } catch (NumberFormatException e) {
            status_display.setText("Error: Monster entity details must be valid integers.");
        } catch (IllegalArgumentException e) {
            status_display.setText("Error: " + e.getMessage());
        }
    }

    /**
     * Places a hero entity on the game world based on user input.
     * Retrieves details such as row, column, health, symbol, weapon strength, and armor strength
     * from the user interface, validates them, and then adds a new Hero entity to the game world
     * at the specified location. Displays an error message if the input is invalid or out of bounds.
     *
     * @param event The action event triggered by the user interaction.
     */
    @FXML
    void place_hero_entity(ActionEvent event) {
        try {
            int heroRow = Integer.parseInt(hero_row.getText());
            int heroCol = Integer.parseInt(hero_col.getText());
            int heroHealth = Integer.parseInt(hero_health.getText());
            int heroWeaponStrength = Integer.parseInt(hero_weaponStrength.getText());
            int heroArmorStrength = Integer.parseInt(hero_armorStrength.getText());
            char heroSymbol = hero_symbol.getCharacters().charAt(0);
            if (heroRow >= world.getRows() || heroCol >= world.getColumns()) {
                status_display.setText("Error: Deletion position out of bounds.");
                return;
            }

            world.addEntity(heroRow, heroCol, new Hero(heroHealth, heroSymbol, heroWeaponStrength, heroArmorStrength));
            grid_display.setText(world.worldString());
            status_display.setText("Added a Hero entity");
        } catch (NumberFormatException e) {
            status_display.setText("Error: Hero entity details must be valid integers.");
        } catch (IllegalArgumentException e) {
            status_display.setText("Error: " + e.getMessage());
        }
    }
/**
 * Saves the user's entities and contruction of the world in the structured order the program follows into a file
 *
 * @param event the button called Save file that saves the information into a file and triggers this method to rum
 * */
    @FXML
    void save_file(ActionEvent event) {{
            FileChooser fc = new FileChooser();
            fc.setTitle("Save World to file");
            fc.setInitialDirectory(new File("."));
            fc.setInitialFileName("world.txt");
            File file = fc.showSaveDialog(new Stage());

            if (file != null) {
                try {
                    Writer.saveWorld(world, file);
                    status_display.setText("World saved successfully to file: " + file.getName());
                } catch (IOException e) {
                    status_display.setText("Failed to save world: " + e.getMessage());
                }
            } else {
                status_display.setText("World saving was cancelled.");
            }
        }

    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mons_weaponType.getItems().addAll(weapons);
        mons_weaponType.setOnAction(this::place_mons_entity);

    }
/**
 * Deletes the entity at the specified row and col that the user mentions
 * @param event the delete button that triggers this method adn deletes the entity at specified row and col.
 * */
    @FXML
    void delete_entity(ActionEvent event) {
        try {
            int deletionRow = Integer.parseInt(deletion_row.getText());
            int deletionCol = Integer.parseInt(deletion_Col.getText());
            if (deletionRow >= world.getRows() || deletionCol >= world.getColumns()) {
                status_display.setText("Error: Deletion position out of bounds.");
                return;
            }
            world.addEntity(deletionRow, deletionCol, null);
            grid_display.setText(world.worldString());
            status_display.setText("Deleted entity at position: " + deletionRow + "," + deletionCol);
        } catch (NumberFormatException e) {
            status_display.setText("Error: Row and column numbers must be valid integers.");
        } catch (IllegalArgumentException e) {
            status_display.setText("Error: " + e.getMessage());
        }
    }
}
