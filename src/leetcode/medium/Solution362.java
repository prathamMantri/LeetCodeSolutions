package leetcode.medium;

import java.util.*;

public class Solution362 {


    class Hit{

        int timeStamp;
        int hitCount;

        public Hit(int timeStamp, int hitCount){

            this.timeStamp = timeStamp;
            this.hitCount = hitCount;

        }

    }

    class HitCounter {

        Deque<Hit> hitCount;

        /** Initialize your data structure here. */
        public HitCounter() {
            hitCount = new LinkedList<>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {

            if(hitCount.isEmpty())
                hitCount.addFirst(new Hit(timestamp, 1));
            else{
                int lastTimestamp = hitCount.getLast().timeStamp;
                if(timestamp > lastTimestamp - 300)
                    hitCount.addLast(new Hit(timestamp, 1));
                else
                    hitCount.addLast(new Hit(timestamp, hitCount.getLast().hitCount + 1));
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {

            int lastTimestamp = hitCount.getLast().timeStamp;
            if(timestamp / 300 > 1)
                return 0;
            return hitCount.getLast().hitCount;

        }
    }




}
