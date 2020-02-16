package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Solution380 {

    public static void main(String[] args) {

        RandomizedSet randomSet = new RandomizedSet();

       /* ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
        [[],[1],[2],[2],[],[1],[2],[]]*/


        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.insert(5));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
     /*   System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());*/


    }

    static class RandomizedSet {

        /**
         * Initialize your data structure here.
         */

        Set<Integer> set;

        RandomizedSet() {
            set = new HashSet<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        boolean insert(int val) {
            if (!set.contains(val)) {
                set.add(val);
                return true;
            }
            return false;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            if (set.size() > 0) {
                Integer[] setArray = new Integer[set.size()];
                set.toArray(setArray);
                System.out.println("Index: " + ((int) System.nanoTime() % set.size()));
                return setArray[(int) (System.nanoTime() % set.size())];
            } else {
                return -1;
            }
        }
    }

}
