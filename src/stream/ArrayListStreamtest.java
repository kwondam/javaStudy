package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamtest {

	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		
		sList.add("dd");
		sList.add("aaa");
		sList.add("vv");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s -> System.out.print(s+ " "));
		System.out.println();
		
		sList.stream().sorted().forEach(s -> System.out.print(s+" "));
		System.out.println();
		sList.stream().map(s -> s.length()).forEach(n -> System.out.println(n));
		
		
		int[] arr = {1,2,3,4,5};
		
		int sum = Arrays.stream(arr).sum();
		int count = (int)Arrays.stream(arr).count();
		
		System.out.println(sum);
		System.out.println(count);
	}

}
