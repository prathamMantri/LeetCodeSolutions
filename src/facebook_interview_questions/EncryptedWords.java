package facebook_interview_questions;

public class EncryptedWords {

/*    String findEncryptedWord(String s){


        if(s.length()==1){
            return s;
        }

        StringBuffer sb = new StringBuffer();

        String left = s.substring(0, s.length()/2);
        String right = s.substring((s.length()/2)+1);

        sb
                .append(s.charAt(s.length()/2))
                .append(findEncryptedWord(left,sb))
                .append(findEncryptedWord(right,sb));
        return sb.toString();
    }*/

    public static void main(String[] args) {

        EncryptedWords encryptedWords = new EncryptedWords();
        System.out.println(encryptedWords.findEncryptedWord("facebook"));

    }

    String findEncryptedWord(String s) {
        if (s.length() < 2) {
            return s;
        }
        int middleIndex = s.length() % 2 == 0 ? (s.length() / 2) - 1 : s.length() / 2;
        StringBuilder sb = new StringBuilder();
        sb
                .append(s.charAt(middleIndex))
                .append(findEncryptedWord(s.substring(0, middleIndex)))
                .append(findEncryptedWord(s.substring((middleIndex + 1))));
        return sb.toString();
    }

}
