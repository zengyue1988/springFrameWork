package com.moon.Java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HelloStream {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, null, 3, 4, null, 6, 7, 8 ,9, 10, 10);
		nums.stream()
		.filter(n -> n !=null)
		.distinct()
		.mapToDouble(n -> n)
		.peek(System.out::println)
		.skip(2)
		.limit(4)
		.forEach(System.out::println);
		// stream filter collect count joining 
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered);
		System.out.println(strings.stream().filter(string->string.isEmpty()).count());
		String mergedStr = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.joining(","));
		System.out.println(mergedStr);
		// parallelStream
		System.out.println(strings.parallelStream().filter(string->string.isEmpty()).count());
		// limit forEach sorted 
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		random.ints().limit(10).sorted().forEach(System.out::println);
		// map distinct 
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
		System.out.println(squaresList);
		// statistics sum average count max min
		IntSummaryStatistics statistics = numbers.stream().mapToInt(n->n).summaryStatistics();
		System.out.println(statistics.getMax()+" "+statistics.getMin()+" "+statistics.getSum()+" "+statistics.getCount()+" "+statistics.getAverage());
	}

}
