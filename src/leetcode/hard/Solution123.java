package leetcode.hard;

public class Solution123 {
    public int maxProfit(int[] prices) {

        if(prices.length<2){
            return 0;
        }

        if(prices.length==2){
            return prices[1] - prices[0]> 0 ? prices[1] - prices[0] : 0 ;
        }

        int buy = prices[0];
        int sell = prices[1];
        int[] profit = new int[prices.length];
        int j=0;
        int profit1=0;
        int profit2=0;

        for(int i=1; i<prices.length; i++){
            if(buy>=prices[i]){
                buy = prices[i];
            }else{
                sell= prices[i];
                profit[j] = sell - buy;
                j++;
            }
        }

        for(int i=0; i<profit.length; i++){
            if (profit[i] > profit1)
            {
                profit2 = profit1;
                profit1= profit[i];
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (profit[i] > profit2)
                profit2 = profit[i];
        }
        return profit1+profit2;
    }

    public static void main(String[] args) {
        Solution123 sol = new Solution123();
        int[] prices = {1,2,3,4,5,6};
        System.out.println(sol.maxProfit(prices));
    }
}
