import java.io.File;
import java.util.Random;
import java.util.Scanner;
/** @author Laila Alhalabi.
 * Assignment 3, COMP 352, March 29, 2021.
 * References: M. T. Goodrich, Data structures and algorithms in Java. Hoboken, N.J: Wiley, 2014. */
public class PQTester {
	
	/** A method that inserts random integers and strings from given files into a priority queue for N times. * @param pq * @param N */
	public static void insertElements(PriorityQueue pq, int N) {
		Scanner scanner = null;
		try {
			Random random = new Random();
			int key = 0;
			String value = null;
			if (10 <= N || N < 10000) { scanner = new Scanner(new File("elements_test_file1.txt")); } // 1st file
			if (10000 <= N || N < 100000) { scanner = new Scanner(new File("elements_test_file2.txt")); } // 2nd file
			if (100000 <= N || N < 1000000) { scanner = new Scanner(new File("elements_test_file3.txt")); } // 3rd file
			long start = System.nanoTime(); // Start time of the program
			for (int i = 0; i < N; i++) {
				// Generating & inserting random values & strings to thepriority queue
				key = (int) random.nextInt(); 
				value = scanner.nextLine();
				pq.insert(key, value); 
			}
			long end = System.nanoTime(); 
			long executionTime = (end - start);
			double seconds = (double) executionTime / 1000000000;
			System.out.println("FOR N# " + N + ", the program took " + seconds + " seconds to be insert " + N + " elements into the queue.");
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	/** A method that removes the inserted elements from the priority queue. * @param pq * @param N */
	public static void removeElements(PriorityQueue pq, int N) {
		try {
			long start = System.nanoTime(); // Start time of the program
			for (int i = 0; i < N; i++) {
				pq.removeMin(); 
			}
			long end = System.nanoTime(); 
			long executionTime = (end - start);
			double seconds = (double) executionTime / 1000000000;
			System.out.println("FOR N# " + N + ", the program took " + seconds + " seconds to be remove " + N + " elements from the queue.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {

		MyPQUnsortedArray<Integer, String> unsortedArray = new MyPQUnsortedArray<>();
		MyPQSortedArray<Integer, String> sortedArray = new MyPQSortedArray<>();
	
		// TESTING
		System.out.println("### Unsorted Array Priority Queue Tester: ");
		unsortedArray.insert(10, "A");
		unsortedArray.print();
		unsortedArray.insert(5, "A");
		unsortedArray.print();
		unsortedArray.insert(9, "B");
		unsortedArray.print();
		unsortedArray.insert(3, "C");
		unsortedArray.print();
		unsortedArray.insert(7, "D");
		unsortedArray.print();
		unsortedArray.removeMin();
		unsortedArray.print();
		unsortedArray.insert(7, "E");
		unsortedArray.print();
		unsortedArray.removeMin();	
		unsortedArray.print();
		unsortedArray.removeMin();
		unsortedArray.print();
		unsortedArray.removeMin();
		System.out.println("\n### Sorted Array Priority Queue Tester: ");
		sortedArray.insert(10, "A");
		sortedArray.print();
		sortedArray.insert(5, "A");
		sortedArray.print();
		sortedArray.insert(9, "B");
		sortedArray.print();
		sortedArray.insert(3, "C");
		sortedArray.print();
		sortedArray.insert(7, "D");
		sortedArray.print();
		sortedArray.removeMin();
		sortedArray.print();
		sortedArray.insert(7, "E");
		sortedArray.print();
		sortedArray.removeMin();	
		sortedArray.print();
		sortedArray.removeMin();
		sortedArray.print();
		sortedArray.removeMin();
		sortedArray.print();
		sortedArray.removeMin();
		sortedArray.print();
		
		// TESTING TIME COMPLEXITY
		System.out.println("\nMyPQUnsortedArray Testing:");
		for (int N = 10; N <= 10000; N = N*10) {
			insertElements(unsortedArray, N);
			removeElements(unsortedArray, N);
		}
		System.out.println("\nMyPQSortedArray Testing:");
		for (int N = 10; N <= 10000; N = N*10) {
			insertElements(sortedArray, N);
			removeElements(sortedArray, N);
		}
		
	}

}
