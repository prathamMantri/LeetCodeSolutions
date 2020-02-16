package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }
        for (int i = 1; i <= rowIndex; i++) {
            list = getList(list, i);
        }
        return list;
    }
    private List<Integer> getList(List<Integer> previousList, int number){
        List<Integer> currentList = new ArrayList<>();
        currentList.add(previousList.get(0));
        for(int i=1; i<number; i++){
            currentList.add(previousList.get(i-1) + previousList.get(i));
        }
        currentList.add(previousList.get(previousList.size()-1));
        return currentList;
    }

    public static void main(String... args){

        Solution119 solution119 = new Solution119();

        System.out.println(solution119.getRow(3).toString());


    }

}



