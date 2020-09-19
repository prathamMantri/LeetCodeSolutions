package interview_questions_microsoft;

public class MakeMove {
    public static void main(String[] args) {
        MakeMove sol = new MakeMove();
        System.out.println(sol.solution("11110100001001000000"));
    }

    int solution(String S) {
        //Write your code in Java SE 8
        //Converting binary number to Integer using parseInt funtion and passing 2 for binary
        int number = Integer.parseInt(S, 2);
        return makeMove(number, 0);
    }

    int makeMove(int number, int steps) {
        if (number == 0) {
            return steps;
        } else if (number % 2 == 0) {
            return makeMove(number / 2, ++steps);
        } else {
            return makeMove(--number, ++steps);
        }
    }
}
