package bank;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccount {

    private double balance;

    // Constructor to initialize balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Inner test class to keep the test code in the same file
    public static class BankAccountTest {

        @Test
        public void testDeposit() {
            BankAccount account = new BankAccount(100.0);
            account.deposit(50.0);
            assertEquals(150.0, account.getBalance());
        }

        @Test
        public void testWithdrawInsufficientFunds() {
            BankAccount account = new BankAccount(100.0);
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(150.0);
            });
            assertEquals("Insufficient funds.", exception.getMessage());
        }

        @Test
        public void testGetBalance() {
            BankAccount account = new BankAccount(500.0);
            assertEquals(500.0, account.getBalance());
        }
    }
}