package leetcode.medium;

import java.util.*;

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


/**
 *          The graph must be Eulerian since we know that a Eulerian path exists.
 *          Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Eulerian path in the graph which is a valid reconstruction.
 *          Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.
 */

public class Solution332 {


    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket : tickets) {

            String source = ticket.get(0);
            String dest = ticket.get(1);

            map.putIfAbsent(source, new PriorityQueue<>());
            map.get(source).add(dest);

        }
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", map, result);
        return result;

    }

    private void dfs(String source, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> destinations = map.get(source);
        while (!destinations.isEmpty()) {
            dfs(destinations.poll(), map, res);
        }
        res.addFirst(source);
    }


    public List<String> findItineraryError(List<List<String>> tickets) {

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
