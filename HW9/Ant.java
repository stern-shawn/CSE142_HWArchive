// Shawn Stern, CSE 142 BG, December 2 2010
//
// This class represents an ant critter.  The details of how it behaves are
// covered in the method comments.

import java.awt.*; // For color

public class Ant extends Critter {
	private boolean walkSouth; 	// Allows CritterMain to set the ant to a North/South zigzag pattern
	private int moves;  				// Stores the movement of the ant
	
	// Initialize the Ant with a passed value of walkSouth and set moves to 0
	public Ant(boolean walkSouth) {
		this.walkSouth = walkSouth;
	}
	
	// Ant always eats when it encounters food
	public boolean eat() {
		return true;
	}
	
	// Move in a southward zigzag if walkSouth is true; otherwise do a northward zigzag
	public Direction getMove() {
		// If the ant has moved twice (North/South and East, once each), reset moves
		if (moves == 2) {
			moves = 0;
		}
		
		moves++;	// I factored this out of the if statements

		if (walkSouth && moves == 1) {
			return Direction.SOUTH;
		} else if (moves == 1) {
			return Direction.NORTH;
		} else {
			return Direction.EAST;
		}
	}
	
	// Ant always uses the Scratch attack
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
	
	// Ants are red
	public Color getColor() {
		return Color.RED;
	}
	
	// Ants are represnted by a "%" sign
	public String toString() {
		return "%";
	}
}
