package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListFiltering {
	private static int count = 0;
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Hello");
		list.add("Apple");
		list.add("Time");
		list.add("Apple");
		// Using stream, filter and parallel stream over list
		list.stream().
		filter(e -> e.equals("Apple")).
		forEach(e -> increment());
		System.out.println(count);
		
		List<Integer> ilit = new ArrayList<>();
		for(int i =0 ;i<10;i++) {
			Random rnd = new Random();
			ilit.add(rnd.nextInt(100000));
		}
		String joined = list.stream().collect(Collectors.joining(", "));
		System.out.println(joined);
		String allints= ilit.stream().map(Object::toString).collect(Collectors.joining(", "));
		System.out.println(allints);
		int sum = ilit.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println("Sum = "+sum);
		
		Object [] a =ilit.toArray();
		Integer [] arr = ilit.toArray(new Integer[0]);
		System.out.println(arr.length);
	}
	public static void increment() {
		count++;
	}
}
