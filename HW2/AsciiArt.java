// Shawn Stern, CSE 142 Section BG, October 7 2010
//
// Prints my glorious ASCII Art!

public class AsciiArt {
   public static void main(String[] args) {
      border();
      content();
      border();
   }
   
   //Makes a decent looking border
   public static void border() {
      for (int i = 1; i <= 18;i++) {
         System.out.print("\"");
      }
      
      System.out.println();
   }
   
   //Prints art rivaling that of Picasso
   public static void content() {
      System.out.print("|");
      System.out.print("   \\        /");
      System.out.println("   |");
      System.out.print("|");
      System.out.print("    \\  /\\  /");
      System.out.println("    |");
      System.out.print("|");
      System.out.print("     \\/  \\/");
      System.out.println("     |");
      System.out.print("|");
      System.out.print("      Yay~~     ");
      System.out.println("|");
   }
}
