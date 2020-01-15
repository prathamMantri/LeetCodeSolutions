package leetCode.medium;

import java.util.HashMap;

public class Solution12 {

    public static void main(String[] args) {


        Solution12 solution12 = new Solution12();
        solution12.intToRoman(3508);


    }

    public String intToRoman(int num) {
        HashMap<Integer, String> romanMap = new HashMap<>();

        StringBuilder result = new StringBuilder();

        romanMap.put(1, "I");
       /* romanMap.put(2, "II");
        romanMap.put(3, "III");*/
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
       /* romanMap.put(6, "VI");
        romanMap.put(7, "VII");
        romanMap.put(8, "VIII");*/
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        char[] numInChar = Integer.toString(num).toCharArray();
        int pow = numInChar.length - 1;
        for (int i = 0; i < numInChar.length; i++) {
            int place = Character.getNumericValue(numInChar[i]) * (int) Math.pow(10, pow);
            String output = romanMap.get(place);
            if (null == output) {

                int count = Character.getNumericValue(numInChar[i]);

                if (count > 5) {
                    result.append(romanMap.get(5 * (int) Math.pow(10, pow)));
                    count = count - 5;
                }
                for (int j = 0; j < count; j++) {
                    result.append(romanMap.get((int) Math.pow(10, pow)));
                }
            } else {
                result.append(romanMap.get(place));
            }
            pow--;
        }
        System.out.println(result);
        return result.toString();
    }


}
