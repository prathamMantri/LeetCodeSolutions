package leetCode.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution390 {
    public int lastRemaining(int n) {

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int number=0;
        for(int i=n; i>0; i--){
            st1.push(i);
        }
        boolean flag;
        while(true){
           flag=false;
            while(!st1.isEmpty()){
                number = st1.pop();
                if(flag)
                    st2.push(number);
                flag=!flag;
            }
            if((st1.size()==1 && st2.isEmpty())||(st2.size()==1 && st1.isEmpty())){
                break;
            }
            flag=false;
            while(!st2.isEmpty()){
                number = st2.pop();
                if(flag)
                    st1.push(number);
                flag=!flag;
            }
            if((st1.size()==1 && st2.isEmpty())||(st2.size()==1 && st1.isEmpty())){
                break;
            }
        }
        return number;
    }

    public static void main(String... args){

        Solution390 solution390 = new Solution390();

        System.out.println(solution390.lastRemaining(15));


    }

}
