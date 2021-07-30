package companies.interview_questions_microsoft.codility;

public class Question2 {

    /*  public int solution(int[] A) {
     *//*int count = 0;

        if(A.length < 2){
            return count;
        }

        int first = A[0];
        int second = A[1];
        int third = A[2];

        boolean isAlternate = true;

        for(int i=0; i<A.length-3; i++){

            if(first != second && second != third){

                if(first < second && second > third){
                    isAlternate = true;
                }else if (first > second && third > second){
                    isAlternate = true;
                }else{
                    if(!isAlternate) {
                        return -1;
                    }else {
                        isAlternate = false;
                        count++;
                    }
                }
            }else{
                isAlternate = false;
                count++;
            }
            first = A[i+1];
            second = A[i+2];
            third = A[i+3];

        }
        return count;*//*

    }*/

    public static void main(String[] args) {
        Question2 question2 = new Question2();
        int[] A = {3, 4, 5, 3, 7};
        System.out.println(question2.solution(A));
    }

    public int solution(int[] A) {
        boolean result = isAesthetic(A, -1);
        if (result) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            result = isAesthetic(A, i);
            if (result) {
                count++;
            }
        }
        return count > 0 ? count : -1;
    }

    public boolean isAesthetic(int[] A, int pos) {
        int current;
        int nextPos;
        if (pos != 0) {
            current = A[0];
            nextPos = 1;
        } else {
            current = A[1];
            nextPos = 2;
        }
        boolean flag = false;
        boolean flagSet = false;
        for (; nextPos < A.length; nextPos++) {
            int next = A[nextPos];
            if (nextPos == pos) {
                continue;
            }
            if (!flagSet) {
                if (next == current) {
                    return false;
                } else flag = next > current;
                current = next;
                flagSet = true;
                continue;
            }
            if (flag) {
                if (next < current) {
                    flag = false;
                    current = next;
                } else {
                    return false;
                }
            } else {
                if (next > current) {
                    flag = true;
                    current = next;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}
