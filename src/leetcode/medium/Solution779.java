package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution779 {
    public static void main(String[] args) {
        Solution779 sol = new Solution779();
        System.out.println(sol.kthGrammar(30, 434991989));
    }

    public int kthGrammar(int N, int K) {
        List<Integer> list = new ArrayList<>();
        if (N == 1) {
            return 0;
        }
        list.add(0);
        list = createList(list, N, 1);
        return list.get(K - 1);
    }

    public List<Integer> createList(List<Integer> prevList, int N, int steps) {
        if (N == steps) {
            return prevList;
        }
        List<Integer> currList = new ArrayList<>();
        for (int i = 0; i < prevList.size(); i++) {
            if (prevList.get(i) == 0) {
                currList.add(0);
                currList.add(1);
            } else {
                currList.add(1);
                currList.add(0);
            }
        }

        prevList = createList(currList, N, ++steps);
        return prevList;
    }


}
