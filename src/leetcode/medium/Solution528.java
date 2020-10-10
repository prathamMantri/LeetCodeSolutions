package leetcode.medium;

public class Solution528 {

    public static class RandomPick {
        int[] indexArray;

        public RandomPick(int[] w) {
            int sum = 0;
            for (int num : w)
                sum += num;
            indexArray = new int[sum];

            int end;
            int current = 0;
            for (int weight : w) {
                end = current + weight;
                while (current < end) {
                    indexArray[current++] = weight;
                }
            }
        }

        public int pickIndex() {
            //int randomIndex = System.currentTimeMillis()/Math.random()
            return indexArray[0];
        }
    }
}
