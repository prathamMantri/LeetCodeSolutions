package leetcode.hard;

public class Solution273 {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        return helper(num, tens, ones).trim();

    }

    private String helper(int num, String[] tens, String[] ones) {

        if (num >= 1000000000)
            return (helper(num / 1000000000, tens, ones) + " Billion " + helper(num % 1000000000, tens, ones)).trim();
        if (num >= 1000000)
            return (helper(num / 1000000, tens, ones) + " Million " + helper(num % 1000000, tens, ones)).trim();
        if (num >= 1000) return (helper(num / 1000, tens, ones) + " Thousand " + helper(num % 1000, tens, ones)).trim();
        if (num >= 100) return (helper(num / 100, tens, ones) + " Hundred " + helper(num % 100, tens, ones)).trim();
        if (num >= 20) return (tens[num / 10] + " " + helper(num % 10, tens, ones)).trim();
        return ones[num];
    }

}
