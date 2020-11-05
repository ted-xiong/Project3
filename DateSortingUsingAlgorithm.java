import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Sorts a HashMap in ascending and descending order
 * 
 * @author Ted Xiong
 * @version 3.0
 *
 */
public class DateSortingUsingAlgorithm 
{
	
	private final String file = "SortingDates.txt";
	private HashMap <LocalDate, Integer> dates;
	
	/**
	 * Constructs a DateSortingUsingAlgorithm object
	 * 
	 * @throws IOException if the input and output does not match
	 */
	public DateSortingUsingAlgorithm() throws IOException
	{
		this.dates = new HashMap<LocalDate, Integer>();
		storeInMap();
	}
	
	/**
	 * Sorts the HashMap in the field in descending order
	 * 
	 */
	public void dateHashMapSortedDescending() 
	{
		ArrayList<LocalDate> listOfDates = new ArrayList<LocalDate>(dates.keySet());
		Collections.sort(listOfDates);
		Collections.reverse(listOfDates);
		
		for (LocalDate date : listOfDates)
		{
			System.out.println(date);
		}
	}

	/**
	 * Sorts the HashMap in the field in ascending order
	 * 
	 */
	public void dateHashMapSorted() 
	{
		ArrayList<LocalDate> listOfDates = new ArrayList<LocalDate>(dates.keySet());
		Collections.sort(listOfDates);
		
		
		for (LocalDate date : listOfDates)
		{
			System.out.println(date);
		}
		
	}
	
	/**
	 * Converts the Strings in the given file to LocalDate objects, and 
	 * stores them in the HashMap field
	 * 
	 * @throws IOException if the input and output does not match
	 */
	private void storeInMap() throws IOException 
	{
		Scanner readFile = new Scanner (new FileReader (file));
		
		int count = 1;
		
		while (readFile.hasNext())
		{
			String dateString = readFile.nextLine().trim();
			
			String[] parts = dateString.split("-");
			
			int year = Integer.parseInt(parts[0].trim());
			int month = Integer.parseInt(parts[1].trim());
			int day = Integer.parseInt(parts[2].trim());
			
			LocalDate localDate = LocalDate.of(year, month, day);
			
			dates.put(localDate, count);
			
			count++;
		}
		
		readFile.close();
	}

}
