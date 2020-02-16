package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {
    /*public int numUniqueEmails(String[] emails) {
        String test = "test";

        test.replace("t","");
        Set<String> uniqueEmails = new HashSet<>();
        StringBuilder str = new StringBuilder();
        for(int i=0; i<emails.length; i++){
            String[] email = emails[i].split("@");
            for(int j=0; j<email[0].length(); j++){
                if(email[0].charAt(j)=='+'){
                    break;
                }else if(email[0].charAt(j)=='.'){
                    continue;
                }else{
                    str.append(email[0].charAt(j));
                }
            }
            uniqueEmails.add(str.append(email[1]).toString());
        }
        return uniqueEmails.size();
    }*/


    public int numUniqueEmails(String[] emails) {
        Set<String> emailsSet = new HashSet<>();
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String localName = emailSplit[0];
            String domainName = emailSplit[1];
            String[] localNameSplit = localName.split("\\+");
            localName = localNameSplit[0].replace(".", "");
            emailsSet.add(localName + "@" + domainName);
        }
        return emailsSet.size();
    }
    public static void main(String[] args) {
        Solution929 sol = new Solution929();
        String[] arr = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(sol.numUniqueEmails(arr));
    }
}
