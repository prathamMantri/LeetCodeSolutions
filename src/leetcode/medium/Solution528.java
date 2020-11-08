package leetcode.medium;

import java.util.Arrays;

public class Solution528 {

  /*  public static class RandomPick {
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
    }*/

    private final double[] probabilities;

    public Solution528(int[] w) {
        double sum = 0;
        this.probabilities = new double[w.length];
        for (int weight : w)
            sum += weight;
        for (int i = 0; i < w.length; i++) {
            w[i] += (i == 0) ? 0 : w[i - 1];
            probabilities[i] = w[i] / sum;
        }
    }

    public int pickIndex() {
        return Math.abs(Arrays.binarySearch(this.probabilities, Math.random())) - 1;
    }


}
