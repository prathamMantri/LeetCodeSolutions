package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution8 {

    public int myAtoi(String str) {

        if(str.length()==0){
            return 0;
        }

        Map<Character, Integer> intMap = new HashMap<>();

        intMap.put('1', 1);
        intMap.put('2', 2);
        intMap.put('3', 3);
        intMap.put('4', 4);
        intMap.put('5', 5);
        intMap.put('6', 6);
        intMap.put('7', 7);
        intMap.put('8', 8);
        intMap.put('9', 9);
        intMap.put('0', 0);
        intMap.put('-',-1);

        String newString = str.trim();
        Integer sum = 0;

        for(int i=0, j=newString.length()-1; i<newString.length(); i++,j--){
            if(!intMap.containsKey(newString.charAt(i))){
                break;
            }
            else{
                if(intMap.get(newString.charAt(i))== -1){
                    continue;
                }
                sum = sum + (intMap.get(newString.charAt(i)) * (int)Math.pow(10,j));
            }

        }

        return newString.charAt(0)=='-'?sum*(-1):sum;
    }

    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        System.out.println(sol.myAtoi("      -987"));
    }

}
