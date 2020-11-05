/**
 * Calculates the average ASCII value given a String
 * 
 * @author Ted Xiong
 * @version 3.0
 *
 */
public class MesoAsciiCal extends MesoAsciiAbstract 
{
	private String stationToASCII;
	private final double compareVal = 0.25;
	
	/**
	 * Constructs a MesoAsciiCal object
	 * 
	 * @param mesoStation	The String used to find the average value between itself and NRMN
	 */
	public MesoAsciiCal(MesoStation mesoStation) 
	{
		this.stationToASCII = mesoStation.getStID();
	}

	@Override
	/**
	 * Finds the average of NRMN's ASCII value with the STID in the field
	 */
	int calAverage() 
	{
		int average1 = (int) calculateAverage(this.stationToASCII);
		int average2 = (int) calculateAverage("NRMN");
		
		double totalAverage = (average1 + average2)/2.0;
		double fractional = totalAverage - (int) totalAverage;
		
		if (fractional < compareVal)
		{
			totalAverage = Math.floor(totalAverage);
		} else
		{
			totalAverage = Math.ceil(totalAverage);
		}
		
		return (int) totalAverage;
	}
	
	/**
	 * Takes a String and calculates the average ASCII value of that String
	 * 
	 * @param STID	The String for whose ASCII value is found
	 * 
	 * @return Returns the ASCII value in a double data type
	 */
	public double calculateAverage(String STID)
	{
		char[] arrayOfChar = STID.toCharArray();
		double floor = 0;
		double ceiling = 0;
		int sum = 0;
		double average = 0;
		
		for (int i = 0; i < arrayOfChar.length; i++)
		{
			sum = sum + (int)arrayOfChar[i];
		}
		
		average = sum / 4.0;
		floor = Math.floor(average);
		ceiling = Math.ceil(average);
		
		int integer = (int) average;
		double fractional = average - integer;
		
		if (fractional < compareVal)
		{
			average = floor;
		} else
		{
			average = ceiling;
		}
		
		return average;
	}
   
}