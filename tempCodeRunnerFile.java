import java.util.Scanner;

public class EvenOddCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input from user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        //Check even or odd
        if (number % 2 == 0) {
            System.out.println("Even");
        
        } else {
            System.out.println("Odd");
        }
    }
    Scanner.close();
}