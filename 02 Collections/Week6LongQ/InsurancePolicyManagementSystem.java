import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
public class InsurancePolicyManagementSystem {
    private Set<Policy> hashSet=new HashSet<>();
    private Set<Policy> linkedHashSet=new LinkedHashSet<>();
    private Set<Policy> treeSet=new TreeSet<>();
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies (HashSet):");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }

    public void displayPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        System.out.println("\nPolicies Expiring Within 30 Days:");
        for (Policy p : treeSet) {
            if (!p.getExpiryDate().isAfter(thresholdDate)) {
                System.out.println(p);
            }
        }
    }

    public void displayPoliciesByCoverageType(String type) {
        System.out.println("\nPolicies with Coverage Type: " + type);
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void findDuplicatePolicies(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        System.out.println("\nDuplicate Policy Numbers:");
        for (String dup : duplicates) {
            System.out.println(dup);
        }
    }

    public void comparePerformance() {
        int n = 10000;
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testPolicies.add(new Policy("PN" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 1000 + i));
        }
        Set<Policy> hashSetTest = new HashSet<>();
        long start = System.nanoTime();
        for (Policy p : testPolicies) hashSetTest.add(p);
        long end = System.nanoTime();
        System.out.println("\nHashSet - Time to add " + n + " policies: " + (end - start) + " ns");
        Set<Policy> linkedHashSetTest = new LinkedHashSet<>();
        start = System.nanoTime();
        for (Policy p : testPolicies) linkedHashSetTest.add(p);
        end = System.nanoTime();
        System.out.println("LinkedHashSet - Time to add " + n + " policies: " + (end - start) + " ns");
        Set<Policy> treeSetTest = new TreeSet<>();
        start = System.nanoTime();
        for (Policy p : testPolicies) treeSetTest.add(p);
        end = System.nanoTime();
        System.out.println("TreeSet - Time to add " + n + " policies: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        Policy p1 = new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 7000);
        Policy p3 = new Policy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 6000);
        Policy p4 = new Policy("P004", "David", LocalDate.now().plusDays(5), "Health", 8000);
        Policy p5 = new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 7000); // duplicate

        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);
        system.addPolicy(p5);

        system.displayAllPolicies();
        system.displayPoliciesExpiringSoon();
        system.displayPoliciesByCoverageType("Health");

        List<Policy> allPolicies = List.of(p1, p2, p3, p4, p5);
        system.findDuplicatePolicies(allPolicies);

        system.comparePerformance();
    }
}
