/** @author Laila Alhalabi. 
  * Priority Queue Interface. 
  * @param <K> * @param <V> */
public interface MyPQ<K, V> {
	
	/** @param key * @param value * @return Creates an entry with a key and a value in the priority queue. */
	Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
	
	/** @return Returns (but does not remove) a priority queue entry (k,v) having minimal key. */
	Entry<K,V> min();	
	
	/** @return Returns and removes an entry (k,v) having minimal key from the priority queue. */
	Entry<K,V> removeMin();	
	
	/** @return Returns the number of entries in the priority queue. */
	int size();
	
	/** @return Returns a boolean indicating whether the priority queue is empty. */
	boolean isEmpty();

}
