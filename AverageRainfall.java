import java.util.Scanner;  // Needed for keyboard input

/**
 * Laura Davis CIS 260 903
 * This program demonstrates a solution to the
 * Average Rainfall programming challenge.
*/

public class AverageRainfall
{
   public static void main(String[] args)
   {
      final int NUM_MONTHS = 12; // Months per year
      int years;                 // Number of years
      double monthRain;          // Rain for a month
      double totalRain = 0;      // Rainfall accumulator
      double average;            // Average rainfall

      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the number of years.
      System.out.print("Enter the number of years: ");
      years = keyboard.nextInt();
      
      // Validate the input.
      while (years < 1)
      {
    	 years = invalidYears(keyboard);

      }
      
      //gets totalRain from user input in a method
      totalRain = accRain(NUM_MONTHS, years);
      
      // Calculate the average rainfall in a method
      average = avgRain(totalRain, years, NUM_MONTHS);
       
      // Display the statistics from a method.
      displayResults(years, NUM_MONTHS, totalRain, average);
      
   }//end of main
   
   /**
    * The accRain method accumulates the rain based on user input
    * 
    * @param NUM_MONTHS Final months = 12
    * @param years Number of years as input by the user
    * @return Returns the total accumulated rain
    */
   public static double accRain(int NUM_MONTHS, int years)
   {
	   //delcare variables
	   double monthRain;
	   double total = 0;
	   
	      // Create a Scanner object for keyboard input.
	      Scanner keyboard = new Scanner(System.in);
	   
	      System.out.println("Enter the rainfall, in inches, " +
                  "for each month.");

	      for (int y = 1; y <= years; y++)
	      {
	    	  for (int m = 1; m <= NUM_MONTHS; m++)
	    	  {
	    		  // Get the rainfall for a month.
	    		  System.out.print("Year " + y + " month " + m + ": ");
	    		  monthRain = keyboard.nextDouble();
     
	     // Validate the input.
	     while (monthRain < 0)
	     {
	    	monthRain = invalidRain(keyboard);
	     }
	     
	     // Accumulate the rainfall.
	     total += monthRain;
	     
	    	  }
	      }
	      return total;
   }// end of accRain
   
   /**
    * Validation method for inches of rain
    * 
    * @param keyboard Method is passed the scanner object
    * @return
    */
   public static double invalidRain(Scanner keyboard)
   {
	   double monthRain;
	   System.out.print("Invalid. Enter 0 or greater: ");
       monthRain = keyboard.nextDouble();
       return monthRain;
	   
   }//end of invalid rain
   
   /**
    * The avgRain method calculates the average amount of rainfall in inches.
    * It is passed totalRain, years, and NUM_MONTHS, and it returns the average.
    * 
    * @param totalRain total inches of rain from user input
    * @param years total number of years entered by user
    * @param NUM_MONTHS final variable. NUM_MONTHS = 12 months
    * @return returns avg and puts it in the average variable.
    */
   public static double avgRain(double totalRain, int years, int NUM_MONTHS)
   {
	   double avg;
	   
	   avg = totalRain / (years * NUM_MONTHS);
	   
	   return avg;
	   
   }//end of avgRain
   
   /**
    * The displayResult method is passed variables from main and displays the results.
    * 
    * @param years Number of years entered by the user
    * @param NUM_MONTHS Final number of months = 12
    * @param totalRain Total inches of rain entered by the user
    * @param average Average inches of rainfall as calculated in avgRain method
    */
   public static void displayResults(int years, int NUM_MONTHS, double totalRain, double average)
   {
	      System.out.println("\nNumber of months: " + (years * NUM_MONTHS));
	      System.out.println("Total rainfall: " + totalRain + " inches");
	      System.out.println("Average monthly rainfall: " + average + " inches");
	      
   }// end of displayResults
   
   /**
    * Validation method for number of years
    * 
    * @param keyboard Method is passed the scanner object
    * @return
    */
   public static int invalidYears(Scanner keyboard)
   {
	   int years;
       System.out.print("Invalid. Enter 1 or greater: ");
       years = keyboard.nextInt();
       return years;
   }//end of invalidYears
    
}//end of class
