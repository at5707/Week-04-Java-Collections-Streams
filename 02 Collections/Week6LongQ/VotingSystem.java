import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {
    private Map<String,Integer> voteMap=new HashMap<>();
    private Map<String,Integer> voteOrderMap=new LinkedHashMap<>();
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0)+1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }
    public void displayVotesInInsertionOrder() {
        System.out.println("== Vote Counts (Order of Voting) ==");
        for (Map.Entry<String,Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
    public void displayVotesSorted() {
        System.out.println("== Vote Counts (Sorted by Candidate) ==");
        TreeMap<String,Integer> sorted=new TreeMap<>(voteMap);
        for (Map.Entry<String,Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
    public static void main(String[] args) {
        VotingSystem system=new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Charlie");
        system.castVote("Alice");
        system.castVote("Bob");
        system.displayVotesInInsertionOrder();
        System.out.println();
        system.displayVotesSorted();
    }
}