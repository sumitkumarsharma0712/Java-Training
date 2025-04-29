package Study;

import java.util.Scanner;

public class greatest_of_two_numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Input two numbers
		System.out.print("Enter the first number: ");
		int num1 = scanner.nextInt();
		
		System.out.print("Enter the second number: ");
		int num2 = scanner.nextInt();
		
		
		// Using if-else to find the greatest
		if (num1 > num2) {
			System.out.println(num1 + "is greater than " + num2);
		} else if (num2 > num1) {
			System.out.println(num2 + " is greater than " + num1);
		} else {
			System.out.println("Both numbers are equal.");
		}
		
		scanner.close();
	}

}
