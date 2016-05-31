// Shawn Stern, CSE 142, Section BG, November 12 2010
//
// Mad Libs!
//
// I tried a new comment style this time, with comments above code segments such as while or
// for statements, and comments on the same line as declarations of variables or objects.
// Lemmie know if you think it's an improvement!

import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      programIntro();
      
      Scanner s = new Scanner(System.in); // Scanner for managing ONLY user input
      String userChoice = "a"; // Initialize a dummy value other than q or Q
      
      // While the user doesn't want to quit, create or view mad libs!
      while (!userChoice.equalsIgnoreCase("q")) {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         userChoice = s.nextLine();
         
         if (userChoice.equalsIgnoreCase("c")) {
            makeMadLib(s, promptForFile(s));
         } else if (userChoice.equalsIgnoreCase("v")) {
            viewMadLib(promptForFile(s));
         }
      }
   }
   
   // Displys the intro text of the program
   public static void programIntro() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Prompts the user for a mad lib file until they give one that exists, and creates a
   // scanner object for that mad lib.
   public static Scanner promptForFile(Scanner s) throws FileNotFoundException {
      System.out.print("Input file name: ");
      File madLib = new File(s.nextLine());
      
      // If the user gives us an invalid file name, prompt again and see if that exists
      while (!madLib.exists()) {
         System.out.print("File not found. Try again: ");
         madLib = new File(s.nextLine());
      }
      
      Scanner input = new Scanner(madLib);
      return input;
   }
   
   // Prompts the user to name their output Mad Lib, prompts the user for the proper
   // placeholders, and saves the resulting text as a file.
   public static void makeMadLib(Scanner s, Scanner madLib) throws FileNotFoundException {
      System.out.print("Output file name: ");
      PrintStream output = new PrintStream(new File(s.nextLine()));
      System.out.println();
      
      String vowels = "aeiouAEIOU"; // Declare what the vowels are so we can test for them
      
      // Break file into lines and process each one
      while (madLib.hasNextLine()) {
         String line = madLib.nextLine();
         Scanner lineScanner = new Scanner(line);
         
         // Break lines into individual words
         while(lineScanner.hasNext()) {
            String token = lineScanner.next();
            
            // Recognizes if a token is a placeholder; modifies it accordingly
            if (token.startsWith("<") && token.endsWith(">")) {
               token = token.replace("<", "");
					token = token.replace("-", " ");
					token = token.replace(">", "");
               
               // Compares the first letter of the placeholder to our list of vowels, and
               // prints a grammatically correct prompt.  Note this is wayyy shorter than doing
					// 'if (token.startsWith("a") || token.startsWith("e") || ...)
               if(vowels.contains(token.substring(0,1))) {
                  System.out.print("Please type an " + token + ": ");
               } else {
                  System.out.print("Please type a " + token + ": ");
               }
               
               token = s.nextLine();
            }
            
            output.print(token + " ");
         }
         
         output.println();
      }
      
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   // Reads a text file and prints its contents to the console
   public static void viewMadLib(Scanner madLib) {
      System.out.println();
      
      while(madLib.hasNextLine()) {
         System.out.println(madLib.nextLine());
      }
      
      System.out.println();
   }
}