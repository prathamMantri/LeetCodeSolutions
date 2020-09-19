package mock_interviews;

import java.util.*;

public class MockTestQ1 {
/*
    Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

    Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



            Example:

    Input:
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    Output: "ball"
    Explanation:
            "hit" occurs 3 times, but it is a banned word.
            "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"),
    and that "hit" isn't the answer even though it occurs more because it is banned.


    Note:

            1 <= paragraph.length <= 1000.
            1 <= banned.length <= 100.
            1 <= banned[i].length <= 10.
    The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
    paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
    There are no hyphens or hyphenated words.
    Words only consist of letters, never apostrophes or other punctuation symbols.*/



    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> map = new HashMap<>();
        List<String> bannedList = new ArrayList<>();

        for(int i=0; i<banned.length; i++){
            bannedList.add(banned[i]);
        }

        String[] words = paragraph.split(" ");

        for(int i=0; i<words.length;i++){

            if(words[i].contains(",")||words[i].contains(".")||
                    words[i].contains("?")||words[i].contains(";")||
                    words[i].contains("!")||words[i].contains("/'")){

                words[i] = words[i].replace(words[i].substring(words[i].length() - 1), "");
            }

            if(!bannedList.contains(words[i])){
                if(map.containsKey(words[i].toLowerCase())){
                    map.put(words[i].toLowerCase(), map.get(words[i].toLowerCase())+1);
                }else{
                    map.put(words[i].toLowerCase(), 1 );
                }
            }
        }
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue()==maxValueInMap) {
                return entry.getKey();
            }
        }
        return null;
    }
    public static void main(String[] args) {
        MockTestQ1 sol = new MockTestQ1();
        String[] arr = {"a"};
        System.out.println(sol.mostCommonWord("a, a, a, a, b,b,b,c, c"
                , arr));
    }
}

