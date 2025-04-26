class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance=initialBalance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount<0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount>balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance-=amount;
        System.out.println("Withdrawl successful, new balance: "+balance);
    }
}
public class BankSystem {
    public static void main(String[] args) {
        BankAccount account=new BankAccount(5000);
        try {
            account.withdraw(2000);
            account.withdraw(-100);
            account.withdraw(4000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}