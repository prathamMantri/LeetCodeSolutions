package companies.interview_questions_amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGame {

    static int GCD(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        if (a > b)
            return GCD(a - b, b);
        return GCD(a, b - a);
    }

    public static void main(String[] args) {

        NumberGame ng = new NumberGame();
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(5);

        System.out.println(ng.findMax(list, 2));


    }

    int findMax(List<Integer> list, int N) {

        List<Integer> gcds = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int gcd = GCD(list.get(i), list.get(j));
                gcds.add(gcd);
            }
        }
        int res = 0;
        Collections.sort(gcds, (a, b) -> b - a);
        int index = 0;
        while (N != 0) {
            res = res + (gcds.get(index++) * N);
            N--;
        }
        return res;
    }


}
