import java.util.ArrayList;

public class BankAccounts {
    private ArrayList<Account> list;

    public BankAccounts() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Account> accounts() {
        return this.list;
    }

    public void add(Account account) {
        this.list.add(account);
    }
}
