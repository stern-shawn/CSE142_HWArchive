import java.io.*;	//for file
import java.util.*;	//for Scanner

public class JamesMadLibs
{
    
    //main method allows use of console
    //calls the other methods and runs the program.
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner console = new Scanner(System.in);
        
        startingMessage();
        
        boolean keepRunning = true;
        while(keepRunning)
        {
            String response = options(console);
            
            if(response.equals("c"))
            {
                newMadLib(console, openFile(console));
            }
            else if(response.equals("v"))
            {
                viewMadLib(console, openFile(console));
            }
            else if(response.equals("q"))
            {
                keepRunning = false;
            }
        }
    }
    
    //method checks if the file exists and keeps prompting until a file is found.
    //returns a scanner for the found file.
    public static Scanner openFile(Scanner console) throws FileNotFoundException
    {
        System.out.print("Input file name: ");
        File file = new File(console.nextLine());
        
        while (!file.exists())
        {
            System.out.print("File not found. Try again: ");
            file = new File(console.nextLine());
        }
        Scanner input = new Scanner(file);
        return input;
    }
    
    //method displays the starting message to the program.
    public static void startingMessage()
    {
        System.out.println("Welcome to the game of Mad Libs.");
        System.out.println("I will ask you to provide several words");
        System.out.println("and phrases to fill in a mad lib story.");
        System.out.println("The result will be written to an output file.");
        System.out.println();
    }
    
    //method asks if the user wants to create/view mad-lib or quit program.
    //returns the users decision.
    public static String options(Scanner console)
    {
        System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
        String response = console.nextLine().toLowerCase();
        return response;
    }
    
    //method takes in the users input and creates the mad-lib
    //mad-lib is created in a text file.
    public static void newMadLib(Scanner console, Scanner input)throws FileNotFoundException
    {
        System.out.print("Output file name: ");
        PrintStream output = new PrintStream(new File(console.nextLine()));
        System.out.println();
        
        while (input.hasNextLine())	//process line
        {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            
            while(lineScan.hasNext())	//process words
            {
                String word = lineScan.next();
                
                if(word.startsWith("<") && word.endsWith(">"))
                {
                    word = word.replace("<", "");
                    word = word.replace(">", "");
                    word = word.replace("-", " ");
                    word = word.toLowerCase();
                    
                    String vowel = "aeiou";
                    
                    if(vowel.contains(word.substring(0,1)))
                    {
                        System.out.print("Please type an " + word + ": ");
                    }
                    else
                    {
                        System.out.print("Please type a " + word + ": ");
                    }
                    
                    word = console.nextLine();
                }
                output.print(word + " ");
            }
            output.println();
        }
        System.out.println("Your mad-lib story has been created!");
        System.out.println();
    }
    
    //method prints mad-libs onto the console from the text file.
    public static void viewMadLib(Scanner console, Scanner input)
    {
        System.out.println();
        
        while(input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        
        System.out.println();
    }
    
}