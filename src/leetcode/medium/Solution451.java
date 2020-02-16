package leetcode.medium;

import java.util.*;

public class Solution451 {


    /*
    * Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
*/


    public String frequencySort(String s) {

        char[] sChar = s.toCharArray();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();

        Map<Character, Integer> charMap = new HashMap<>();

        for(int i=0; i<sChar.length; i++) {

            if (charMap.containsKey(sChar[i])) {
                count = charMap.get(sChar[i]);
                charMap.put(sChar[i], count + 1);
            } else {
                charMap.put(sChar[i], 1);
            }
        }

        List<Map.Entry<Character, Integer> > list =
                new LinkedList<>(charMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });


        HashMap<Character, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        Set<Character> chars = temp.keySet();

            for(Character character : chars){
                for(int i=0; i< temp.get(character); i++){
                    stringBuilder = stringBuilder.append(character);
                }
            }

            System.out.println(stringBuilder.reverse().toString());

            return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {

        Solution451 sol = new Solution451();
        sol.frequencySort("raaeaedere");

    }

}
