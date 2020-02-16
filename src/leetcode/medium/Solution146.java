package leetcode.medium;


/*

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution146 {
    private int capacity;

    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();


    private Solution146(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        System.out.println("null");
        Solution146 obj = new Solution146(2);
        obj.put(2, 1);
        System.out.println("null");
        obj.put(2, 2);
        System.out.println("null");
        System.out.println(obj.get(2));
        obj.put(1, 1);
        System.out.println("null");
        obj.put(4, 1);
        System.out.println("null");

        System.out.println(obj.get(2));
        //System.out.println(obj.get(4));
        //obj.get(3);
        //obj.get(4);
    }

    public int get(int key) {
        if (queue.contains(key)) {
            int value = map.get(key);
            queue.remove(key);
            queue.add(key);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        /*if (map.size() == capacity) {
            if (map.containsKey(key)) {
                map.put(key, value);
                queue.remove(key);
                queue.add(key);
            }else {
                int keyEvicted = queue.peek();
                map.remove(keyEvicted);
                map.put(key, value);
                queue.poll();
            }
        }
        map.put(key, value);
        if(!queue.contains(key))
            queue.add(key);*/

        if (map.containsKey(key)) {
            map.put(key, value);
        } else if (map.size() == capacity) {
            int keyEvicted = queue.peek();
            map.remove(keyEvicted);
            map.put(key, value);
            queue.poll();
        } else {
            map.put(key, value);
        }
        if (queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
        } else {
            queue.add(key);
        }


    }
}


//["LRUCache","put","put","get","put","get","put","get","get","get"]
        /*["LRUCache","put","put","get","put","get","put","get","get","get","put"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4],[5,5]]*/
        /*
        ["LRUCache","put","put","get","put","put","get"]
        [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
         */
        /*
        ["LRUCache","get","put","get","put","put","get","get"]
        [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
         */
        /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         */

        /*
        ["LRUCache","put","put","put","put","get","get"]
[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */