package List;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author johir
 * The method count is syncronized because it will be used by parallelstream
 * Another way can be to use AtomicInteger
 * Instead of using synchronized method we can use count() on agrreagator that is built in.
 */
public class ParallelStreamPerformance {
	static long totaleven = 0;
	public static void main(String[] args) {
		List<Integer> randomList = new ArrayList<>();
		Random rnd = new Random();
		for(int i = 0 ;i < 100;i++) {
			int r = rnd.nextInt(500000);
			randomList.add(r);
		}
		
		long s1 = System.currentTimeMillis();
		
		totaleven = randomList.stream().filter(e -> e%2 ==0).count();
		System.out.println("Even: "+totaleven);
		long e1 = System.currentTimeMillis();
		System.out.println("Time: "+(e1 - s1));
		
		totaleven = 0;
		long s2 = System.currentTimeMillis();
		
		totaleven = randomList.parallelStream().filter(e -> e%2 ==0).count();
		System.out.println("Even: "+totaleven);
		long e2 = System.currentTimeMillis();
		System.out.println("Time: "+(e2 - s2));
	}
	
	
	public static synchronized void count() {
		totaleven++;
	}
}
