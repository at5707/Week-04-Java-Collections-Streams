import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    LocalDate transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    public double getAmount() {
        return amount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
}

class FraudSummary {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    public FraudSummary(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "ALERT → Policy: " + policyNumber + 
               " | Fraud Count: " + fraudCount + 
               " | Total Fraud Amount: $" + totalFraudAmount;
    }
}
public class TransactionFraudDetection {
	public static List<FraudSummary> detectFraud(List<Transaction> transactions) {
        return transactions.stream()
            // Step 1: Filter
            .filter(t -> t.isFraudulent && t.amount > 10000)
            // Step 2: Group by policyNumber
            .collect(Collectors.groupingBy(Transaction::getPolicyNumber))
            // Step 3 + 4: Aggregate & Alert generation
            .entrySet().stream()
            .map(entry -> {
                String policyNumber = entry.getKey();
                List<Transaction> txns = entry.getValue();
                long count = txns.size();
                double totalAmount = txns.stream().mapToDouble(Transaction::getAmount).sum();
                return new FraudSummary(policyNumber, count, totalAmount);
            })
            .filter(summary -> summary.fraudCount > 5 || summary.totalFraudAmount > 50000)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "POL123", 15000, LocalDate.of(2024, 1, 10), true),
            new Transaction("T2", "POL123", 12000, LocalDate.of(2024, 2, 5), true),
            new Transaction("T3", "POL123", 13000, LocalDate.of(2024, 3, 1), true),
            new Transaction("T4", "POL123", 11000, LocalDate.of(2024, 4, 2), true),
            new Transaction("T5", "POL123", 14000, LocalDate.of(2024, 5, 15), true),
            new Transaction("T6", "POL123", 17000, LocalDate.of(2024, 6, 1), true),
            new Transaction("T7", "POL456", 60000, LocalDate.of(2024, 3, 10), true),
            new Transaction("T8", "POL789", 5000, LocalDate.of(2024, 3, 12), true), // ignored (not > 10000)
            new Transaction("T9", "POL789", 20000, LocalDate.of(2024, 4, 1), false) // ignored (not fraudulent)
        );

        List<FraudSummary> alerts = detectFraud(transactions);
        alerts.forEach(System.out::println);
    }
}