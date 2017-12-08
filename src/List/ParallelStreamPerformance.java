package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author johir
 * Wonderfull observation..
 * stream and parallelstream not correctly behaving
 *
 */
public class ParallelStreamPerformance {
	static int totaleven = 0;
	public static void main(String[] args) {
		List<Integer> randomList = new ArrayList<>();
		Random rnd = new Random();
		for(int i = 0 ;i < 100;i++) {
			int r = rnd.nextInt(500000);
			randomList.add(r);
		}
		
		long s1 = System.currentTimeMillis();
		
		randomList.stream().filter(e -> e%2 ==0).forEach(e -> count());
		System.out.println("Even: "+totaleven);
		long e1 = System.currentTimeMillis();
		System.out.println("Time: "+(e1 - s1));
		
		totaleven = 0;
		long s2 = System.currentTimeMillis();
		
		randomList.parallelStream().filter(e -> e%2 ==0).forEach(e -> count());
		System.out.println("Even: "+totaleven);
		long e2 = System.currentTimeMillis();
		System.out.println("Time: "+(e2 - s2));
	}
	
	
	public static synchronized void count() {
		totaleven++;
	}
}
