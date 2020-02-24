package leetcode.easy;

public class Solution38 {
    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(6));
    }

    public String countAndSay(int n) {
        String res = "1";
        if (n == 1) {
            return res;
        }
        return countAndSay(n, 2, "11");
    }

    public String countAndSay(int n, int index, String res) {
        StringBuilder newRes = new StringBuilder();
        if (index == n) {
            return res;
        }
        int count = 1, i = 0;
        while (i < res.length() - 1) {
            if (res.charAt(i) == res.charAt(i + 1)) {
                i++;
                count++;
            } else {
                newRes.append(count == 0 ? "" : count).append(res.charAt(i));
                i++;
                count = 1;
            }
            if (i == res.length() - 1) {
                newRes.append(count == 0 ? "" : count).append(res.charAt(i));
            }

        }
        return countAndSay(n, ++index, newRes.toString());
    }
}
