package testcases.selenium;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_Brush_Up_For_Selenium_2 {

	public static void main(String[] args) {
		
		//Data types
		Integer value = 1;
		System.out.println(value);
		
		short s = 32767;
		System.out.println(Short.MAX_VALUE);
		Integer b = -129;
		float f = b.floatValue();
		
		
		float floatValue = 10f;
		System.out.println(floatValue);
		
		double doubleValue = 1000d;
		System.out.println(doubleValue);
		
		long longValue = 2845679892929298999L;
		System.out.println(longValue);
		
		//if number is equal to argument integer then returns 0 if less than returns -1 and if greater than returns  1
		System.out.println(b.compareTo(-129));//Signed comparison 
		
		
		//Switch case
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Enter your roll Number:");
		int rollNumber = sc.nextInt();
		switch(rollNumber) {
		case 1: 
			System.out.println("Kanya is here");
			break;
		case 2:
			System.out.println("Jashu is here");
			break;
		case 3:
			System.out.println("Buddi is here");
			break;
		case 4:
			System.out.println("Daddy is here");
			break;
		default:
			System.out.println("Default is here");
		}
		sc.close();*/
		
		//Arrays in java
		int[] arr = new int[5]; //declaring array
		arr[0] = 03; //assigning values individually.
		arr[1] = 27;
		arr[2] = 1998;
		System.out.println(arr[0] + "/" + arr[1] + "/" + arr[2]);
		//we can directly initialize values to array.
		int integers[] = {10, 20, 30};
		System.out.println(integers[2]);
		
		System.out.println("--------------------------------------for loop");
		
		//for loop
		for (int i = 0; i < integers.length; i++) {
			System.out.println(integers[i]);
		}
		System.out.println("-------------------------------------- for each loop");
		
		//for each loop (or) enhanced for loop
		for (int i : arr) {
			System.out.println(i);
		}
		
		System.out.println("----------------------------------------------while loop");
		//while loop
		int i = 0;
		while(i < arr.length) {
			System.out.println(arr[i]);
			i++;
		}
		
		System.out.println("--------------------------------------------trying while in for loop");
		for (int j = 0; j < arr.length; j++) {
			System.out.println("j value: " + j);
			//while(arr[j] == 1998);
			System.out.println(arr[j]);
		}
		
		String[] names = new String[4];
		String[] arrayStrings = {"Daddy", "Mummy", "Daughter", "Son"};
		for (String values: arrayStrings) {
			System.out.println(values);
		}
		
		System.out.println("------------------------------------------------- array list");
		
		//Arraylist
		ArrayList<Object> a = new ArrayList<Object>(); //Here we have given object so any data type we can add.
		a.add("kanya");
		a.add(10);
		a.add(90.00);
		a.add(true);
		a.add('D');
		System.out.println(a);
		
		ArrayList<Object> bLists = new ArrayList<>();
		bLists.add("Jashu");
		bLists.addAll(a); //we can add all the elements from other collections.
		bLists.remove(5); //we can remove items based on index value.
		System.out.println(bLists);
		System.out.println("-------------------------------------------------------------------- Strings");
		//String creation by 2 ways - String literal 
		String stringLiteral = "This is String literal"; 
		String s2 = "This is String literal"; //here in string literal it can not create one more object as it has the same content of "stringLiteral" object.
		//Split Operation
		String[] splittedString = stringLiteral.split(" is ");
		for (String val : splittedString) {
			System.out.println(val);
		}
		
		//printing all characters
		for (int k = s2.length() - 1; k >= 0; k--) {
			System.out.print(s2.charAt(k));//Printing string in reverse order.
			
		}
		
		//by using new keyword (String object)
		String s3 = new String("new"); 
		String s4 = new String("new"); //s4 content is same as s3 but still s4 object will get create.
		
		
		
		
		

	}

}
