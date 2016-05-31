// Shawn Stern, CSE 142 BG, December 2 2010
//
// This class represents a bird critter.  A bird never eats, which is the default behavior,
// so there is no special eat method for Bird.  The other details of how it behaves are
// covered in detail in the method comments.  A constructor is not needed, as moves are 
// initially 0, and the default constructor sets it to 0 anyway.

import java.awt.*; // For color

public class Bird extends Critter {
	private int moves;  // Stores how many times the bird has moved
		
	// Move in a circle; repeating north, east, south, then west 3 times each
	public Direction getMove() {
		// If the bird has moved in a full circle, reset moves
		if (moves == 12) {
			moves = 0;
		}
		
		moves++;
		
		if (moves <= 3) {
			return Direction.NORTH;
		} else if (moves <= 6) {
			return Direction.EAST;
		} else if (moves <= 9) {
			return Direction.SOUTH;
		} else {
			return Direction.WEST;
		}
	}
	
	// Roars if an oppoenent is a "%", otherwise it always pounces
	public Attack fight(String opponent) {
		if (opponent.equals("%")) {
			return Attack.ROAR;
		} else {
			return Attack.POUNCE;
		}
	}
	
	// Birds are blue
	public Color getColor() {
		return Color.BLUE;
	}
	
	// Birds are represented by a varying v-shape dependent on what direction it is moving
	public String toString() {
		if (moves <= 3) {
			return "^"; // If going north
		} else if (moves <= 6) {
			return ">"; // If going east
		} else if (moves <= 9) {
			return "V"; // If going south
		} else {
			return "<"; // If going west
		}
	}
}