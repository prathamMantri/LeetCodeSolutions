package leetcode.easy;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int countOne = 0;
        for (int i : flowerbed) {
            if (i == 1)
                countOne++;
        }
        int requiredCountOne = flowerbed.length % 2 == 0 ? flowerbed.length / 2 : flowerbed.length / 2 + 1;
        return n <= requiredCountOne - countOne;
    }
}
