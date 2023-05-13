
import java.util.Scanner;
public class UserInterface {

    private Calculator calculator;
    private Scanner scanner;
    public UserInterface(Calculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
    }

    public void start(){
        
        System.out.println("Simple Calculator");
        while (true) {
            System.out.println("Which operation would you like to conduct? Enter the keyword below:" );
            System.out.println("add");
            System.out.println("subtract");
            System.out.println("multiply");
            System.out.println("divide");
            System.out.println("remainder");
            System.out.println("quit");
            String input = this.scanner.nextLine();
            if (input.equals("add")) {
                System.out.println("sum: " + this.calculator.add());
            } else if (input.equals("subtract")) {
                System.out.println("difference: " + this.calculator.subtract());
            } else if (input.equals("multiply")) {
                System.out.println("product: " + this.calculator.multiply());
            } else if (input.equals("divide")) {
                System.out.println("quotient: " + this.calculator.divide());
            } else if (input.equals("remainder")) {
                System.out.println("remainder: " + this.calculator.remainder());
            } else if (input.equals("quit")) {
                break;
            }

        }
    }
}