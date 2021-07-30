package companies.interview_questtions_swigy;

import java.util.Arrays;

public class Swigy1 {
    public static void main(String[] args) {

        Swigy1 sw = new Swigy1();
        int[] input = {6, 7, 3, 2, 0, 7, 5, 6};
        System.out.println(sw.findBias(input));

    }

    public int findBias(int[] input) {


        Arrays.sort(input);

        int i = 0;
        int sum = 0;

        if (input.length == 1)
            return 0;

        while (i < input.length - 1) {

            int current = input[i];
            int next = input[i + 1];

            sum = sum + next - current;
            i = i + 2;
        }
        return sum;

    }
}
