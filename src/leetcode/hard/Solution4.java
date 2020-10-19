package leetcode.hard;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1 = nums1.length;
        int num2 = nums2.length;

        if (num1 > num2)
            return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = num1;

        while (start <= end) {

            int partition1 = (end + start) / 2;
            int partition2 = (num1 + num2 + 1) / 2 - partition1;

            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = partition1 == num1 ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = partition2 == num2 ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((num1 + num2) % 2 == 0)
                    return (double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2;
                else
                    return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }
        return -1;
    }
}
