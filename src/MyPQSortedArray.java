/** @author Laila Alhalabi 
 * Array-based implementation of MyPQ (sorted)
 * References: M. T. Goodrich, Data structures and algorithms in Java. Hoboken, N.J: Wiley, 2014.
 * @param <K> * @param <V> */
public class MyPQSortedArray<K, V> extends PriorityQueue<K, V> {

	// Creating an array to store the entries
	private ArrayList<Entry<K, V>> elements = new ArrayList<>();
	
	/** Creates empty PQ. */
	public MyPQSortedArray() { 
		super(); 
	}
	
	/** Creates an empty PQ using the given comparator to order keys. */
	public MyPQSortedArray(KeysComparator<K> comp) { 
		super(comp); 
	} 
	
	/** @param index * @return Returns the index of the parent of the passed index. */
	private int getParent(int index) { 
		return (index-1) / 2; 
	} 
	
	/** @param index * @return Returns the left child of the passed index. */
	private int getLeft(int index) { 
		return 2*index + 1; 
	} 
	
	/** @param index * @return Returns the right child of the passed index. */
	private int getRight(int index) { 
		return 2*index + 2; 
	} 
	
	/** @param index * @return Returns true if the left child index exists. */
	private boolean hasLeft(int index) { 
		return getLeft(index) < size(); 
	} 
	
	/** @param index * @return Returns true if the right child index exists. */
	private boolean hasRight(int index) { 
		return getRight(index) < size(); 
	}
	
	/** @param index1 * @param index2 * A method that swaps two elements at given indexes. */
	public void swap(int index1, int index2) {
		Entry<K, V> temp = elements.getElementAt(index1);
		elements.setElement(index1, elements.getElementAt(index2));
		elements.setElement(index2, temp);
	}

	/** @param index * Moving the index down and modifying the min-heap till reaching the root at 0. */
	public void downheap(int index) {
		while (hasLeft(index)) { // While the end isn't reached
			int left = getLeft(index);
			if (hasRight(index)) {
				int right = getRight(index);
				if (compare(elements.getElementAt(left).getKey(), elements.getElementAt(right).getKey()) > 0)
					left = right; // swapping if the right index is smaller
			}
			if (compare(elements.getElementAt(left).getKey(), elements.getElementAt(index).getKey()) >= 0) {
				break;
			}
			swap(index, left);
			index = left;
		}
	}

	/** @param index * Moving the index up and modifying the min-heap till reaching the root at 0. */
	public void upheap(int index) {
		while (index > 0) { // While the root isn't reached
			int parent = getParent(index);
			if (compare(elements.getElementAt(index).getKey(), elements.getElementAt(parent).getKey()) >= 0)
				break;
			swap(index, parent);
			index = parent;
		}
	}
	
	/** Adding an entry at the beginning of the list.* @param key * @param value * @return Returns the created entry. */
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K, V> newEntry = new PQEntry<>(key, value);
		elements.add(size(), newEntry);
		upheap(size()-1);
		return newEntry;
	}

	/** @return Returns (but does not remove) a priority queue entry (k,v) having minimal key. */
	@Override
	public Entry<K, V> min() {
		if (isEmpty())
			return null;
		else return elements.getElementAt(0);
	}
	
	/** @return Returns and removes an entry (k,v) having minimal key from the priority queue. */
	@Override
	public Entry<K, V> removeMin() {
		if (isEmpty()) 
			return null;
		swap(0, elements.size()-1); // Swapping the min item to the end
		elements.remove(elements.size()-1); // Removing the min item
		downheap(0);
		return elements.getElementAt(0);
	}

	/** @return Returns the number of entries in the priority queue. */
	@Override
	public int size() {
		return elements.size();
	}
	
	/** A method that prints the elements of the priority queue. */
	public void print() {
		elements.print();
	}
}
