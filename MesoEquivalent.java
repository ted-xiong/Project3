import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Finds other STIDs with the same average ASCII value as a specified STID
 * 
 * @author Ted Xiong
 * @version 3.0
 */
public class MesoEquivalent 
{
	private String STID;
	private HashMap<String, Integer> allSTIDs;
	private final String file = "Mesonet.txt";
	
	/**
	 * Constructs a MesoEqivalent object 
	 * 
	 * @param stId	The STID used for comparison
	 */
	public MesoEquivalent(String stId)
	{
		this.STID = stId;
		this.allSTIDs = new HashMap<String, Integer>();
	}
	
	/**
	 * Stores all the STIDs and their average ASCII values in the Mesonet.txt file 
	 * into the HashMap field
	 * 
	 * @throws FileNotFoundException is the file is not found
	 */
	public void storeInMap() throws FileNotFoundException
	{
		Scanner readFile = new Scanner (new FileReader(this.file));
		
		readFile.nextLine();
		
		while (readFile.hasNext())
		{
			String station = readFile.next();

			int average = new MesoAsciiCal(new MesoStation (station)).calAverage();
			allSTIDs.put(station, average);
			
			readFile.nextLine();
		}
		
		readFile.close();
	}

	/**
	 * Compares the average ASCII values of the STID in the field to the average ASCII values of 
	 * all the STIDs stored in the HashMap field
	 * 
	 * @return Returns a HashMap of all the STIDs that have the same average ASCII value as the
	 * field STID's average ASCII value
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	public HashMap<String, Integer> calAsciiEqual() throws FileNotFoundException 
	{

		storeInMap();

		HashMap<String, Integer> sameAverages = new HashMap<String, Integer>();
		
		for (String STID : allSTIDs.keySet())
		{
			if (allSTIDs.get(STID) == new MesoAsciiCal(new MesoStation (this.STID)).calAverage())
			{
				sameAverages.put(STID, allSTIDs.get(STID));
			}
		}
		return sameAverages;
	}
	
	

}
