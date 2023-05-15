import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private BankAccounts accounts;

    public UserInterface(Scanner scanner, BankAccounts accounts) {
        this.scanner = scanner;
        this.accounts = accounts;
    }

    public void start() {
        while (true) {
            System.out.println("Simple Banking");
            System.out.println("Select a transaction");
            System.out.println("new - Creates a new account");
            System.out.println("deposit - add funds to an account");
            System.out.println("withdraw - withdraw funds from account");
            System.out.println("check - check account balance");
            System.out.println("quit - exits program");
            String entry = scanner.nextLine();

            if (entry.equals("new")) {
                newAccount();
            } else if (entry.equals("deposit")) {
                deposit();
            } else if (entry.equals("withdraw")) {
                withdraw();
            } else if (entry.equals("check")) {
                check();
            } else if (entry.equals("quit")) {
                System.out.println("Thank you!");
                break;
            }

        }
    }

    public void newAccount() {
        System.out.println("Enter account name");
                String name = scanner.nextLine();
                System.out.println("Enter initial balance");
                double balance = Double.valueOf(scanner.nextLine());
                Account user = new Account(name, balance);
                System.out.println(user);
                accounts.add(user);
                delay();
                
    }

    public void deposit() {
        System.out.println("Enter name or Account number:");
        String entry = scanner.nextLine();
        for (Account account : accounts.accounts()) {
            if (account.getName().equals(entry) || account.getAccountNum().equals(entry)) {
                System.out.println("Deposit amount: ");
                double amount = Double.valueOf(scanner.nextLine());
                account.deposit(amount);
                System.out.println(account);
                delay();
                return;
            } 
        }    
        System.out.println("Account does not exist");
        delay();
    }

    public void withdraw() {
        System.out.println("Enter name or Account number:");
        String entry = scanner.nextLine();
        for (Account account : accounts.accounts()) {
            if (account.getName().equals(entry) || account.getAccountNum().equals(entry)) {
                System.out.println("Withdraw amount: ");
                double amount = Double.valueOf(scanner.nextLine());
                account.withdraw(amount);
                System.out.println(account);
                delay();
                return;
            } 
        }
        System.out.println("Account does not exist");    
        delay();
    }

    public void check() {
        System.out.println("Enter name or Account number:");
        String entry = scanner.nextLine();
        for (Account account : accounts.accounts()) {
            if (account.getName().equals(entry) || account.getAccountNum().equals(entry)) {
                System.out.println(account);
                delay();
                return;
            }    
        }
        System.out.println("Account does not exist.");
        delay();
    }

    public void delay() {
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            
        }
    }
}