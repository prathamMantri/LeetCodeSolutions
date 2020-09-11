package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution299 {
    public String getHint(String secret, String guess) {
        if (secret.length() == 0 && guess.length() == 0)
            return "0A0B";
        int bulls = 0;
        int cows = 0;
        List<Character> secretList = new ArrayList<>();
        int i = 0;
        while (i < secret.length()) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                Character key = secret.charAt(i);
                secretList.add(key);
            }
            i++;
        }
        i = 0;
        while (i < guess.length()) {
            if (secretList.contains(guess.charAt(i)) && secret.charAt(i) != guess.charAt(i)) {
                cows++;
                secretList.remove((Character) guess.charAt(i));
            }
            i++;
        }
        return bulls + "A" + cows + "B";
    }
}
