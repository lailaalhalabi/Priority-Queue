
/** @author Laila Alhalabi * Implementation of an entry class and a comparator object to manage keys. * @param <K> * @param <V> */
public abstract class PriorityQueue<K, V> implements MyPQ<K, V> {

	/** @author Laila Alhalabi * private entry class * @param <K> * @param <V> */
    protected class PQEntry<K, V> implements Entry<K, V> {
    	
		private K key;
		private V value;
		
		/** A constructor to add a key and value to the PQ. * @param key * @param value */
		public PQEntry(K key, V value) { 
			super(); 
			this.key = key; 
			this.value = value; 
		}
		
		/** @return Returns the key stored in this entry. */
		public K getKey() { 
			return key; 
		}  
		
		/** @return Returns the value stored in this entry. */
		public V getValue() { 
			return value; 
		}
		
		/** Sets a value to a specific key * @param key */
		public void setKey(K key) { 
			this.key = key; 
		}  
		
		/** Sets a value to a specific value * @param value */
		public void setValue(V value) { 
			this.value = value; 
		}
		
		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}
	
	protected KeysComparator<K> comparator;
	
	/** A method that creates a PQ using a passed comparator. */
	public PriorityQueue(KeysComparator<K> c) {
		comparator = c;
	} 
	
	/** A method that creates a PQ using a passed comparato. */
	public PriorityQueue() { 
		this.comparator = new KeysComparator<K>();
	}

	/** A method that compares two keys. Returns -1 if k1<k2, 1 if k1>k2 and 0 if k1=k2. */
	public int compare(K k1, K k2) {
		return this.comparator.compare(k1, k2);
	}
	
	/** Checking the key's validity. * @param key * @return 0 if it can be compared to itself * @throws IllegalArgumentException */
	public boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comparator.compare(key, key) == 0);
		} catch (Exception e) {
			throw new IllegalArgumentException("Not a valid key");
		}
	}
	
	/** A method that checks if the array is empty. */
	public boolean isEmpty() {
		return size() == 0;
	}
}
