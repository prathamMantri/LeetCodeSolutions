/*
package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution415 {

    public String addStrings(String num1, String num2) {
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        int total = 0;
        StringBuffer sb = new StringBuffer();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put('4', 4);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        int i=a.length-1;
        int j=b.length-1;
        while(i>=0 && j>=0){
            total = total +  map.get(num1.charAt(i) - '0') + map.get(num2.charAt(i)-'0');
            i++;
            j++;
        }
        while(i>=0){
            total = total +  map.get(a[i]);
            i++;
        }
        while(j>=0){
            total = total +  map.get(b[j]);
            j++;
        }
        System.out.print(total);
        return "";
    }

    public static void main(String args[]){

        Solution415 sol = new Solution415();
        sol.addStrings("1234", "123");


    }


}
*/
