/** @author Laila Alhalabi 
  * Implementation of my ArrayList class. 
  * References: M. T. Goodrich, Data structures and algorithms in Java. Hoboken, N.J: Wiley, 2014.
  * @param <E> */
public class ArrayList<E> {
	 
	private E[] elements; 
	private int size = 0; 
	private int capacity = 1;
	private final static int DEFAULT_CAPACITY = 1;
   
	/** A constructor that creates an arraylist object with the initial default capacity. */
	public ArrayList() { 
		this(DEFAULT_CAPACITY); 
	}
	
	/** A constructor that initializes an array with the default capacity. * @param capacity */
	public ArrayList(int capacity) { 
		elements = (E[]) new Object[capacity]; 
	}
	
	/** @param i * @return Returns the element at a given index */
	public E getElementAt(int i) { 
		isValidIndex(i, size);
	return elements[i];
	}
	
	/** Setting an element at a given index * Time complexity is O(1).
	  * @param i * @param element * @return Returns the old element */
	public E setElement(int i, E element) {
		isValidIndex(i, size);
		E temp = elements[i];
		elements[i] = element;
		return temp;
	}
	
	/** Adding an element at a given index. * Time complexity is O(n). * @param i * @param element */
	public void add(int i, E element) {
		if (isValidIndex(i, size + 1) == false) {
			return;
		}
		if (isFull()) { 
			capacity = elements.length*2;
			resize(capacity);
		}
		for (int k = size - 1; k >= i; k--) { // Adding the element and increasing the size
			elements[k + 1] = elements[k];
		}
		elements[i] = element;
		size++;
	}
	
	/** Removing an element at a given index. * Time complexity is O(n). * @param i * @return Returns the deleted element. */
	public E remove(int i) {
		if (isValidIndex(i, size) == false)
			return null;
		if (size < (elements.length/4)) {
			capacity = elements.length/2;
			resize(capacity);
		}
		E temp = elements[i];
		for (int k = i; k < size - 1; k++) { // Removing the element and decreasing the size
			elements[k] = elements[k + 1];
		}
		elements[size - 1] = null;
		size--;
		return temp;
	} 
	
	/** A method for removing a passed item.* @param toRemove */
	public void removeItem(E toRemove) {
		for (int k = 0; k < size; k++) {
			if(toRemove == elements[k])
				remove(k);
		}
	}
	
	/** Checking if the index is a valid index. * Time complexity is O(1).* @param i * @param size */
	protected boolean isValidIndex(int i, int size) {
		if (i < 0 || i >= size) {
			return false;
		} else
			return true;
	}
	
	/** @return Returns the size of the list. * Time complexity is O(1).*/
	public int size() {
		return size;
	}
	
	/** @return Returns true if the list is empty. * Time complexity is O(1). */
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	/** @return Returns true if there is no capacity to insert new elements. * Time complexity is O(1). */
	public boolean isFull() { 
		return size == capacity; 
	}
	
	/** Resizing the capacity of the list and copying the objects. * Time complexity is O(n). * @param capacity */
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // Creating a new object with the passed capacity
		for (int k = 0; k < size; k++) {
			temp[k] = elements[k];
		}
		elements = temp; 
	}
	
	/** A method that prints the list. * Time complexity is O(n).*/
	public void print() {
		if (isEmpty()) { // If the list is empty
			System.out.println("The list is empty!");
			return;
		}
		System.out.println("The list has a capacity of " + capacity + ", and contains the following " + size + " items: ");
		System.out.print("{ ");
		for (int i = 0; i < size; i++) { // If the list is not empty it will prints till it reach an empty node
			System.out.print(elements[i] + " ");
		}
		System.out.print("}\n");
	}
}
