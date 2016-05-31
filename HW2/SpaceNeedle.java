// Shawn Stern, CSE 142 Section BG, October 8, 2010
//
// This program uses a combination of static methods, for loops, and a constant value to
// render an ASCII version of the Space Needle.  The constant can be any number greater
// than or equal to 2, and affects the size of the printed Space Needle.

public class SpaceNeedle {
   
   //Size constant for Space Needle, default is 4, must be 2 or greater
   public static final int SIZE = 10;
   
   public static void main(String[] args) {
      centralSpire();
      needleCapTop();
      dividerLine();
      needleCapBottom();
      centralSpire();
      needleCoreStructure();
      needleCapTop();
      dividerLine();
   }
   
   // Prints the series of '||', used on top and between top/core of Space Needle.
   // The height of this object is 3 times the constant
   public static void centralSpire() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= SIZE * 3; j++) {
            System.out.print(" ");
         }
         
         System.out.println("||");
      }
   }
   
   // Prints the shape used to represent the top and base of the Space Needle.
   // The height of this object is equal to the constant
   public static void needleCapTop() {
      for (int i = 1; i <= SIZE;i++) {
         for (int j = (SIZE - i) * 3; j >= 1; j--) {
            System.out.print(" ");
         }
         
         System.out.print("__/");
         
         //Pattern of ::: starts at 0 and increases by 1 for each layer
         for (int k = 1; k <= i - 1 ; k++) {
            System.out.print(":::");
         }
         
         System.out.print("||");
         
         for (int l = 1; l <= i - 1; l++) {
            System.out.print(":::");
         }
         
         System.out.println("\\__");
      }
   }
   
   // Prints the line between the top/bottom half of the cap, and makes the base of the Needle.
   // Simple pattern where number of "s is 6 times the constant
   public static void dividerLine() {
      System.out.print("|");
      
      for (int i = 6 * SIZE; i >= 1; i--) {
         System.out.print("\"");
      }
      
      System.out.println("|");
   }
   
   //Prints the bottom half of the Space Needle's 'cap'
   public static void needleCapBottom() {
      for (int i = 1; i <= SIZE; i++) {
         for (int j = 1; j <= 2 * i - 2; j++) {
            System.out.print(" ");
         }
         
         System.out.print("\\_");
         
         //In the case of SIZE = 4, 11 '/\' are printed, and 2 less per each line
         for (int k = SIZE * 3 - (2 * i) + 1; k >= 1; k--) {
            System.out.print("/\\");
         }
         
         System.out.println("_/");
      }
   }
   
   //Prints the central 'tower' part of the Needle, with height = SIZE^2
   public static void needleCoreStructure() {
      for (int i = 1; i <= (SIZE * SIZE); i++) {
         
         //Simple pattern for the number of spaces before the core is drawn
         for (int j = SIZE * 2 + 1; j >= 1; j--) {
            System.out.print(" ");
         }
         
         System.out.print("|");
         
         //Number of %s which make up the core is 2 less than the constant
         for (int k = SIZE - 2; k >= 1; k--) {
            System.out.print("%");
         }
         
         System.out.print("||");
         
         for (int k = SIZE - 2; k >= 1; k--) {
            System.out.print("%");
         }
         
         System.out.println("|");
      }
   }
}