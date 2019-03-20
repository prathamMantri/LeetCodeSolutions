package easy;

public class Solution7 {
    public int reverse(int x) {
        if(x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE){
            return 0;
        }
        String reverse = "";
        int sum = 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);
        if(x<10){
            return  isNegative ? x*(-1) : x;
        }

        while(true){
            if(x<10){
                reverse = reverse + String.valueOf(x);
                break;
            }
            reverse = reverse + String.valueOf(x%10);
            x = x/10;
        }
        try{
            int reverseInt = Integer.parseInt(reverse);
            return  isNegative ? reverseInt*(-1) : reverseInt;
        }catch(NumberFormatException ex){
            return 0;
        }
    }
    public static void main(String[] args){
        Solution7 sol = new Solution7();
        System.out.println(sol.reverse(-2147483648));
    }
}