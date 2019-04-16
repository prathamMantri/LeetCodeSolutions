package hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'sortDates' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY dates as parameter.
     */

    public static List<String> sortDates(List<String> dates) {
        // Write your code here

        List<String> sortedDates = new ArrayList<>();
        List<ActualDate> actualDates = new ArrayList<>();

        for(String date: dates){
            String[] dateArray = date.trim().split(" ");
            actualDates.add(new ActualDate(Integer.parseInt(dateArray[0]), dateArray[1], Integer.parseInt(dateArray[2])));
        }


        return sortedDates;

    }

}
 class ActualDate{

    int day;
    String months;
    int year;

    public ActualDate(int day, String months, int year){
        this.day= day;
        this.months = months;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public String getMonths() {
        return this.months;
    }

    public int getYear() {
        return this.year;
    }
}




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int datesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dates = IntStream.range(0, datesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.sortDates(dates);

        bufferedWriter.write(
                result.stream()
                        .collect(joining(" \n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}