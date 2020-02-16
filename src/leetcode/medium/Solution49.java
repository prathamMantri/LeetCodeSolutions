package leetcode.medium;

import java.util.*;

public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<strs.length; i++){
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            List<String> indexList = anagramMap.get(String.valueOf(sorted));
            if(anagramMap.containsKey(String.valueOf(sorted))){
                indexList.add(strs[i]);
            }else{
                anagramMap.put(String.valueOf(sorted), indexList = new ArrayList<>());
                indexList.add(strs[i]);
            }
        }

        for(Map.Entry<String, List<String>> entry: anagramMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String... args){
        Solution49 sol = new Solution49();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        sol.groupAnagrams(input);
    }

}
