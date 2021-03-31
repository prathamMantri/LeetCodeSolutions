package sorting;

public class MergeTwoSortedArray {

    public static void mergeSortTwoArray(int[] nums1, int m, int[] nums2, int n) {

        m--;
        n--;

        int index = nums1.length - 1;
        while (index >= 0) {
            if (m < 0) {
                nums1[index] = nums2[n--];
            } else if (n < 0) {

                nums1[index] = nums1[m--];
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[index] = nums1[m--];

                } else {
                    nums1[index] = nums2[n--];
                }
            }
            index--;

        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void main(String[] args) {

        int[] a = new int[8];
        a = new int[]{1, 2, 8, 10, 0, 0, 0};
        int[] b = {5, 7, 9};
        MergeTwoSortedArray ms = new MergeTwoSortedArray();
        mergeSortTwoArray(a, a.length, b, b.length);
        /*
         * for (int i = 0; i < a.length; i++) { System.out.println("Element at index " +
         * i + " : "+ a[i]); }
         */
    }


}
