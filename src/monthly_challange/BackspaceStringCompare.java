package monthly_challange;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        StringBuilder sout = new StringBuilder();
        StringBuilder tout = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '#' && count == 0) {
                sout.append(s.charAt(i));
            } else if (s.charAt(i) == '#') {
                count++;
            } else {
                count--;
            }
        }

        count = 0;

        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.charAt(i) != '#' && count == 0) {
                tout.append(t.charAt(i));
            } else if (t.charAt(i) == '#') {
                count++;
            } else {
                count--;
            }
        }
        return sout.toString().equals(tout.toString());
    }
}
