/** @author Laila Alhalabi 
  * PQ entry interface 
  * @param <K> * @param <V> */
public interface Entry<K, V> { 
	
	/** @return Returns the key stored in this entry. */
	public K getKey();
	
	/** @return Returns the value stored in this entry. */
	public V getValue();
	
}
