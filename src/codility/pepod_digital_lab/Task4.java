package codility.pepod_digital_lab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task4 {
    public String solution(String S) {

        try {
            String[] files = S.split("\n");
            List<String> backUpFiles = new ArrayList<>();

            for (String file : files) {

                String[] columns = file.trim().split(" ");
                String size = columns[0].trim();
                String dateInString = columns[1].trim();
                String filenameWithExtension = columns[2].trim();
                String[] fullFilename = filenameWithExtension.split("\\.");
                String fileName = fullFilename[0];

                char tilde = filenameWithExtension.charAt(filenameWithExtension.length() - 1);
                String byteSize = "";
                Integer byteNumber;
                boolean isMoreThanByte = Character.isLetter(size.charAt(size.length() - 1));
                if (isMoreThanByte) {
                    byteNumber = Integer.parseInt(size.substring(0, size.length() - 1));
                    byteSize = size.charAt(size.length() - 1) + "";
                } else {
                    byteNumber = Integer.parseInt(size);
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

                Date date = dateFormat.parse(dateInString);
                boolean isDateLater = date.after(dateFormat.parse("1990-01-30"));

                if (tilde == '~' && isDateLater) {
                    if (!isMoreThanByte) {
                        backUpFiles.add(fileName);
                    } else {
                        if (byteSize.equals("K")) {
                            backUpFiles.add(fileName);
                        } else if (byteSize.equals("M") && byteNumber <= 14) {
                            backUpFiles.add(fileName);
                        }
                    }
                }
            }
            int max = Integer.MAX_VALUE;

            for (String file : backUpFiles) {
                if (max > file.length()) {
                    max = file.length();
                }
            }

            return backUpFiles.size() > 0 ? max + "" : "NO FILES";
        } catch (ParseException e) {
            e.printStackTrace();

            return "NO FILES";
        }
    }
}
