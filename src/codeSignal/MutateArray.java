package codeSignal;

public class MutateArray {

    public static void main(String[] args) {

        MutateArray m = new MutateArray();
        int[] a = {4, 0, 1, -2, 3};
        m.mutateTheArray(5, a);


    }

    int[] mutateTheArray(int n, int[] a) {


        int[] result = new int[n];

        if (n == 1) {
            return a;
        } else if (n == 2) {
            result[0] = a[0] + a[1];
            result[1] = result[0];
        } else {
            result[0] = a[0] + a[1];
            for (int i = 1; i < n - 2; i++) {
                result[i] = a[i - 1] + a[i] + a[i + 1];
            }
            result[n - 1] = a[n - 1] + a[n - 2];
        }
        return result;
    }


}
