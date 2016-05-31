// Shawn Stern, CSE 142, Section BG, October 21 2010
//
// This program prompts the user for the current date and the date of their birthday.
// The program then returns the number of days remaining until their next birthday, 
// along with a fun fact!

import java.util.*;

public class Birthday {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
	
		programIntro();
	
		int dateNow = promptUser(s, "today's date");
		int dateBirthday = promptUser(s, "your birthday");
	
		daysLeft(dateNow, dateBirthday);
		
		funFact();
	}
	
	// Introduces the program and its function to the user
	public static void programIntro() {
		System.out.println("This program tells you how many days");
		System.out.println("it will be until your next birthday.");
		System.out.println();
	}
	
	// Prompts the user for a date (current day or birthday).  This method is passed the scanner,
	// so that it can read user input, in addition to a string that determines what the prompt is
	// asking the user for.
	public static int promptUser(Scanner s, String request) {
		System.out.println("Please enter " + request + ":");
		System.out.print("What is the month (1-12)? ");
		int month = s.nextInt();
		System.out.printf("What is the day   (1-%d)? ", daysInMonth(month));
		int day = s.nextInt();
		
		System.out.printf("%d/%d is day #%d of 365.\n", month, day, absoluteDay(month, day));
		System.out.println();
		
		return absoluteDay(month, day);
	} 

	//Determines how many days are in the month that is passed to it.
	public static int daysInMonth(int month) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else if (month == 2) {
			return 28;
		} else {
			return 31;
		}
	} 
	
	// Determines the 'absolute day' of the month and day that are passed to it
	public static int absoluteDay(int month, int day) {
		int absDay = 0;
		
		for (int i = 1; i < month; i++) {
			absDay += daysInMonth(i);
		}
		
		absDay += day;
		return absDay;
	}	
	
	// Determines the number of days left before the user's next birthday!
	// If the birthday is the same day or the next day, the user is congratulated accordingly.
	// Sadly, there is no cake. :( 
	//
	// This method is passed the current date and the birthdate, which are the numbers needed
	// to do the calculation of how many days are left till the birthday...
	public static void daysLeft(int today, int birthday) {
		int difference = birthday - today;
		
		// This handles the case where the user's next birthday is in the following year
		if (difference < 0) {
			difference = 365 - today + birthday;
		}
		
		if (difference == 0) {
			System.out.println("Happy birthday!");
		} else if (difference == 1) {
			System.out.println("Wow, your birthday is tomorrow!");
		} else {
			System.out.println("Your next birthday is in " + difference + " days.");
		}
		System.out.println();
	}
	
	// Random fact related to my own birthday
	public static void funFact() {
		System.out.println("Did you know March 19, 1918 the U.S. Congress established the time zones");
		System.out.println("and daylight saving time?  This is also known as the Standard Time Act.");
	}
}