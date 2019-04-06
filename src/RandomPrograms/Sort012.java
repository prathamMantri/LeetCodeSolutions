package RandomPrograms;

import java.util.HashMap;
import java.util.Map;


///////WRONGGGGGGG
public class Sort012 {

    int[] sort(int[] a) {
        int i0, j1, k2;
        int[] result = new int[a.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {

            if(map.containsKey(a[i])) {
                map.put(a[i],map.get(a[i])+1);
            }else{
                map.put(a[i], 1);
            }
        }
        for(Map.Entry<Integer,Integer> i : map.entrySet()){
            for(int j=i.getValue()+1; j<i.getValue();j++){
                result[j-1] = i.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args){
        Sort012 sort012 = new Sort012();

        System.out.println(sort012.sort(new int[]{1,2,0}));
    }
}
