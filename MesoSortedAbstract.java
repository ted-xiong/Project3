import java.util.HashMap;
import java.util.Map;
/**
 * Abstract class for MesoLexicographical class
 * 
 * @author Ted xiong
 * @version 3.0
 *
 */
public abstract class MesoSortedAbstract
{
	/**
	 * Sorts the given HashMap
	 * 
	 * @param unsorted	The HashMap to be sorted
	 * 
	 * @return Returns a sorted map
	 */
	abstract Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted);
}
