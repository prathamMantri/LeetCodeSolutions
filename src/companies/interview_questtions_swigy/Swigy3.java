package companies.interview_questtions_swigy;

public class Swigy3 {

    public static void main(String[] args) {

        Swigy3 sw = new Swigy3();
        int[] pickup = {0, 2, 9, 10, 11, 12};
        int[] dropOff = {5, 9, 11, 11, 14, 7};
        int[] tip = {1, 2, 3, 2, 2, 1};
        System.out.println(sw.maxProfit(pickup, dropOff, tip));
    }

    public int maxProfit(int[] pickup, int[] dropOff, int[] tip) {

        int[] mem = new int[pickup.length];
        if (pickup.length > 1) {

            for (int x = 0; x < pickup.length - 1; x++) {
                int currentProfit = dropOff[x] - pickup[x] + tip[x];
                mem[x] = currentProfit;
                if (pickup[x + 1] < dropOff[x])
                    mem[x + 1] = Math.max(currentProfit, dropOff[x + 1] - pickup[x + 1] + tip[x + 1]);
                else
                    mem[x] = Math.max(currentProfit, dropOff[x] - pickup[x] + tip[x]);
            }
        }

        //  int sum =
        return 0;
    }

}
