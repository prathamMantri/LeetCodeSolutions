package leetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        lists.add(list);

        if(rowIndex == 0){
            return lists.get(rowIndex);
        }

        for(int i = 1; i<rowIndex+1; i++){
            list = getList(list, i);
            lists.add(list);
        }
        return lists.get(rowIndex);
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



