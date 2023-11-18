package testcases.selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public abstract class Streams_InDepth_25 implements Comparable {

	public static void main(String[] args) {
		int count = 0;
		List<String> names = new ArrayList<String>();
		names.add("Adam");
		names.add("John");
		names.add("Alekhya");
		names.add("Abhi");
		names.add("Mohan");
		
		for(String name: names) {
			if (name.startsWith("A")) {
				count++;
			}
		}
		
		System.out.println("count: " + count);
		
		long streamCount = names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println("streamCount: " + streamCount);
		
		//We can directly create streams
		Stream<String> newNames = Stream.of("kanya", "jashu", "buddi"); 
		System.out.println(newNames.filter(name -> name.compareTo("kanya") == 0).count());
		
		//Terminal operation executes if only intermediate operation(filter) returns true
		long l = Stream.of("kanya", "jashu", "buddi").filter(name ->
					{
					     name.startsWith("k");
					     return false;
					}
				).count();
		
		System.out.println(l); //value is 0 because at the end we are returning false,upon false count will not calculate.
		//if we remove 'return false' then we will get correct results
		
		//print all the names of the list
		names.stream().forEach(name -> System.out.println(name)); 
		
		System.out.println("-------------------For each------------------------");
		//print all the names with length of name is greater than 4
		names.stream().filter(name -> name.length() > 4).forEach(name -> System.out.println(name));
		
		System.out.println("--------------------Limit-------------------------------");
		//print all the names with length of name is greater than 4 but limited to one
		names.stream().filter(name -> name.length() > 4).limit(1).forEach(name -> System.out.println(name));
		System.out.println("------------------Map----------------------------------");
		names.stream().filter(name -> name.endsWith("n")).map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));
		
		System.out.println("---------------------------sorted-------------------------------------");
		//print names which have first letter as a with uppercase and sorted
		names.stream().filter(name -> name.startsWith("A")).map(name -> name.toUpperCase()).sorted().forEach(name -> System.out.println(name));
		
		//Sort in reverse order
		
		System.out.println("--------------------------reverse order--------------------------------");
		//We have to implement Comparable/Comparator interfaces to use "Comparator.reverseOrder()" inside sorted method to sort in reverse order.
		names.stream().filter(name -> name.startsWith("A")).map(name -> name.toUpperCase()).sorted(Comparator.reverseOrder()).forEach(name -> System.out.println(name));
		
		//Sort list in ascending and descending orders
		System.out.println("------------------------------ascending list------------------------------------");
		Collections.sort(names);
		System.out.println(names);
		System.out.println("------------------------------descending list ------------------------------");
		Collections.sort(names, Collections.reverseOrder());
		//Collections.sort(names, Comparator.reverseOrder()); we can use both Collections/Comparator for reverse order sorting
		System.out.println(names);
		
		List<String> names1 = Arrays.asList("Kanya", "Jashu", "Buddi", "Daddy");
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
	//	newStream.forEach(name -> System.out.println(name)); //This is terminal operation and stream will get closed once terminal operation is called and it throws "IllegalStateException"
		boolean flag = newStream.anyMatch(name -> name.contentEquals("Kanya"));
		System.out.println(flag);
		
		//print unique numbers/distinct numbers
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,1,2,3, 9,4,5,6,7);
		numbers.stream().distinct().forEach(number -> System.out.print(number));
		
		//collect stream into lit by Collectors
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctNumbers);
		
	}
}
