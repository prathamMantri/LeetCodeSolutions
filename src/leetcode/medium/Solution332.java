package leetcode.medium;

import java.util.*;

//Needs more attention

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */


public class Solution332 {

    public static void main(String[] args) {
        Solution332 sol = new Solution332();

        List<List<String>> tickets = new ArrayList<>();

       /* List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("KUL");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("NRT");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("NRT");
        ticket3.add("JFK");*/

        List<String> ticket1 = new ArrayList<>();
        ticket1.add("JFK");
        ticket1.add("SFO");
        List<String> ticket2 = new ArrayList<>();
        ticket2.add("JFK");
        ticket2.add("ATL");
        List<String> ticket3 = new ArrayList<>();
        ticket3.add("SFO");
        ticket3.add("ATL");
        List<String> ticket4 = new ArrayList<>();
        ticket4.add("ATL");
        ticket4.add("JFK");
        List<String> ticket5 = new ArrayList<>();
        ticket5.add("ATL");
        ticket5.add("SFO");

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);

        sol.findItinerary(tickets);


    }

    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> res = new ArrayList<>();

        Map<String, TreeSet<String>> itenaryMap = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            TreeSet<String> list = itenaryMap.get(from) != null ? itenaryMap.get(from) : new TreeSet<>();
            list.add(to);
            itenaryMap.put(from, list);
        }
        res.add("JFK");
        getNextStop("JFK", itenaryMap, res);
        return res;
    }

    private void getNextStop(String start, Map<String, TreeSet<String>> iternaryMap, List<String> res) {

        if (iternaryMap.get(start) == null || iternaryMap.get(start).size() == 0) {
            return;
        }

        Iterator itr = iternaryMap.get(start).iterator();

        while (itr.hasNext()) {
            String next = (String) itr.next();
            if (iternaryMap.containsKey(next)) {
                iternaryMap.get(start).remove(next);
                res.add(next);
                getNextStop(next, iternaryMap, res);
            } else {
                if (!itr.hasNext()) {
                    res.add(next);
                }
            }
        }

    }


}
