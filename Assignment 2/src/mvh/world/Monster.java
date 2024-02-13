package mvh.world;

import mvh.enums.*;

/**
 * A Monster is an Entity with a set ARMOR STRENGTH and a user provided WEAPON TYPE
 * @author Jonathan Hudson, Hamza Siddiqui hamza.siddiqui@ucalgary.ca TUT02 10/30/2023
 * @version 1.1a
 */
public final class Monster extends Entity {

    /**
     * The set armor strength of a Monster
     */
    private static final int MONSTER_ARMOR_STRENGTH = 2;

    /**
     * The user provided weapon type
     */
    private final WeaponType weaponType;

    /**
     * A Monster has regular health and symbol as well as a weapon type
     *
     * @param health     Health of Monster
     * @param symbol     Symbol for map to show Monster
     * @param weaponType The weapon type of the Monster
     */
    public Monster(int health, char symbol, WeaponType weaponType) {
        super(symbol, health);
        this.weaponType = weaponType;
    }

    /**
     * Gets Monster's weapon type
     * @return The Monster's weapon type
     */
    public WeaponType getWeaponType(){
        return this.weaponType;
    }

    /**
     * The weapon strength of monster is from their weapon type
     * @return The weapon strength of monster is from their weapon type
     */
    @Override
    public int weaponStrength() {
        return weaponType.getWeaponStrength();
    }

    /**
     * The armor strength of monster is from the stored constant
     * @return The armor strength of monster is from the stored constant
     */
    @Override
    public int armorStrength() {
        return MONSTER_ARMOR_STRENGTH;
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
    public String toString() {
        return super.toString() + "\t" + weaponType;
    }


    /**
     * Gets the Direction of where Monster should move when Hero is Alive in the local 5x5 table.
     * Monster will try to move towards the Alive Hero
     * If no ALIVE Hero is found, the Monster will attempt to move in the SOUTHEAST direction.
     * If the SOUTHEAST direction is not feasible, the Monster will choose a random direction.
     * If no valid move is found, the Monster will stay in its current position.
     *
     * @param local which is the local 5x5 worldview
     * @return the direction where Hero should move
     * */
    @Override
    public Direction chooseMove(World local) {
        // Iterate through each cell in the world grid.
        for(int bigRows = local.getRows() - 1; bigRows >= 0; bigRows--) {
            for (int bigCols = local.getColumns() - 1; bigCols >= 0; bigCols--) {
                Entity entity = local.getEntity(bigRows, bigCols);
                // Check if the current entity is an ALIVE Hero.

                if(entity instanceof Hero && entity.isAlive()) {
                    // Adjust the row and column indices relative to the Monster's position.

                    int rowAdjustment = bigRows - 2;
                    int colAdjustment = bigCols - 2;
                    // Get all possible directions the Hero can move towards the Hero.

                    Direction[] possibleDirections = Direction.getDirections(rowAdjustment, colAdjustment);
                    for(Direction feasibleDirection: possibleDirections) {
                        // Calculate the feasible row and column indices for the Monsters's move.

                        int feasibleRow = 2 + feasibleDirection.getRowChange();
                        int feasibleCol = 2 + feasibleDirection.getColumnChange();
                        if (local.canMoveOnTopOf(feasibleRow, feasibleCol)) {
                            return feasibleDirection;
                        }
                    }
                }
            }
        }

        // If no ALIVE Hero found, move SOUTHEAST or try a random direction.
        if(local.canMoveOnTopOf(-1,-1)) {
            return Direction.SOUTHEAST;
        } else {
            Direction randomDirection = Direction.getRandomDirection();
            int randomRow = 2 + randomDirection.getRowChange();
            int randomCol = 2 + randomDirection.getColumnChange();
            if(local.canMoveOnTopOf(randomRow, randomCol)) {
                return randomDirection;
            }
        }

        return Direction.STAY;  // Default fallback
    }
    /**
     * Determines where Monster should attack based on the 3x3 worldview
     * The Monster will attempt to attack the first ALIVE Monster it sees in the grid.
     * If no ALIVE Hero is found, the method will return null, indicating no attack direction.
     *
     * @param local 3x3 worldview around the current Monster position
     * @return The direction in which the Monster should attack, or null if no valid attack direction is found.
     * */
    @Override
    public Direction attackWhere(World local) {

        for (int smallRows = local.getRows()-1; smallRows >= 0; smallRows--) {
            for (int smallCols = local.getColumns()-1; smallCols >= 0; smallCols--) {
                //if within the local worldview it sees a monster, amd it is alive, it will get its direction
                if(local.getEntity(smallRows,smallCols) instanceof Hero && local.getEntity(smallRows,smallCols).isAlive()){
                    int rowAdjustment = smallRows - 1;
                    int colAdjustment = smallCols - 1;
                    return Direction.getDirection(rowAdjustment,colAdjustment);
                }
            }
        }

        // If no ALIVE hero is found, return null
        return null;
    }
}
