package mockinterviews;

public class MockWithRoshan {

    public static void main(String[] args) {

        MockWithRoshan mock = new MockWithRoshan();
        System.out.println(mock.stringRemove("jaw aijkl jawjaw jawijkl jaw a jaw", "jaw"));


    }

    String stringRemove(String s1, String s2) {

        if (s1.length() == s2.length()) {

            if (s1.equals(s2)) {
                return "";
            } else                    //s1= babajibabajai s2 = baba result = jijai
            {
                return s1;
            }
        }

        if (s1.length() < s2.length()) {

            return s1;
        }

        int start = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
            /*int removeStartLocation = 0;
            int removeEndLocation = s2.length()-1; */
        for (int i = 0; i < s1.length() - 1; i++) {
            if (s1.charAt(i) == s2.charAt(start)) {
                sb1.append(s1.charAt(i));
                while (true) {
                    if (s1.charAt(i + 1) == s2.charAt(start + 1)) {
                        sb1.append(s1.charAt(i));
                        start++;
                        i++;
                    } else {
                        sb.append(sb1);
                        break;
                    }
                    if (start == s2.length() - 1) {
                        sb1 = new StringBuilder();
                        break;
                    }
                }
            } else {
                sb.append(s1.charAt(i));

                i = i - 1;
                start = 0;
            }
        }
        return sb.toString();
    }

}


