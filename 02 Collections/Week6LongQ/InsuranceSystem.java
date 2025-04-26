import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    public Policy(String policyNumber,String policyholderName,LocalDate expiryDate) {
        this.policyNumber=policyNumber;
        this.policyholderName=policyholderName;
        this.expiryDate=expiryDate;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getPolicyholderName() {
        return policyholderName;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return "Policy{"+
               "Number='"+policyNumber+'\''+
               ", Holder='"+policyholderName+'\''+
               ", Expiry=" + expiryDate+
               '}';
    }
}
class PolicyManager {
    private Map<String,Policy> hashMap=new HashMap<>();
    private Map<String,Policy> insertionOrderMap=new LinkedHashMap<>();
    private TreeMap<LocalDate,List<Policy>> expiryDateMap=new TreeMap<>();
    public void addPolicy(Policy policy) {
        String number=policy.getPolicyNumber();
        hashMap.put(number, policy);
        insertionOrderMap.put(number, policy);
        expiryDateMap.computeIfAbsent(policy.getExpiryDate(), k->new ArrayList<>()).add(policy);
    }
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }
    public List<Policy> getPoliciesExpiringInNext30Days() {
        LocalDate now=LocalDate.now();
        LocalDate next30=now.plusDays(30);
        return expiryDateMap.subMap(now, true, next30, true)
                .values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    public List<Policy> getPoliciesByHolder(String holderName) {
        return hashMap.values().stream()
                .filter(p->p.getPolicyholderName().equalsIgnoreCase(holderName))
                .collect(Collectors.toList());
    }
    public void removeExpiredPolicies() {
        LocalDate today=LocalDate.now();
        expiryDateMap.headMap(today,false).values().forEach(policies->{
            for (Policy p : policies) {
                hashMap.remove(p.getPolicyNumber());
                insertionOrderMap.remove(p.getPolicyNumber());
            }
        });
        expiryDateMap.headMap(today,false).clear();
    }
    public void listAllPoliciesInsertionOrder() {
        insertionOrderMap.values().forEach(System.out::println);
    }
    public void listAllPoliciesSortedByExpiry() {
        expiryDateMap.values().stream().flatMap(List::stream).forEach(System.out::println);
    }
}
public class InsuranceSystem {
    public static void main(String[] args) {
        PolicyManager manager=new PolicyManager();
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P1003", "Alice", LocalDate.now().minusDays(5)));
        manager.addPolicy(new Policy("P1004", "Charlie", LocalDate.now().plusDays(25)));
        System.out.println("== Policies by Holder 'Alice' ==");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);
        System.out.println("\n== Policies Expiring in 30 Days ==");
        manager.getPoliciesExpiringInNext30Days().forEach(System.out::println);
        System.out.println("\n== Removing Expired Policies ==");
        manager.removeExpiredPolicies();
        System.out.println("\n== All Policies in Insertion Order ==");
        manager.listAllPoliciesInsertionOrder();
        System.out.println("\n== All Policies Sorted by Expiry Date ==");
        manager.listAllPoliciesSortedByExpiry();
    }
}