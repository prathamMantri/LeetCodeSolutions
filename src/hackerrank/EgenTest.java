package hackerrank;

class AirPlane {


}

public class EgenTest {
    public static String dnaComplement(String s) {
        // Write your code here

        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        char[] symbols = s.toCharArray();
        int i = symbols.length - 1;
        while (i >= 0) {
            char symbol = symbols[i];
            switch (symbol) {
                case 'A':
                    sb.append('T');
                    break;
                case 'T':
                    sb.append('A');
                    break;
                case 'C':
                    sb.append('G');
                    break;
                case 'G':
                    sb.append('C');
                    break;
                default:
                    break;
            }
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EgenTest eg = new EgenTest();
        System.out.println(dnaComplement("ACCGGGTTTT"));

    }

}
