public class Account {
    private String name;
    private String accountNum;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.accountNum = "111";
        
    }

    public String getName() {
        return this.name;
    }

    public String getAccountNum() {
        return this.accountNum;
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
