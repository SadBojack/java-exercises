import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        UserInterface ui = new UserInterface(calculator, scanner);
        ui.start();
    }
}
