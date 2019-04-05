package leetCode.easy;

public class Solution50{

    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
        double product = x;

        for(int i=1; i<Math.abs(n); i++){
            product = product*x ;
        }
        return n<0?(1/product):product;
    }

    public static void main(String[] args){
        Solution50 sol = new Solution50();
        System.out.println(sol.myPow(0.00001,
                2147483647));
    }

}
