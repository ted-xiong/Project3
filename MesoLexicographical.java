import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Sorts a given HashMap in lexigraphical order
 * 
 * @author Ted xiong
 * @version 3.0
 *
 */
public class MesoLexicographical extends MesoSortedAbstract
{
	private HashMap<String, Integer> sortedMap;
	
	/**
	 * Constructs a MesoLexicographical object
	 * 
	 * @param asciiVal	The HashMap to be sorted
	 */
	public MesoLexicographical(HashMap<String, Integer> asciiVal) 
	{
		this.sortedMap = asciiVal;
		sortedMap(this.sortedMap);
	}

	@Override
	/**
	 * Overrides the sortedMap method in the MesoSortedAbstract class, and sorts the given
	 * HashMap
	 * 
	 * @param unsorted	The HashMap to be sorted
	 * 
	 * @return Returns a sorted map
	 */
	Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted)
	{
		HashMap<String, Integer> sortedVersion = new HashMap<String, Integer>();
		
		ArrayList<String> listOfSTIDs = new ArrayList<String>();
		
		for (String STID : sortedMap.keySet())
		{
			listOfSTIDs.add(STID);
		}
		
		Collections.sort(listOfSTIDs);
		
		for (String STID : listOfSTIDs)
		{
			sortedVersion.put(STID, sortedMap.get(STID));
			System.out.println(STID + " " + sortedVersion.get(STID));
		}
		
		return sortedVersion;
	}

}