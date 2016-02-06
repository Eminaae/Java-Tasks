package ba.generics.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericsAndCollections {
	
	private static int integerElements(List<Integer> ints) {
		
		int sum = 0;
		for(int i : ints){
			sum += i;
		}
		System.out.println(sum);
		return sum;
	}
	
	private static void stringElements(){
		List<String> words = new ArrayList<>();
		words.add("Hello ");
		words.add("World!");
		String sentence = words.get(0) + words.get(1);
		assert sentence.equals("Hello World!");
		System.out.println(sentence);
		
	}
	
	public static void removeNegative(List<Integer> list){
		for(Iterator<Integer> it = list.iterator(); it.hasNext();){
			if(it.next() > 0)
				it.remove();
		}
	}
	
	public static <T> List<T> toList(T[] arr){
		List<T> list = new ArrayList<T>();
		for(T element : arr){
			list.add(element);
		}
		return list;
		
	}
	
	public static <T> List<T> varArgs(T... arr){
		List<T> list = new ArrayList<T>();
		for(T element : arr){
			list.add(element);
		}
		return list;
		
	}
	
	public static <T> void addAll(List<T> list, T... arr){
		for(T element: arr)
			list.add(element);
	}
	
	public static <T> void copy(List<? super T> destination, List<? extends T> source){
		for( int i = 0; i < source.size(); i ++){
			destination.set(i, source.get(i));
		}
	}
	
	public static double sum(Collection<? extends Number> numbers){
		double sum = 0.0;
		for(Number n : numbers)
			sum += n.doubleValue();
		return sum;	
	}
	
	public static void count(Collection<? super Integer> ints, int n){
		for(int i = 0; i < n; i ++)
			ints.add(i);
	}

	public static void main(String[] args) {
		integerElements(Arrays.asList(1, 2, 3, 4, 5));
		stringElements();
		List<Integer> ints = GenericsAndCollections.toList(new Integer[] {1, 2, 3});
		System.out.println(ints);
		List<String> words = GenericsAndCollections.toList(new String[] {"hello ", "there"});
		System.out.println(words);
		
		List<Integer> vars = GenericsAndCollections.varArgs(1, 2, 3);
		System.out.println(vars);
		
		List<Integer> addAllInts = new ArrayList<>();
		GenericsAndCollections.addAll(addAllInts, 1, 2);
		GenericsAndCollections.addAll(addAllInts, new Integer[]{3, 4, 5, 6});
		GenericsAndCollections.addAll(addAllInts, new Integer[]{3, 4, 5, 6});
		System.out.println(addAllInts);
		
		List<Object> obj = Arrays.asList(2, 3.14, "two");
		List<Integer> integers = Arrays.asList(5, 11);
		GenericsAndCollections.copy(obj, integers);
		System.out.println(obj);
		GenericsAndCollections.<Object>copy(obj, integers);
		System.out.println(obj);
		GenericsAndCollections.<Integer>copy(obj, integers);
		System.out.println(obj);
		GenericsAndCollections.<Number>copy(obj, integers);
		System.out.println(obj);
		System.out.println(sum(integers));
		System.out.println(sum(Arrays.asList(1, 2, 5, 5, 66.23)));
		
		List<Integer> listIntegers = new ArrayList<>();
		GenericsAndCollections.count(listIntegers, 5);
		listIntegers.add(5);
		System.out.println(listIntegers);
		
		List<Number> listNumbers = new ArrayList<>();
		GenericsAndCollections.count(listNumbers, 5);
		listNumbers.add(5.150);
		System.out.println(listNumbers);
		
		List<Object> listObjects = new ArrayList<>();
		GenericsAndCollections.count(listObjects, 5);
		listObjects.add("five");
		listObjects.add("two");
		System.out.println(listObjects);
		
		
	}

	
}
