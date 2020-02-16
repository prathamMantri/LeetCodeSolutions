package randomprograms;

public class OneAwayString {

    boolean oneAwayString(String s1, String s2){

        if(s1==null && s2.length()==1) return true;
        if(s2==null && s1.length()==1) return true;
        if(s1.equals(s2)) return false;
        if(Math.abs(s1.length()-s2.length())>1) return false;
        if(Math.abs(s1.length()-s2.length())>0) return checkAddCount(s1, s2);
        if(s1.length() == s2.length()) return checkReplaceCount(s1, s2);
        return false;
    }

    boolean checkAddCount(String s1, String s2){

        int minLength = s1.length()<s2.length()? s1.length(): s2.length();
        char[] sChar1 = s1.toCharArray();
        char[] sChar2 = s2.toCharArray();
        for(int i=0; i<minLength; i++){
            if(sChar1[i] != sChar2[i]){
                return false;
            }
        }
        return true;
    }

    boolean checkReplaceCount(String s1, String s2){
        char[] sChar1 = s1.toCharArray();
        char[] sChar2 = s2.toCharArray();
        int count = 0;
        for(int i=0; i<sChar1.length; i++){
            if(sChar1[i] != sChar2[i]){
                count++;
                if(count>1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneAwayString oneAwayString = new OneAwayString();

        System.out.println(oneAwayString.oneAwayString("",""));
    }

}
