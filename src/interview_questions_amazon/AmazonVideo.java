package interview_questions_amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonVideo {
    public static void main(String[] args) {

        AmazonVideo amazonVideo = new AmazonVideo();
        List<Character> sequence = new ArrayList<>();

        sequence.add('a');
        sequence.add('b');
        sequence.add('a');
        sequence.add('b');
        sequence.add('c');
        sequence.add('b');
        sequence.add('a');
        sequence.add('c');
        sequence.add('a');
        sequence.add('d');
        sequence.add('e');
        sequence.add('f');
        sequence.add('e');
        sequence.add('g');
        sequence.add('d');
        sequence.add('e');
        sequence.add('h');
        sequence.add('i');
        sequence.add('j');
        sequence.add('h');
        sequence.add('k');
        sequence.add('l');
        sequence.add('i');
        sequence.add('j');


        System.out.println(amazonVideo.lengthEachScene(sequence).toString());


    }

    public List<Integer> lengthEachScene(List<Character> inputList) {
        List<Integer> result = new ArrayList<>();
        if (inputList == null || inputList.size() == 0) {
            return result;
        }
        Set<Character> appeared = new HashSet<>();

        int[] charArray = new int[26];
        for (char c : inputList)
            charArray[c - 'a']++;
        int count = 0;
        for (char c : inputList) {
            count++;
            appeared.add(c);
            if (--charArray[c - 'a'] == 0) {
                appeared.remove(c);
                if (appeared.isEmpty()) {
                    result.add(count);
                    count = 0;
                }
            }
        }
        return result;
    }


}
