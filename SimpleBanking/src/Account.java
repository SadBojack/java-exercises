

public class Account {
    private String name;
    private String accountNum;
    private double balance;

    public Account (String name, double balance, String accountNum) {
        this.name = name;
        this.balance = balance;
        this.accountNum = accountNum;
    }
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
       
        
    }

    public String getName() {
        return this.name;
    }

    public String getAccountNum() {
        return this.accountNum;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
    

    public String toString() {
        return "Account name: " + this.name + "\nAccount number: " + this.accountNum + "\nBalance: " + this.balance;
    }
}
