package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountingPairs {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY numbers
     *  2. INTEGER k
     */


    public static int countPairs(List<Integer> numbers, int k) {
        // Write your code here

     /*   HashSet<Integer> numSet = new HashSet<Integer>();
        int count = 0;
        for(int num : numbers){
            numSet.add(num);
        }
        for(Integer num : numSet){
            if(numbers.contains(num-k)){
                count++;
            }
        }
        return count;
*/


        //  Map<Integer, Integer> numberMap = new HashMap<>();
        HashMap<Integer, Integer> numMap = new HashMap<>();
        HashSet<Integer> res = new HashSet<>();

        for (Integer number : numbers) {
            int numberPair = number - k;
            if (numMap.containsKey(numberPair)) {
                res.add(number);
            }
            numMap.put(number, k - number);
        }
        return res.size();
    }

    public static void main(String[] args) {

        CountingPairs countingPairs = new CountingPairs();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);

        countPairs(list, 1);

    }

    static class NumberPair {
        Integer a;
        Integer b;

        public NumberPair(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }
    }


}
