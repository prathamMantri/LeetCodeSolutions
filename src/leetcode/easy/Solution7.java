package leetcode.easy;

import java.util.ArrayList;

public class Solution7 {
    /*public int reverse(int x) {
        if(x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE){
            return 0;
        }
        String reverse = "";
        int sum = 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);
        if(x<10){
            return  isNegative ? x*(-1) : x;
        }

        while(true){
            if(x<10){
                reverse = reverse + x;
                break;
            }
            reverse = reverse + x % 10;
            x = x/10;
        }
        try{
            int reverseInt = Integer.parseInt(reverse);
            return  isNegative ? reverseInt*(-1) : reverseInt;
        }catch(NumberFormatException ex){
            return 0;
        }
    }*/


    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        System.out.println(sol.reverse(1563847412));
    }

    public int reverse(int x) {

        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int power = list.size();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Double pow = sum + Math.pow(10, --power) * list.get(i);
            if (pow >= Integer.MAX_VALUE) {
                return 0;
            } else if (pow <= Integer.MIN_VALUE) {
                return 0;
            } else {
                sum = sum + (int) (Math.pow(10, power)) * list.get(i);
            }
        }
        return sum;
    }
}
