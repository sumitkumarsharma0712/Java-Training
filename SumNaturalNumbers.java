package Study;

import java.util.Scanner;

public class SumNaturalNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Input: N
		System.out.print("Enter a number: ");
		int N = scanner.nextInt();
		
		int sum = 0;
		int i = 1;
		
		// Sum using while Loop
		while (i <= N) {
			sum += i;
			i++;
		}
		
		// Output
		System.out.println("Sum of first " + N + " natural numbers is: " + sum);
		
		scanner.close();

	}

}
