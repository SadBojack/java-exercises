import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccounts accounts = new BankAccounts();
        UserInterface ui = new UserInterface(scanner, accounts);
        ui.start();
    }
}
