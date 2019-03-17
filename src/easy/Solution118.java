package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        lists.add(list);

        for(int i = 2; i<numRows+1; i++){
            list = getList(list, i);
            lists.add(list);
        }
        return lists;

    }

    private List<Integer> getList(List<Integer> previousList, int number){

        List<Integer> currentList = new ArrayList<>();

        currentList.add(previousList.get(0));

        for(int i=1; i<number-1; i++){
            currentList.add(previousList.get(i-1) + previousList.get(i));
        }

        currentList.add(previousList.get(previousList.size()-1));

        return currentList;
    }

    public static void main(String args[]){
        Solution118 sol = new Solution118();
        List<List<Integer>> lists = sol.generate(5);

        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }

}
