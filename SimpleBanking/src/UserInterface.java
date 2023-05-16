import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

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
                write();
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
                if (balance < 0) {
                    System.out.println("Unable to create account wth negative balance");
                    delay();
                    return;
                }
                Account user = new Account(name, balance, setAccountNum(accounts));
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
                if (amount > 0) {
                    account.deposit(amount);
                    System.out.println(account);
                    delay();
                    return;
                } else {
                    System.out.println("Invalid amount");
                    delay();
                    return;
                }
                
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
                if (amount <= 0 || amount > account.getBalance()) {
                    System.out.println("Invalid amount");
                    delay();
                    return;
                } else {
                    account.withdraw(amount);
                    System.out.println(account);
                    delay();
                    return;
                }
                
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

    public void loadAccounts() {
        try {
            File file = new File("ExistingAccounts.csv");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine() || reader.nextLine().equals("")) {
                String account = reader.nextLine();
                String[] accountInfo = account.split(",");
                Account oldAccount = new Account(accountInfo[0], Double.valueOf(accountInfo[1]), accountInfo[2]);
                accounts.add(oldAccount);
            }
            reader.close();
        }
        catch (Exception e) {

        }
    }

    public void write() {
        try {
            FileWriter writer = new FileWriter("ExistingAccounts.csv");
            for (Account account : accounts.accounts()) {
                writer.write(account.getName() + "," + account.getBalance() + "," + account.getAccountNum() + "\n");
            }
            writer.close();
        } catch (Exception e) {

        }
        
    }

    public String setAccountNum(BankAccounts list) {
        int accountNum = list.lastAccountNum();
        accountNum++;
        String actualAccountNum = "";
        if (accountNum < 10) {
            actualAccountNum = "00000" + accountNum;
        } else if (accountNum < 100) {
            actualAccountNum = "0000" + accountNum;
        } else if (accountNum < 1000) {
            actualAccountNum = "000" + accountNum;
        } else if (accountNum < 10000) {
            actualAccountNum = "00" + accountNum;
        } else if (accountNum < 100000) {
            actualAccountNum = "0" + accountNum;
        }
        return actualAccountNum;

    }
}