package leetCode.hard;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution297 {


    public TreeNode deserialize(String data) {

        if (data.equals('*')) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        int i = 0, j = 0;
        String[] arr = data.split(",");

       int p = arr.length;

        return null;
    }

    public static void main(String[] args) {
        Solution297 sol = new Solution297();
        System.out.println(sol.deserialize("1,2,3,*,*,4,5"));
    }


}
