package leetcode.medium;

import java.util.Arrays;

public class Solution869 {
    public boolean reorderedPowerOf2(int N) {
  /*      Set<String> set = new HashSet<>();
        for(int i=1; i< 1e+9 ; i=i*2)
            set.add(sort(i));

        for(String sort: set){
            System.out.print(sort + " ");
        }

        return set.contains(sort(N));
        */
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);

        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf(1 << i).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2)) return true;
        }

        return false;
    }

    private String sort(int N) {

        int[] sorted = new int[10];
        String s = String.valueOf(N);

        for (char c : s.toCharArray()) {
            sorted[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sorted.length; i++)
            if (sorted[i] != 0)
                for (int j = 0; j < sorted[i]; j++)
                    sb.append(i);

        return sb.toString();

    }
}
