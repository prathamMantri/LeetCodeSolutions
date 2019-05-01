package leetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution9 {
    public boolean isPalindrome(int x) {
        int y = x;
        if(y<0){
            return false;
        }if(y<10){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        while(y>10){
            int rem = y%10;
            y = y/10;
            queue.offer(rem);
        }
        queue.offer(y);
        int size = queue.size();
        double ten = 10.0;
        int num = 0;
        while(!queue.isEmpty()){
            num = num + (int)Math.pow(10, --size)*queue.poll();

        }
        return num==x;
    }

    public static void main(String... args){
        Solution9 sol = new Solution9();
        System.out.println(sol.isPalindrome(020));
    }
}
