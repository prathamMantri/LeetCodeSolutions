package codility.pepod_digital_lab;

public class Task1 {

    public void solution() {
        // write your code in Java SE 8


        for (int j = 1; j < 100; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < j; i++) {

                if (i % 2 == 0) {
                    sb.append("+");
                } else {
                    sb.append("-");
                }
            }
            System.out.println(sb.toString());
        }

    }

}
