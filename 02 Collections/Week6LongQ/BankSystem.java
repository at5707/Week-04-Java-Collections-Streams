import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class WithdrawalRequest {
    String accountNumber;
    double amount;
    WithdrawalRequest(String accountNumber,double amount) {
        this.accountNumber=accountNumber;
        this.amount=amount;
    }
}
public class BankSystem {
    private Map<String,Double> accountMap=new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue=new LinkedList<>();
    public void addOrUpdateAccount(String accountNumber,double balance) {
        accountMap.put(accountNumber, balance);
    }
    public void requestWithdrawl(String accountNumber,double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
    }
    public void processWithdrawls() {
        System.out.println("== Processing Withdrawals ==");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request=withdrawalQueue.poll();
            Double balance=accountMap.get(request.accountNumber);
            if (balance==null) {
                System.out.println("Account not found: "+request.accountNumber);
            } else if (balance>=request.amount) {
                accountMap.put(request.accountNumber, balance-request.amount);
                System.out.printf("Withdrawn %.2f from %s. New Balance: %.2f%n",
                                  request.amount, request.accountNumber, accountMap.get(request.accountNumber));
            } else {
                System.out.printf("Insufficient funds for %s. Requested: %.2f, Available: %.2f%n",
                                  request.accountNumber, request.amount, balance);
            }
        }
    }
    public void displayAccountsSortedByBalance() {
        System.out.println("== Accounts Sorted by Balance ==");
        TreeMap<Double,List<String>> sortedAccounts=new TreeMap<>();
        for (Map.Entry<String,Double> entry : accountMap.entrySet()) {
            sortedAccounts
                .computeIfAbsent(entry.getValue(), k->new ArrayList<>())
                .add(entry.getKey());
        }
        for (Map.Entry<Double,List<String>> entry : sortedAccounts.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.printf("Account: %s, Balance: %.2f%n", acc, entry.getKey());
            }
        }
    }
    public static void main(String[] args) {
        BankSystem bank=new BankSystem();
        bank.addOrUpdateAccount("ACC001", 1000.0);
        bank.addOrUpdateAccount("ACC002", 1500.0);
        bank.addOrUpdateAccount("ACC003", 800.0);
        bank.addOrUpdateAccount("ACC004", 1200.0);
        bank.requestWithdrawl("ACC002", 300.0);
        bank.requestWithdrawl("ACC003", 900.0);
        bank.requestWithdrawl("ACC001", 500.0);
        bank.processWithdrawls();
        System.out.println();
        bank.displayAccountsSortedByBalance();
    }
}