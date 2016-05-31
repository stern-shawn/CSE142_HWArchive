// Shawn Stern, CSE 142 BG, December 1 2010
//
// This object represents a particular date.  It has a number of useful methods for returning
// parts of a date (as ints or a string), reassigning the value of the date, and incrementing
// the value of the date.  This can be used in any client program that manipulates dates, not
// just our Birthday.java program!
// I also used the word 'this' alot.  Woooo!

public class Date {
   private int month;
   private int day;
   
   // Initializes the (this?  jk) fields based on user input
   public Date(int month, int day) {
      this.month = month;
      this.day = day;
   }
   
   // Returns this month
   public int getMonth() {
      return month;
   }
   
   // Returns this day
   public int getDay() {
      return day;
   }
   
   // Allows the user to set this date to a different date without incrementing
   public void setDate(int month, int day) {
      this.month = month;
      this.day = day;
   }
   
   // Returns a string form of this date in the usual "month/day" format
   // (instead of the more common "day/month".  Silly Americans being rebellious!)
   public String toString() {
      String date = month + "/" + day;
      return date;
   }
   
   // Checks if this date is equal to another Date
   public boolean equals(Date d) {
      if (month == d.getMonth() && day == d.getDay()) {
         return true;
      } else {
         return false;
      }
   }
   
   // Returns the number of days in this month
   public int daysInMonth() {
      if (month == 4 || month == 6 || month == 9 || month == 11) {
         return 30;
      } else if (month == 2) {
         return 28;
      } else {
         return 31;
      }
   }
   
   // Increments this date to the next day, with considerations for when this
   // day is the end of a month or the end of the year
   public void nextDay() {
      int daysMax = daysInMonth();
      
      if (day == daysMax && month == 12) { // If end of the year, set date to Jan 1
         setDate(1, 1);
      } else if (day == daysMax) { // If last day of month, set to first day of next month
         setDate(month + 1, 1);
      } else { // Otherwise, simply increment this day
         day++;
      }
   }
}