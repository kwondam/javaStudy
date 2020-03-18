package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{

	@Override
	public String apply(String s1, String s2) {
		if(s1.length() >= s2.length()) {
			return s1;}
		else {
			return s2;
	}
}
}

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = {"안녕하세요", "헤레로", "반갑", "하이"};
		
		String a= Arrays.stream(greetings).reduce("", (s1, s2)->{
			if(s1.getBytes().length >= s2.getBytes().length) {
				return s1;}
			else return s2;
		});
		System.out.println(a);
		System.out.println(Arrays.stream(greetings).reduce(new CompareString()).get());
		
	}
}