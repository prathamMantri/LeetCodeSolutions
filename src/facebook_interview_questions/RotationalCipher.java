package facebook_interview_questions;

import java.util.ArrayList;
import java.util.List;

public class RotationalCipher {
    public static void main(String[] args) {

        String s = "All-convoYs-9-be:Alert1.";
        RotationalCipher rc = new RotationalCipher();
        System.out.println(rc.rotationalCipher(s, 4));


    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here

        if (rotationFactor == 0) {
            return input;
        }

        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();
        List<Character> number = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            lower.add(i, (char) (i + 97));
        }


        for (int i = 0; i < 26; i++) {
            upper.add(i, (char) (i + 65));
        }

        for (int i = 0; i < 10; i++) {
            number.add(i, (char) (i + 48));
        }

        int index, changedIndex;

        for (char ch : input.toCharArray()) {

            char change;

            if (lower.contains(ch)) {
                index = lower.indexOf(ch);
                changedIndex = index + (rotationFactor > 26 ? rotationFactor % 26 : rotationFactor);
                change = lower.get(changedIndex > 26 ? changedIndex % 26 : changedIndex);
                sb.append(change);
            } else if (upper.contains(ch)) {
                index = upper.indexOf(ch);
                changedIndex = index + (rotationFactor > 26 ? rotationFactor % 26 : rotationFactor);
                change = upper.get(changedIndex > 26 ? changedIndex % 26 : changedIndex);
                sb.append(change);
            } else if (number.contains(ch)) {
                index = number.indexOf(ch);
                changedIndex = index + (rotationFactor > 10 ? rotationFactor % 10 : rotationFactor);
                change = number.get(changedIndex > 10 ? changedIndex % 10 : changedIndex);
                sb.append(change);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();


    }
}
