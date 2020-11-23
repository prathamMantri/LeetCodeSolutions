package leetcode.medium;

public class Solution739 {
    /*
   public int[] dailyTemperatures(int[] T) {

       Stack<Integer> st = new Stack<>();
       int[] res = new int[T.length];

       st.push(T.length - 1);
       res[T.length - 1] = 0;

       for(int i=T.length-2; i>=0; i--){
           int count = 0;
           while(!st.isEmpty() && T[i] >= T[st.peek()]){
               st.pop();
           }
           res[i] = st.isEmpty() ? 0 : st.peek() - i;
           st.push(i);
       }
       return res;
   }
   */
    public int[] dailyTemperatures(int[] T) {
        final int[] result = new int[T.length];
        for (int current = result.length - 1; current >= 0; current--) {
            int next = current + 1;
            while (next < result.length) {
                if (T[next] > T[current]) {
                    result[current] = next - current;
                    break;
                } else if (result[next] == 0) {
                    break;
                } else {
                    next += result[next];
                }
            }
        }
        return result;
    }
}
