package leetcode.easy;

// Design HashSet

import java.util.ArrayList;
import java.util.List;

public class Solution705 {

    List<Integer> hashset;

    Solution705() {
        hashset = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution705 sol = new Solution705();

        sol.add(1);
        sol.add(2);
        System.out.println(sol.contains(2));
        System.out.println(sol.contains(3));
        sol.add(2);
        System.out.println(sol.contains(2));
        sol.remove(2);
        System.out.println(sol.contains(2));
    }

    void add(int key) {
        if (!contains(key))
            hashset.add(key);
    }

    void remove(int key) {
        if (contains(key))
            hashset.remove((Integer) key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return hashset.contains(key);
    }


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


}
