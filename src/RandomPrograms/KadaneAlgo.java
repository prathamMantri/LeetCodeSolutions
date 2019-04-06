package RandomPrograms;

public class KadaneAlgo {

    int getMaxSubArrya(int[] arr){

        int currMax = arr[0];
        int getMax = arr[0];
        //int[] arr = {1,2,3,-5, -7,5, 8, 9};
        for(int i=1; i<arr.length; i++){
            currMax = getMaxInt(arr[i], currMax+arr[i]);
            getMax = getMaxInt(getMax,currMax);
        }
        return getMax;
    }

    int getMaxInt(int i, int j){
        if (i>j){
            return i;
        }else{
            return j;
        }
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,-5, -7,5, 8, 9};
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        System.out.println(kadaneAlgo.getMaxSubArrya(arr));

    }

}
