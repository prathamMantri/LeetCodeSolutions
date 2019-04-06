package RandomPrograms;

import java.util.HashMap;
import java.util.Map;

public class FindMaxAccuranceArray {

    int findMaxAccurance(int[] a){
        int max = 1;
        Integer result=null;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<a.length; i++){
            if(count.containsKey(a[i])){
                count.put(a[i], count.get(a[i])+1);
                if(max<count.get(a[i])) {
                    max = count.get(a[i]);
                    result = a[i];
                }
            }else{
                count.put(a[i],1);
                if(max<count.get(a[i])) {
                    max = count.get(a[i]);
                    result = a[i];
                }
            }
        }
        return result.intValue();
    }

    public static void main(String args[]){

        int[] array = {1,2,1,3,1,4,1,5,1,6,4,4,4,4};

        FindMaxAccuranceArray findMaxAccuranceArray = new FindMaxAccuranceArray();
        System.out.println(findMaxAccuranceArray.findMaxAccurance(array));
    }

}
