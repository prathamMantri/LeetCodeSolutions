package leetCode.medium;


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
import java.util.Stack;

public class Solution146 {
    private int capacity;
    private Stack lruCount;
    private HashMap lruCache;

    public Solution146(int capacity) {
        Stack<Integer> lruCount = new Stack<>();
        HashMap<Integer, Integer> lruCache = new HashMap<>();
        this.lruCache = lruCache;
        this.lruCount = lruCount;
        this.capacity = capacity;
    }

    public static void main(String[] args) {

        Solution146 obj = new Solution146(2);
        System.out.println("null");

        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);
        obj.get(2);
        obj.put(4, 4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }

    public int get(int key) {
        Integer value = (Integer) lruCache.get(key);
        if (value == null) {
            System.out.println(-1);
            return -1;
        } else {
            lruCount.pop();
            System.out.println(value);
            return value;
        }
    }

    public void put(int key, int value) {
        if (lruCache.size() == capacity) {
            Integer keyToReplace = (Integer) lruCount.peek();
            lruCount.pop();
            lruCache.remove(keyToReplace);
        }
        lruCache.put(key, value);
        lruCount.push(key);
        System.out.println("null");
    }


}
