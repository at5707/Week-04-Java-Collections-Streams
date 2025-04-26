import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class InsuranceManager {
	public static void main(String[] args) {
		List<InsurancePolicy> policies=Arrays.asList(
				new InsurancePolicy("P001","Alice",1500),
				new InsurancePolicy("P002", "Bob", 900),
	            new InsurancePolicy("P003", "Charlie", 2000),
	            new InsurancePolicy("P004", "David", 3000),
	            new InsurancePolicy("P005", "Eve", 1100),
	            new InsurancePolicy("P006", "Smithson", 1700)
	    );
		// 1. Filter Policies by Premium Amount > 1200
		System.out.println("Policies with premium>1200:");
		policies.stream()
			.filter(p->p.getPremiumAmount()>1200)
			.forEach(System.out::println);
		// 2. Sort Policies by Holder Name
		System.out.println("\nPolicies sorted by holder name:");
		policies.stream()
			.sorted(Comparator.comparing(InsurancePolicy::getHolderName))
			.forEach(System.out::println);
		// 3. Compute Total Premium
		double totalPremium=policies.stream()
			.mapToDouble(InsurancePolicy::getPremiumAmount)
			.sum();
		System.out.println("\nTotal Premium Amount: "+totalPremium);
		// 4. Print Policy Details
		System.out.println("\nPolicy Details:");
		policies.forEach(p->System.out.println(p));
		// 5. Filter Policies by Premium Range (1000 to 2000)
		System.out.println("\nPolicies with premium between 1000 and 2000:");
		policies.stream()
			.filter(p->p.getPremiumAmount()>=1000 && p.getPremiumAmount()<=2000)
			.forEach(System.out::println);
		// 6. Find Policy with Highest Premium
		System.out.println("\nPolicy with highest premium:");
		policies.stream()
			.max(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
			.ifPresent(System.out::println);
		// 7. Group Policies by Holder Name Initial
		System.out.println("\nGrouped by Holder Name Initial:");
		Map<Character,List<InsurancePolicy>> groupedByInitial=policies.stream()
					.collect(Collectors.groupingBy(p->p.getHolderName().charAt(0)));
		groupedByInitial.forEach((initial,list)-> {
			System.out.println(initial+": "+list);
		});
		// 8. Compute Average Premium
		double avgPremium=policies.stream()
			.mapToDouble(InsurancePolicy::getPremiumAmount)
			.average()
			.orElse(0.0);
		System.out.println("\nAverage Premium: "+avgPremium);
		// 9. Sort Policies by Premium and Print
		System.out.println("\nPolicies sorted by premium:");
		policies.stream()
			.sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount))
			.forEach(System.out::println);
		// 10. Check If Any Policy Exceeds $2000
		boolean exceeds2000=policies.stream()
			.anyMatch(p->p.getPremiumAmount()>2000);
		System.out.println("\nAny policy with premium>2000: "+exceeds2000);
		// 11. Count Policies for Each Premium Range
		long below1000=policies.stream().filter(p->p.getPremiumAmount()<=1000).count();
		long between1000And2000=policies.stream().filter(p->p.getPremiumAmount()>1000 && p.getPremiumAmount()<=2000).count();
		long above2000=policies.stream().filter(p->p.getPremiumAmount()>2000).count();
		System.out.println("\nPolicy counts:");
		System.out.println("$0-$1000: "+below1000);
		System.out.println("$1001-$2000: "+between1000And2000);
		System.out.println(">$2000: "+above2000);
		// 12. Extract Unique Holder Names
		System.out.println("\nUnique Holder Names:");
		policies.stream()
			.map(InsurancePolicy::getHolderName)
			.distinct()
			.forEach(System.out::println);
		// 13. Find Policies by Holder Name Substring (e.g., "Smith")
		System.out.println("\nPolicies where holder name contains 'Smith':");
		policies.stream()
			.filter(p->p.getHolderName().toLowerCase().contains("smith"))
			.forEach(System.out::println);
		// 14. Create Map of Policy Number to Premium Amount
		System.out.println("\nMap of Policy Numbers to Premium Amounts:");
		Map<String,Double> policyMap=policies.stream()
			.collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));
		policyMap.forEach((k,v)->System.out.println(k+"->"+v));
	}
}