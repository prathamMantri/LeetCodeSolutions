package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        if (n == 1) {
            list.add(0);
            list.add(1);
            return list;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        findGrayCode(list, sb.toString(), 0);
        return list;
    }

    void findGrayCode(List<Integer> list, String input, int index) {
        if (index >= input.length() - 1 || index < 0) {
            list.add(Integer.parseInt(input, 2));
            return;
        }
        StringBuilder nextGrayCode = new StringBuilder(input);
        nextGrayCode.setCharAt(index, input.charAt(index) == '0' ? '1' : '0');
        findGrayCode(list, nextGrayCode.toString(), index + 1);
        --index;
    }
}
