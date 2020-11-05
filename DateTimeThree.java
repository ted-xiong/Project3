import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Finds if a year is a leap year or not, and finds the difference between a given date
 * and the current date
 * 
 * @author Ted Xiong
 * @version 3.0
 */
public class DateTimeThree 
{
	private HashMap <LocalDate, Integer> dates;
	private String file = "Dates.txt";
	
	/**
	 * Constructs a HashMap containing LocalDate keys and Integer values
	 * 
	 * @throws FileNotFoundException if file is not found
	 */
	public DateTimeThree() throws FileNotFoundException
	{
		this.dates = new HashMap <LocalDate, Integer>();
		storeInMap();
	}
	
	/**
	 * Stores the dates from the file into the HashMap field
	 * 
	 * @throws FileNotFoundException if file is not found
	 */
	public void storeInMap() throws FileNotFoundException
	{
		Scanner readDate = new Scanner (new FileReader(file));
		
		Integer value = 1;
		while (readDate.hasNext())
		{	
			String [] dateInfo = readDate.nextLine().split("\\.");
			Integer month = Integer.parseInt(dateInfo[0]);
			Integer day = Integer.parseInt(dateInfo[1]);
			Integer year = Integer.parseInt(dateInfo[2]);
			
			LocalDate compareDate = LocalDate.of(year, month, day);
			dates.put(compareDate, value);
			
			value++;
		}
		
		readDate.close();
	}
	
	/**
	 * Takes all the dates stored in the HashMap field, checks to see if the year of the date
	 * is a leap year, and finds the difference between the date and the current time and prints
	 * the information in a String
	 * 
	 * @throws FileNotFoundException if file is not found
	 */
	public void compareYear() throws FileNotFoundException 
	{	
		
		LocalDate currentDate = LocalDate.now();
		
		for (LocalDate date : dates.keySet()) 
		{
			if(isLeapYear(date.getYear()))
			{
				System.out.print(date.getYear() + " is a leap year, and ");
			} else
			{
				System.out.print(date.getYear() + " is not a leap year, and ");
			}
			
			Period difference = Period.between(date, currentDate);
			System.out.println("Difference: " + difference.getYears() + " years, " + difference.getMonths() + " months, and " + difference.getDays() + " days.");		
		}

	}
	
	/**
	 * Checks to see if the year is a leap year or not
	 * 
	 * @param year	The year checked
	 * 
	 * @return Returns true if the year is a leap year, returns false if not
	 */
	public boolean isLeapYear(int year)
	{
		boolean isLeap = false;
		
		 if(year % 4 == 0)
	     {
	            if( year % 100 == 0)
	            {
	                if ( year % 400 == 0)
	                    isLeap = true;
	                else
	                    isLeap = false;
	            }
	            else
	                isLeap = true;
	        }
	        else {
	            isLeap = false;
	    }
		
		return isLeap;
	}
	/**
	 * Prints out all the dates stored in the HashMap field
	 * 
	 */
	public void dateHashMap() 
	{
		for (LocalDate date : dates.keySet())
		{
			System.out.println(date + ":" + dates.get(date));
		}		
	}
	/**
	 * Prints out all the dates stored in the HashMap field in a sorted order
	 * 
	 */
	public void dateHashMapSorted() 
	{
		ArrayList<LocalDate> sortedDates = new ArrayList <LocalDate>(dates.keySet());
		
		Collections.sort(sortedDates);
		
		for (LocalDate date : sortedDates)
		{
			System.out.println(date + ":" + dates.get(date));
		}	
	}

}
