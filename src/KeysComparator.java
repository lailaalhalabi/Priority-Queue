/** @author Laila Alhalabi 
  * A comparator class for keys of tye integer 
  * @param <K> */
public class KeysComparator<K>{
	
	private int result = 0;
	/** A method that compares two keys of type integer and returns the result after comparing. */
	public int compare(K k1, K k2) { 
		
		if((int)k1 < (int)k2)
			result = -1;
		
		if((int)k1 > (int)k2)
			result = 1;
		
		if((int)k1 == (int)k2)
			result = 0;
		
		return result;
	}
}
