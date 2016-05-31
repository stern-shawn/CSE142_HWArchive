// Shawn Stern, CSE 142, Section BG, November 20 2010
//
// This program prompts the user for a valid file (.txt extension) filled with nucleutide
// sequences, and produces an output file describing pertinent information like:
// the name of the sequence, number of each unique nucleotide it contains, mass percentages,
// a list of each individual codon, and whether or not the sequence encodes a protein.
// This will continue for any number of name-protein pairs until all have been processed.
//
// Note that there are no special means for handling if the user enters an invalid file.

import java.util.*;
import java.io.*;

public class DNA {
   public static final int MIN_CODONS = 5;  // Minimum # of codons
   public static final double MIN_CG_PERCENTAGE = 30.0; // Minimum mass % of C and G
   public static final int NUM_NUCLEOTIDES = 4; // # of nucleotides (A, C, G, T)
   public static final int CODON_LENGTH = 3; // # of nucleotides per codon (eg. ATG, GAC, ...)
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner s = new Scanner(System.in); // Scanner for managing ONLY user input
      intro();
      makeOutput(s, grabFile(s));
   }
   
   // Introduces the program and its functionality.
   public static void intro(){
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences that may encode proteins.");
      System.out.println();
   }
   
   // Prompts user for a valid filename and makes a scanner for that file.
   public static Scanner grabFile(Scanner s) throws FileNotFoundException {
      System.out.print("Input file name? ");
      File dna = new File(s.nextLine());
      Scanner input = new Scanner(dna);
      
      return input;
   }
   
   // Breaks down the input file, and prints the results to a new file named by the user
   public static void makeOutput(Scanner s, Scanner main) throws FileNotFoundException {
      System.out.print("Output file name? ");
      PrintStream output = new PrintStream(new File(s.nextLine()));
      
      while (main.hasNextLine()) {
         String name = main.nextLine();
         output.println("Name: " + name);
         
         String dna = main.nextLine();
         dna = dna.toUpperCase();
         int numCodons = dna.length() / CODON_LENGTH; // Declare here to avoid redundancy
         output.println("Nucleotides: " + dna);
         
         int[] count = countNucleotides(dna);
         output.println("Nucleotide counts: " + Arrays.toString(count));
         
         double[] percents = massPercent(count);
         output.println("Mass percentages: " + Arrays.toString(percents));
         
         String[] codons = codonsToArray(dna, numCodons);
         output.println("Codons: " + Arrays.toString(codons));
         
         boolean protein = isProtein(codons, percents, numCodons);
         output.print("Encodes a protein: ");
         if (protein) {
            output.println("yes");
         } else {
            output.println("no");
         }
         output.println();
      }
   }
   
   // Creates an array that counts the number of A, C, G, and T in the sequence
   public static int[] countNucleotides(String dna) {
      int[] count = new int[NUM_NUCLEOTIDES];
      
      for (int i = 0; i < dna.length(); i++) {
         char c = dna.charAt(i);
         int n = "ACGT".indexOf(c);
         if (n != -1) {
            count[n]++;
         }
      }
      
      return count;
   }
   
   // Calculates the perecentage mass of A, C, G, and T in the sequence, respectively
   public static double[] massPercent(int[] count) {
      double[] percentages = new double[NUM_NUCLEOTIDES];
      double[] acgtMasses = {135.128, 111.103, 151.128, 125.107};
      double totalMass = 0;
      
      // Calculate the mass of all ACGT, store
      for (int i = 0; i < count.length; i++) {
         percentages[i] = count[i] * acgtMasses[i];
         totalMass += percentages[i];
      }
      
      // Now that we have the total mass, we can figure out the percentages!
      for (int i = 0; i < count.length; i++) {
         percentages[i] = Math.round(percentages[i] / totalMass * 100 * 10.0) / 10.0;
      }
      
      return percentages;
   }
   
   // Converts the nucleotide string into an array of codons (3 letters per codon)
   public static String[] codonsToArray(String dna, int numCodons) {
      String[] codons = new String[numCodons];
      
      for (int i = 0; i < numCodons; i++) {
         codons[i] = dna.substring(i * CODON_LENGTH, i * CODON_LENGTH + CODON_LENGTH);
      }
      
      return codons;
   }
   
   // Tests if the sequence encodes a valid protein
   public static boolean isProtein(String[] codons, double[] percent, int numCodons) {
      double cgPercent = percent[1] + percent[2];
		String startCodon = codons[0];
		String endCodon = codons[codons.length - 1]; // This keeps the boolean 'end' under 100
      
      // To make our if statement a bit more succinct
      boolean percentValid = cgPercent >= MIN_CG_PERCENTAGE;
      boolean start = startCodon.equals("ATG");
      boolean end = endCodon.equals("TAA") || endCodon.equals("TAG") || endCodon.equals("TGA");
      boolean minCodons = numCodons >= MIN_CODONS;
      
      if (percentValid && start && end && minCodons) {
         return true;
      } else {
         return false;
      }
   }
}