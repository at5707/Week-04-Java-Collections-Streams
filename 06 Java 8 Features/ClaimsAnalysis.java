import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    Date claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}
public class ClaimsAnalysis {
	static class ClaimSummary {
        String policyNumber;
        double totalAmount;
        double averageAmount;

        public ClaimSummary(String policyNumber, double totalAmount, double averageAmount) {
            this.policyNumber = policyNumber;
            this.totalAmount = totalAmount;
            this.averageAmount = averageAmount;
        }

        @Override
        public String toString() {
            return "Policy: " + policyNumber +
                    ", Total Amount: $" + totalAmount +
                    ", Average Amount: $" + String.format("%.2f", averageAmount);
        }
    }

    public static List<ClaimSummary> analyzeClaims(List<Claim> claims) {
        // Step 1 & 2: Filter + Group
        Map<String, List<Claim>> grouped = claims.stream()
            .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        // Step 3: Aggregate
        List<ClaimSummary> summaries = grouped.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                List<Claim> policyClaims = entry.getValue();
                double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
                double average = total / policyClaims.size();
                return new ClaimSummary(policy, total, average);
            })
            // Step 4: Top 3 by total claimAmount
            .sorted((a, b) -> Double.compare(b.totalAmount, a.totalAmount))
            .limit(3)
            .collect(Collectors.toList());

        return summaries;
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C1", "P001", 7000, new Date(), "Approved"),
            new Claim("C2", "P002", 10000, new Date(), "Rejected"),
            new Claim("C3", "P001", 6000, new Date(), "Approved"),
            new Claim("C4", "P003", 8000, new Date(), "Approved"),
            new Claim("C5", "P004", 12000, new Date(), "Approved"),
            new Claim("C6", "P004", 9000, new Date(), "Approved"),
            new Claim("C7", "P003", 6500, new Date(), "Approved"),
            new Claim("C8", "P005", 5500, new Date(), "Approved"),
            new Claim("C9", "P005", 3500, new Date(), "Approved")
        );

        List<ClaimSummary> topPolicies = analyzeClaims(claims);
        System.out.println("Top 3 Policies by Total Claim Amount:");
        topPolicies.forEach(System.out::println);
    }
}