// Shawn Stern, CSE 142, Autumn 2010, Section BG
// Programming Assignment #1, 10/1/10
//
// This program prints out 6 verses of "The 12 Days of Christmas" and a customized 7th verse.
//	It uses a cumulative format where each successive verse is longer than the other, and these
//	added lines are repeated in each following verse.	In the latter half of the program, the 
//	redundancy is removed by making methods which successively call each other.
// For example, "a partridge in a pear tree" is part of every verse, so its method is called by
//	the next line, which is also called by the next line, and so on.
	
public class Song {
	public static void main(String[] args) {
		verse1();
		verse2();
		verse3();
		verse4();
		verse5();
		verse6();
		verse7();
	}
	
	//Prints out the first verse of the song
	public static void verse1() { 
		System.out.println("On the 1st day of \"Xmas\", my true love gave to me");
		line1(); 
	}

	//Prints the second verse of the song
	public static void verse2() { 
		System.out.println("On the 2nd day of \"Xmas\", my true love gave to me");
		line2();
	}

	//Prints the third verse of the song
	public static void verse3() { 
		System.out.println("On the 3rd day of \"Xmas\", my true love gave to me");
		line3();
	}

	//Prints the fourth verse of the song
	public static void verse4() { 
		System.out.println("On the 4th day of \"Xmas\", my true love gave to me");
		line4();
	}

	//Prints the fifth verse of the song
	public static void verse5() { 
		System.out.println("On the 5th day of \"Xmas\", my true love gave to me");
		line5();
	}

	//Prints the sixth verse of the song
	public static void verse6() { 
		System.out.println("On the 6th day of \"Xmas\", my true love gave to me");
		line6();
	}

	//Prints the seventh verse of the song
	public static void verse7() { 
		System.out.println("On the 7th day of \"Xmas\", my true love gave to me");
		line7();
	}

	//The following are methods for the repeated lines in the song

	//Prints the first repeated line of the song
	public static void line1() { 
		System.out.println("a partridge in a pear tree.");
		/* The blank space below is repeated after every verse, which creates the spacing between verses
		without the need for a bunch of println(); statements in main() */
		System.out.println(); 
	}

	//Prints the second repeated line of the song and calls all previous lines in order
	public static void line2() { 
		System.out.println("two turtle doves, and");
		line1();
	}
	
	//Prints the third repeated line of the song and calls all previous lines in order
	public static void line3() { 
		System.out.println("three French hens,");
		line2();
	}
	
	//Prints the fourth repeated line of the song and calls all previous lines in order
	public static void line4() { 
		System.out.println("four calling birds,");
		line3();
	}

	//Prints the fifth repeated line of the song and calls all previous lines in order
	public static void line5() { 
		System.out.println("five golden rings,");
		line4();
	}

	//Prints the sixth repeated line of the song and calls all previous lines in order
	public static void line6() { 
		System.out.println("six geese a-laying,");
		line5();
	}

	//Prints the seventh line of the song and calls all previous lines in order
	public static void line7() { 
		System.out.println("seven delicious twinkies,");
		line6();
	}
}