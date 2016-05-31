// Shawn Stern, CSE 142 BG, December 1 2010
//
// This client program accepts user input--the current day and their birthday--then returns
// how many days are in the birth month, and how many days remain until their next birthday.
// There are special conditions for when the two dates are the same or one day apart.
//
// Because of some of the calls made to the Date object, a few of the lines went over 100 chars
// long.  I remember on the forums somewhere that the style I used is correct for overcoming
// this problem, hope it's not too messy!

import java.util.*;
import java.io.*;

public class Birthday {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("What is today's date (month and day)? ");
		int month1 = s.nextInt();
		int day1 = s.nextInt();
		
		System.out.print("What is your birthday (month and day)? ");
		int month2 = s.nextInt();
		int day2 = s.nextInt();
		
		Date today = new Date(month1, day1);
		Date birthday = new Date(month2, day2);
		
		daysInBirthMonth(birthday);
		daysTillBirthday(today, birthday);		
	}
	
	public static void daysInBirthMonth(Date birthday) {
		System.out.println("There are " + birthday.daysInMonth() + " days in month #" + 
			birthday.getMonth());
	}
	
	public static void daysTillBirthday(Date today, Date birthday) {
		int daysLeft = 0;
		
		while(!today.equals(birthday)) {
			today.nextDay();
			daysLeft++;
		}
		
		if (daysLeft == 0) {
			System.out.println("Happy birthday!");
		} else {
			System.out.println("Number of days until birthday " + birthday.toString() + 
				": " + daysLeft);
		}
	}
}