package facebook_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class MatchingPairs {

    public static void main(String[] args) {

        MatchingPairs mp = new MatchingPairs();
        System.out.println(mp.matchingPairs("abcde", "adcbe"));

    }

    int matchingPairs(String s, String t) {
        // Write your code here

        List<Character> sList = new ArrayList<>();
        List<Character> tList = new ArrayList<>();

        int matchingPairs = 0;
        boolean pairMatched = false;

        for (int i = 0; i < s.length(); i++) {
            sList.add(i, s.charAt(i));
            tList.add(i, t.charAt(i));
        }

        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i) == tList.get(i))
                matchingPairs++;
            else {
                if (!pairMatched) {
                    char sChar = sList.get(i);
                    char tChar = tList.get(i);
                    if (tList.contains(sChar) && sList.contains(tChar)) {
                        if (sList.indexOf(tChar) == tList.indexOf(sChar)) {
                            matchingPairs = matchingPairs + 2;
                        } else {
                            matchingPairs++;
                        }
                        pairMatched = true;
                    }
                }
            }
        }
        return pairMatched ? matchingPairs : s.equals(t) ? 2 : 0;

    }

}
