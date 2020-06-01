package leetcode.easy;

public class Solution461 {
/*

    int hammingDistance(int x, int y){
        String xByte = Integer.toBinaryString(x);
        String yByte = Integer.toBinaryString(y);
        String min = xByte.length() <= yByte.length() ? xByte : yByte;
        String max = xByte.length() > yByte.length() ? xByte : yByte;
        return calcDistance(min, max, max.length() - min.length());
    }

    int calcDistance(String min, String max, int diff){

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<diff; i++){
            sb.append(0);
        }
        min = sb.append(min).toString();

        int count = 0;

        for(int i=0; i<max.length(); i++){
            if(min.charAt(i) != max.charAt(i))
                count++;
        }

        return count;

    }
*/

    public static void main(String[] args) {
        Solution461 sol = new Solution461();
        System.out.println((sol.hammingDistance(0, 1)));
    }

    int hammingDistance(int x, int y) {
        int xor = x ^ y;
        String s = Integer.toBinaryString(xor);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }
        return count;
    }

}
