package stringRelated;

public class KMPPatternMatching {

    public int[] getKMPTable(String s) {
        int[] kmpTable = new int[s.length()];
        int index = 0;
        for (int i = 1; i < s.length(); ) {
            if (s.charAt(index) == s.charAt(i)) {
                kmpTable[i] = ++index;
                i += 1;
            } else {
                if (index > 0) {
                    index = kmpTable[index - 1];
                } else {
                    index = 0;
                    i += 1;
                }
            }
        }
        return kmpTable;
    }


}
