// Shawn Stern, CSE 142, Section BG, October 26 2010
//
// This program prints out a haiku introduction.  From there it prompts the user to guess
// a number between 1 and a constant value (default 100), and tells them if their guess is
// too low or too high until they correctly guess the value!  The user then has the option
// to continue playing additional rounds or quit; when they quit, they'll be presented with
// a summary of statistics about their performance (Total games, total guesses, average
// guesses per game, and the number of guesses in their best game).
// Wheeeeee!

import java.util.*;

public class GuessingGame {
   public static final int MAX_GUESS = 100;
   
   public static void main(String[] args) {
      // Create the nescessary objects
      Scanner s = new Scanner(System.in);
      Random rand = new Random();
      
      // Declare sentinel and initialize counters
      String quit = "";
      int totalGames = 0;
      int totalGuesses = 0;
		
      // There will never be more than 1 million guesses in a given game
      int bestGame = (int) Math.pow(10,6);
      
      introHaiku();
      
      // This loop makes sure that the user plays the game, and manages counter values
      // until user chooses to quit
      do {
         int gameResult = playGame(s, rand);
         youGotItRight(gameResult);
         totalGames++;
         totalGuesses += gameResult;
         
         // If the user took fewer guesses this time, change the value of their best score
         bestGame = Math.min(gameResult, bestGame);
         
         System.out.print("Do you want to play again? ");
         quit = s.next();
         System.out.println();
      } while(quit.substring(0,1).equalsIgnoreCase("y"));
      
      endResults(totalGames, totalGuesses, bestGame);
   }
   
   // Introduces the user to The Game
   public static void introHaiku() {
      System.out.println("You shall guess an int,");
      System.out.println("science will guide your journey.");
      System.out.println("There will not be cake");
      System.out.println();
   }
   
   // Gives the user a range of numbers, and will continue to promt them and give hints
   // until they guess the correct value
   public static int playGame(Scanner s, Random rand) {
      // Generates a random number 1 to MAX_GUESS, inclusive, for the user to guess
      int correctNum = rand.nextInt(MAX_GUESS) + 1;
      int userGuess = 0;
      int countGuesses = 0;
      System.out.println("I'm thinking of a number between 1 and " + MAX_GUESS + "...");
      
      while(userGuess != correctNum) {
         System.out.print("Your guess? ");
         userGuess = s.nextInt();
			
		   highOrLow(correctNum, userGuess);
			         
         countGuesses++;
      }
      
      return countGuesses;
   }
   
	// Tells the user how correct their guess, if it is wrong
	public static void highOrLow(int correct, int guess) {
	   if (guess < correct) {
         System.out.println("It's higher.");
      } else if (guess > correct) {
         System.out.println("It's lower.");
      }
	}
	
   // Tells the user how many guesses it took them to guess right, for a particular round.
   public static void youGotItRight(int result) {
      if (result == 1) {
         System.out.println("You got it right in 1 guess!");
      } else {
         System.out.println("You got it right in " + result + " guesses!");
      }
   }
   
   // Prints a summary of the user's overall performance.
   public static void endResults(int games, int guesses, int best) {
      double ratio = (double) guesses / games;
      
      System.out.println("Overall results:");
      System.out.println("Total games   = " + games);
      System.out.println("Total guesses = " + guesses);
      System.out.printf("Guesses/game  = %.1f\n", ratio);
      System.out.println("Best game     = " + best);
   }
}