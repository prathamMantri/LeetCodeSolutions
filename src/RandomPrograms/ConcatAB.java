package RandomPrograms;

public class ConcatAB {

    public String solution(int a, int b) {

        StringBuilder sb = new StringBuilder();
        if (a > b) {
            sb = concatab(a, b, 'a', 'b');
        } else if (a == b) {
            for (int i = 0; i < a; i++) {
                sb.append("ab");
            }
        } else if (a < b) {
            sb = concatab(b, a, 'b', 'a');
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public StringBuilder concatab(int A, int B, char a, char b) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int count = 0;
        int countOfB = B;
        int countOfA = A;
        for (int i = 0; i <= A + B; i++) {
            if (count < 2 && countOfA != 0) {

                sb.append(a);
                countOfA--;
                count++;
            } else if (countOfB != 0) {
            count = 0;
            sb.append(b);
            countOfB--;

        }

        if (count == 2 && countOfB == 0) {
            sb = temp.append(a).append(a).append(sb);
        }
    }
        return sb;
}

}

class ConcatABTest {
    public static void main(String[] args) {
        ConcatAB concatAB = new ConcatAB();
        concatAB.solution(8, 9);
    }
}