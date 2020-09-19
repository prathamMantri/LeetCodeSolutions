package random_programs;

public class Bulb {

    public int solution(int[] bulbs) {

        int count = 0;
        boolean[] turnedOn = new boolean[bulbs.length];
        boolean[] shine = new boolean[bulbs.length];

        for (int i = 0; i < bulbs.length; i++) {
            turnedOn[i] = true;
            if (bulbs[i] <= i+1) {
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args){
        Bulb bulb = new Bulb();
        int[] bulbs = {5,4,3,2,1};
        bulb.solution(bulbs);
    }
}
