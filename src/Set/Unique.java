package Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Unique {
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<>();
		list.add("I");
		list.add("I");
		list.add("I");
		list.add("I");
		list.add("see");
		list.add("now");
		Set<String> unique = new HashSet<>();
		Set<String> dup = new HashSet<>();
		for (String string : list) {
			if(!unique.add(string)) {
				dup.add(string);
			}
		}
		unique.removeAll(dup);
		System.out.println(unique);
		System.out.println(dup);
	}
}
