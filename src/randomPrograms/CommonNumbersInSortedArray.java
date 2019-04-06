package randomPrograms;

public class CommonNumbersInSortedArray {

    int[] commonNumberInSortedarray(int[] a, int[] b){

        int i=0, j=0, count=0;
        int[] result = new int[a.length>b.length?b.length:a.length];
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                result[count] = a[i];
                i++;
                j++;
            }else if(a[i]>b[j]){
                j++;
            }else{
                i++;
            }
        }
        return result;
    }

}
