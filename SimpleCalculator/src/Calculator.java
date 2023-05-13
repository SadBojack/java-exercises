
import java.util.Scanner;
public class Calculator {

    private Scanner scanner;
    public Calculator() {
        this.scanner = new Scanner(System.in);
    }

    public int add() {
        System.out.println("How many numbers would you like to add?");
        int numberOfItems = Integer.valueOf(this.scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= numberOfItems; i++) {
            System.out.println("Enter number " + i);
            int entry = Integer.valueOf(this.scanner.nextLine());
            sum += entry;
        }
        return sum;
    }

    public int subtract() {
        System.out.println("How many numbers would you like to subtract?");
        int numberOfItems = Integer.valueOf(this.scanner.nextLine());
        System.out.println("Enter number 1");
        int difference = Integer.valueOf(this.scanner.nextLine());
        for (int i = 2; i <= numberOfItems; i++) {
            System.out.println("Enter number " + i);
            int entry = Integer.valueOf(this.scanner.nextLine());
            difference -= entry;
        }
        return difference;
    }

    public int multiply() {
        System.out.println("Enter first number");
        int first = Integer.valueOf(this.scanner.nextLine());
        System.out.println("Enter second number:");
        int second = Integer.valueOf(this.scanner.nextLine());
        int product = first * second;
        return product;
    }

    public double divide() {
        System.out.println("Enter dividend");
        double dividend = Double.valueOf(this.scanner.nextLine());
        double divisor = 0;
        while (divisor == 0) {
            System.out.println("Enter divisor");
            divisor = Double.valueOf(this.scanner.nextLine());
            if (divisor == 0){
                System.out.println("Cannot divide a number by 0. Try to enter another divisor.");
            }
        }
        double quotient = dividend / divisor;
        return quotient;
    }

    public double remainder() {
        System.out.println("Enter dividend");
        double dividend = Double.valueOf(this.scanner.nextLine());
        double divisor = 0;
        while (divisor == 0) {
            System.out.println("Enter divisor");
            divisor = Double.valueOf(this.scanner.nextLine());
            if (divisor == 0){
                System.out.println("Cannot divide a number by 0. Try to enter another divisor.");
            }
        }
        double remainder = dividend % divisor;
        return remainder;
    }
}
