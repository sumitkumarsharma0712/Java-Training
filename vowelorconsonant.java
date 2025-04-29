package Study;

import java.util.Scanner;

public class vowelorconsonant {
	
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 
		 //Ask the user for a character
		 System.out.print("Enter an alphabet: ");
		 char ch = scanner.next().charAt(0);
		 // Read the first character
		 
		 switch (Character.toLowerCase(ch)) {
		 case 'a':
		 case 'e':
		 case 'i':
		 case 'o':
		 case 'u':
			 System.out.println(ch + " is a vowel.");
			 break;
			 default:
				 //check if it's a Letter
				 if (Character.isLetter(ch)) {
					 System.out.println(ch + " is a consonant.");
				 } else {
					 System.out.println(ch + " is not an alphabet.");
				 }
		    	
		 }
		 
		 scanner.close();
	 }
	        
}
