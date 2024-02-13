package mvh.world;

import mvh.enums.*;
import mvh.util.Reader;

import java.io.File;
import java.util.ArrayList;

/**
 * A Monster is an Entity with a user provide WEAPON STRENGTH and ARMOR STRENGTH
 * @author Jonathan Hudson Hamza Siddiqui hamza.siddiqui@ucalgary.ca TUT02 10/30/2023
 * @version 1.1
 */
public final class Hero extends Entity{

    /**
     * The user provided weapon strength
     */
    private final int weaponStrength;

    /**
     * The user provided armor strength
     */
    private final int armorStrength;

    /**
     * A Hero has regular health and symbol as well as a weapon strength and armor strength
     * @param health Health of hero
     * @param symbol Symbol for map to show hero
     * @param weaponStrength The weapon strength of the hero
     * @param armorStrength The armor strength of the hero
     */
    public Hero(int health, char symbol, int weaponStrength, int armorStrength) {
        super(symbol, health);
        this.weaponStrength = weaponStrength;
        this.armorStrength = armorStrength;
    }

    /**
     * The weapon strength of monster is from user value
     * @return The weapon strength of monster is from user value
     */
    @Override
    public int weaponStrength() {
        return weaponStrength;
    }

    /**
     * The armor strength of monster is from user value
     * @return The armor strength of monster is from user value
     */
    @Override
    public int armorStrength() {
        return armorStrength;
    }

    /**
     * Can only be moved on top of if dad
     * @return isDead()
     */
    @Override
    public boolean canMoveOnTopOf() {
        return isDead();
    }

    /**
     * Can only be attacked if alive
     * @return isAlive()
     */
    @Override
    public boolean canBeAttacked() {
        return isAlive();
    }

    @Override
    public String toString(){
        return super.toString()+"\t"+weaponStrength+"\t"+armorStrength;
    }

    /**
     * Gets the Direction of where Hero should move when monster is Alive in the local 5x5 table.
     * Hero will try to move towards the Alive monster
     * If no ALIVE Monster is found, the Hero will attempt to move in the NORTHWEST direction.
     * If the NORTHWEST direction is not feasible, the Hero will choose a random direction.
     * If no valid move is found, the Hero will stay in its current position.
     *
     * @param local which is the local 5x5 worldview
     * @return the direction where Hero should move
     * */
    @Override
    public Direction chooseMove(World local) {
        // Iterate through each cell in the world grid.
        for(int bigRows = 0; bigRows < local.getRows(); bigRows++) {
            for (int bigCols = 0; bigCols< local.getColumns(); bigCols++) {
                Entity entity = local.getEntity(bigRows, bigCols);
                // Check if the current entity is an ALIVE Monster.
                if(entity instanceof Monster && entity.isAlive()) {
                    // Adjust the row and column indices relative to the Hero's position.
                    int rowAdjustment = bigRows - 2;
                    int colAdjustment = bigCols - 2;

                    // Get all possible directions the Hero can move towards the Monster.
                    Direction[] possibleDirections = Direction.getDirections(rowAdjustment, colAdjustment);
                    for(Direction feasibleDirection: possibleDirections) {
                        // Calculate the feasible row and column indices for the Hero's move.
                        int feasibleRow = 2 + feasibleDirection.getRowChange();
                        int feasibleCol = 2 + feasibleDirection.getColumnChange();
                        // Check if the Hero can move to the calculated position.
                        if (local.canMoveOnTopOf(feasibleRow, feasibleCol)) {
                            return feasibleDirection;  // Return the feasible direction.
                        }
                    }
                }
            }
        }

        // If no ALIVE Monster is found in the grid.
        // Check if the Hero can move to the NORTHWEST position.
        if(local.canMoveOnTopOf(1,1)) {
            return Direction.NORTHWEST;
        } else {
            // If NORTHWEST is not feasible, choose a random direction for the Hero to move.
            Direction randomDirection = Direction.getRandomDirection();
            int randomRow = 2 + randomDirection.getRowChange();
            int randomCol = 2 + randomDirection.getColumnChange();
            // Check if the Hero can move to the randomly chosen position.
            if(local.canMoveOnTopOf(randomRow, randomCol)) {
                return randomDirection;  // Return the random direction.
            }
        }

        // If no valid move is found, the Hero stays in its current position.
        return Direction.STAY;
    }
/**
 * Determines where hero should attack based on the 3x3 worldview
 * The Hero will attempt to attack the first ALIVE Monster it sees in the grid.
 * If no ALIVE Monster is found, the method will return null, indicating no attack direction.
 *
 * @param local 3x3 worldview around the current Hero position
 * @return The direction in which the Hero should attack, or null if no valid attack direction is found.
 * */
    @Override
    public Direction attackWhere(World local) {

                for (int smallRows = 0; smallRows < local.getRows(); smallRows++) {
                    for (int smallCols = 0; smallCols < local.getColumns(); smallCols++) {
                        //if within the local worldview it sees a monster, amd it is alive, it will get its direction
                        if(local.getEntity(smallRows,smallCols) instanceof Monster && local.getEntity(smallRows,smallCols).isAlive()){
                            int rowAdjustment = smallRows - 1;
                            int colAdjustment = smallCols - 1;
                                return Direction.getDirection(rowAdjustment,colAdjustment);
                        }
            }
        }

        // If no ALIVE Monster is found, return null
        return null;
    }

}
