package ba.bitcamp.array.vs.linked;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Array List and Linked List implement List interface. This class represents performance of
 * ArrayList vs LinkedList. LinkedList is faster in add and remove, but slower in get and set method.
 * LinkedList should be preferred if there are no large number of random access of elements,
 * if there are a large number of add/remove operations
 * @author Emina
 *
 */
public class PerformanceTest {
	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		//adding elements to array list
		long startTime = System.nanoTime();
		for(int i = 0; i < 100000; i++){
			arrayList.add(i);
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Adding to array list: " + duration);
		
		//adding elements to linked list
		long startTime1 = System.nanoTime();
		for(int i = 0; i < 100000; i++){
			linkedList.add(i);
		}
		long endTime1 = System.nanoTime();
		long duration1 = endTime1 - startTime1;
		System.out.println("Adding to linked list: " + duration1);
		
		//getting elements from array list
		long startTime2 = System.nanoTime();
		for(int i = 0; i < 10000; i++){
			arrayList.get(i);
		}
		long endTime2 = System.nanoTime();
		long duration2 = endTime2 - startTime2;
		System.out.println("Getting elements from array list: " + duration2);

		// getting elements from linked list
		long startTime3 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			linkedList.get(i);
		}
		long endTime3 = System.nanoTime();
		long duration3 = endTime3 - startTime3;
		System.out.println("Getting elements from linked list: " + duration3);
		
		// removing elements from array list
		long startTime4 = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			arrayList.remove(i);
		}
		long endTime4 = System.nanoTime();
		long duration4 = endTime4 - startTime4;
		System.out.println("Removing elements from array list: " + duration4);

		// removing elements from linked list
		long startTime5 = System.nanoTime();
		for (int i = 9999; i >= 0; i--) {
			linkedList.get(i);
		}
		long endTime5 = System.nanoTime();
		long duration5 = endTime5 - startTime5;
		System.out.println("Removing elements from linked list: " + duration5);
	}

}
