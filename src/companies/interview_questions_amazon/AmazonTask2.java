package companies.interview_questions_amazon;

import java.util.*;

public class AmazonTask2 {

    public List<String> processLogs(List<String> logs, int threshold) {

        Map<String, Integer> transactionMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String log : logs) {

            String[] transaction = log.split(" ");

            String sender = transaction[0];
            String receiver = transaction[1];

            if (sender != receiver) {
                transactionMap.put(receiver, transactionMap.getOrDefault(sender, 0) + 1);
            }
            transactionMap.put(sender, transactionMap.getOrDefault(sender, 0) + 1);
        }

        Set<String> users = transactionMap.keySet();
        for (String user : users) {
            if (transactionMap.get(user) >= threshold)
                result.add(user);
        }

        result.sort((a, b) -> Integer.parseInt(b) - Integer.parseInt(a));

        return result;
    }


}
