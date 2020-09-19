package random_programs;

import java.util.HashMap;

public class nthSmallestElement {

    int findNthSmallestElement(int[] a, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();

         Integer orDefault = map.getOrDefault(1,2);

        int m = n-1;
        for (int i = 0; i <= m; i++) {
            if (a[m] > a[i]) {
                int temp;
                temp = a[m];
                a[m] = a[i];
                a[i] = temp;
            }

        }
        for (int i = m; i < a.length; i++) {
            if (a[m + 1] < a[i]) {
                {
                    int temp;
                    temp = a[m];
                    a[m] = a[i];
                    a[i] = temp;
                }
            }
        }


        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        return a[m + 1];
    }

    void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        nthSmallestElement n = new nthSmallestElement();
        int[] a = {6, 7, 2, 15, 1, 11, 14};
        System.out.println("Smallest number is " + n.findNthSmallestElement(a, 3));
    }

}
