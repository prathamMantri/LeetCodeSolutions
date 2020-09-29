package codility.pepod_digital_lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {

    public String solution(String S) {

        String[] lines = S.split("\n");

        if (lines.length == 1) {
            return S;
        }

        String[] headers = lines[0].split(",");
        List<String> columns;
        List<List<String>> rows = new ArrayList<>();


        for (int i = 1; i < lines.length; i++) {
            columns = Arrays.asList(lines[i].split(","));
            if (!columns.contains("NULL")) {
                rows.add(columns);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String header : headers) {
            sb.append(header).append(",");
        }
        if (rows.size() > 0) {
            sb.replace(sb.length() - 1, sb.length(), "\n");
            for (List<String> row : rows) {
                for (String column : row) {
                    sb.append(column).append(",");
                }
                sb.replace(sb.length() - 1, sb.length(), "\n");
            }
        }

        return sb.toString();
    }

}
