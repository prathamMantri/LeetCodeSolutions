package stringRelated;

public class MinimumWindow {

    public String minimumWindow(String s, String t) {

        //Define map or array
        int[] map = new int[128];
        // Increment with t chars
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        // Define required variables
        int start = 0; // start of scanning/ window/left
        int end = 0; // window right side/end, which will eventually get expanded.
        int minStart = 0; //
        int minLength = Integer.MAX_VALUE; // Initialize with MAX value as we have to find minimum window.
        int counter = t.length(); // counter to check whether, all chars in t are counted in window.

        while (end < s.length()) {
            char c1 = s.charAt(end);

            if (map[c1] > 0)
                counter--; // if value is greater than 1, meaning its presence in t, decrement its count and counter too
            map[c1]--;
            end++; // expand the right counter

            //if counter becomes 0;
            while (counter == 0) {
                if (minLength > end - start) {
                    minLength = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}
