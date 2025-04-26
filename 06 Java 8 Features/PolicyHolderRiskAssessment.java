import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;
    String riskCategory;

    public RiskAssessment(String holderId, String name, double riskScore, String riskCategory) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
        this.riskCategory = riskCategory;
    }

    @Override
    public String toString() {
        return "Holder ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore + ", Risk Category: " + riskCategory;
    }
}
public class PolicyHolderRiskAssessment {
	public static List<RiskAssessment> assessRisk(List<PolicyHolder> holders) {
        // Step 1: Filter policyholders with policyType "Life" and age > 60
        return holders.stream()
            .filter(h -> h.policyType.equals("Life") && h.age > 60)
            .map(h -> {
                // Step 2: Calculate risk score
                double riskScore = h.premiumAmount / h.age;
                // Step 3: Categorize based on risk score
                String category = riskScore > 0.5 ? "High Risk" : "Low Risk";
                return new RiskAssessment(h.holderId, h.name, riskScore, category);
            })
            // Step 4: Sort by risk score in descending order
            .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("P1", "John Doe", 65, "Life", 1000),
            new PolicyHolder("P2", "Jane Smith", 55, "Life", 600),
            new PolicyHolder("P3", "Alice Johnson", 70, "Life", 1500),
            new PolicyHolder("P4", "Bob Brown", 63, "Life", 1200),
            new PolicyHolder("P5", "Charlie Davis", 80, "Health", 2000),
            new PolicyHolder("P6", "Eve White", 72, "Life", 1800)
        );

        List<RiskAssessment> assessments = assessRisk(holders);
        assessments.forEach(System.out::println);
    }
}