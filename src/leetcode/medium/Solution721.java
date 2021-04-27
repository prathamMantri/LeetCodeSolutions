package leetcode.medium;

import java.util.*;

public class Solution721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> emailToName = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        // idea is to create a graph where email are vertices. For a given account,
        // create an edge between all the emails in it. Also update emailToName Map
        for (List<String> account : accounts) {
            // for current account, get the name
            String name = account.get(0);

            // remaining elements in the account list are emails. Create edges among them
            for (int i = 1; i < account.size(); i++) {
                String firstEmail = account.get(1);
                String currentEmail = account.get(i);

                // populate graph
                graph.computeIfAbsent(currentEmail, x -> new ArrayList<>()).add(firstEmail);
                graph.computeIfAbsent(firstEmail, x -> new ArrayList<>()).add(currentEmail);

                // update emailToName map
                emailToName.put(currentEmail, name);
            }
        }

        // Once we have graph created, problem is reduced to find connected components in this
        // graph. We will use DFS to find connected components in graph and add that to answer.
        Set<String> seenEmails = new HashSet<>();

        // create result list
        List<List<String>> ans = new ArrayList();

        // start DFS
        for (String email : graph.keySet()) {
            if (!seenEmails.contains(email)) {
                // mark it visited
                seenEmails.add(email);

                // For DFS, we will use a Stack
                Stack<String> stack = new Stack<>();
                stack.push(email);

                // All emails in same component
                List<String> connectedComponent = new ArrayList<>();

                while (!stack.isEmpty()) {
                    String node = stack.pop();
                    connectedComponent.add(node);

                    for (String neigh : graph.get(node)) {
                        if (!seenEmails.contains(neigh)) {
                            seenEmails.add(neigh);
                            stack.push(neigh);
                        }
                    }
                }

                // add connectedComponent to result
                Collections.sort(connectedComponent);
                connectedComponent.add(0, emailToName.get(email));
                ans.add(connectedComponent);
            }
        }
        return ans;
    }


    public List<List<String>> accountsMergeDisjointSet(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<>();
        List<String> account = new ArrayList<>();

        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john_newyork@mail.com");

        accounts.add(new ArrayList<>(account));
        account.clear();
        account.add("John");
        account.add("johnsmith@mail.com");
        account.add("john00@mail.com");
        accounts.add(new ArrayList<>(account));
        account.clear();
        account.add("Mary");
        account.add("mary@mail.com");
        accounts.add(new ArrayList<>(account));
        account.clear();
        account.add("John");
        account.add("johnnybravo@mail.com");
        accounts.add(new ArrayList<>(account));

        List<List<String>> tests = new ArrayList<>();
        List<String> test = new ArrayList<>();

        test.add("a");
        test.add("b");
        test.add("c");
        tests.add(new ArrayList<>(test));
        test.clear();

        test.add("d");
        test.add("e");
        test.add("f");
        tests.add(new ArrayList<>(test));
        test.clear();

        test.add("g");
        test.add("a");
        test.add("d");
        tests.add(new ArrayList<>(test));
        test.clear();

        Solution721 sol = new Solution721();
        sol.accountsMerge(accounts);

    }


}
