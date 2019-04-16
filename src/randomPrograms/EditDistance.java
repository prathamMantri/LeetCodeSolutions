package randomPrograms;

import java.util.HashMap;

public class EditDistance {

    String A = "Anshuman";
    String B = "Antihuman";

    public int minDistance(String A, String B) {
        int count = 0;
        if(A.length() == B.length()){
            count = countReplace(A, B, count, false);
        }

        if(A.length() != B.length()){
            count = Math.abs(A.length() - B.length());
            count = countReplace(A, B, count, true);
        }
        return count;
    }

    public int countReplace(String A, String B, int count, boolean otherOp){
        if(!otherOp) {
            int i = 0;
            int j = 0;
            while (i < A.length() && j < B.length()) {
                if (A.charAt(i) == B.charAt(j)) {
                    i++;
                    j++;
                } else {
                    count++;
                    i++;
                    j++;
                }
            }
        }else{
            HashMap<Character, Integer> map = new HashMap<>();
            for(int k=0;k<B.length(); k++){
                if(map.containsKey(B.charAt(k))){
                    map.put(B.charAt(k), map.get(B.charAt(k))+1);
                }else{
                    map.put(B.charAt(k),1);
                }
            }

            int k=0, l=0;
            while(k<A.length() && l<B.length()){
                if(A.charAt(k) == B.charAt(l)){
                    map.put(A.charAt(k), map.get(A.charAt(k))-1);
                    k++;
                    l++;
                }else{
                    if(!(map.get(A.charAt(k))>0)){
                        count++;
                        l++;
                        k++;
                        map.put(A.charAt(k), map.get(A.charAt(k))-1);
                    }else{
                        count++;
                    }
                }
            }
        }

        return count;

    }

}