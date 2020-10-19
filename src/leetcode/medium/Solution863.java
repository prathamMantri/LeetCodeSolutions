package leetcode.medium;

import model.TreeNode;

import java.util.*;

public class Solution863 {

    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> result = new ArrayList<>();

        if (root == null || target == null || K < 0) {
            return result;
        }

        //Create a map which will contain current node as its key and it will have its parent and children in the list as its value.

        createMap(root, null);

        // if map doesnt have target as key, it means, target is not present in the given Tree structure
        if (!map.containsKey(target)) {
            return result;
        }

        // To keep track of visited node for scanning through BFS
        Set<TreeNode> visited = new HashSet<>();

        // To keep track of elements to be scanned using BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the current target in the queue and visited.
        queue.add(target);
        visited.add(target);

        //traverse through the nodes from queue until queue becomes empty
        while (!queue.isEmpty()) {
            int size = queue.size();
            //if K value becomes 0 or is 0, then get all the elements out of queue and add it in result.
            if (K == 0) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
            } else {
                // else loop for size times (as size is dynamically increasingwhile adding the element, make sure, you have 'size' variable not being changed.
                while (size > 0) {
                    //get first node from queue and add all the element from the map in the queue and in visited set.
                    TreeNode node = queue.poll();
                    for (TreeNode next : map.get(node)) {
                        if (visited.contains(next)) continue;
                        visited.add(next);
                        queue.add(next);
                    }
                    size--;
                }
            }
            // decreament K as we are K minus one level away from target.
            K--;
        }
        return result;
    }

    private void createMap(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        if (!map.containsKey(node)) {
            // for root element
            map.put(node, new ArrayList<>());
            if (parent != null) {
                //add parent in the current node's value as a list
                map.get(node).add(parent);
                // as parent is already added, add current node in the parent's value as a list
                map.get(parent).add(node);
            }
            //recursively call left subtree
            createMap(node.left, node);
            //recursively call right subtree
            createMap(node.right, node);
        }
    }

}
