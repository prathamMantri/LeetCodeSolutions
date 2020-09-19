package random_programs;

import java.util.ArrayList;

public class AddOneToArray {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        Integer carry = 1;
        Integer size = A.size();
        Integer count=0;
        Integer sum=0;
        Integer i=0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(i<A.size()){
            if(A.get(i)==0){
                count++;
                i++;
            }else{
                break;
            }
        }

        if(size == count){
            result.add(1);
        }else{
            i=0;
            for(i=size; i>=count;i--){
                sum = A.get(i) + carry;
                if(sum==10){
                    if(i==count){
                        list.add(1);
                        list.add(0);
                        break;
                    }else{
                        list.add(0);
                        carry =1;
                    }
                }else{
                    list.add(sum);
                    carry=0;
                }
            }
            for(i=list.size()-1; i>=0; i--)
                result.add(list.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        AddOneToArray a = new AddOneToArray();
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(0);
        System.out.println(a.plusOne(ar));
    }

}
