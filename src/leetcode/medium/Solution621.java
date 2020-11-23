package leetcode.medium;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
     /*
        if(n==0)
            return tasks.length;

        int[] taskLetters = new int[26];

        int len = tasks.length;
        int max = 0;

        for(char task: tasks){
            taskLetters[task - 'A']++;
            max = Math.max(max, taskLetters[task - 'A']);
        }

        int[] res = new int[max + (max*n)];
        int i=0;

        int letter = 0;
        while(i<res.length && letter < taskLetters.length){
            int currIndex = i;
            for(int j=0; j< taskLetters[letter]; j++) {
                if(res[currIndex] == 1)
                    while(res[currIndex]!=0)
                        currIndex++;
                res[currIndex] = 1;
                currIndex = currIndex + n + 1;
            }
            i++;
            letter++;
        }

        int last = 0;
        for(i=0; i<res.length; i++){
          if(res[i]==1)
              last = i;
        }
        return last+1;

    }
    */

        // First find out the frequencies of each tasks
        int maxFreq = 0;
        int[] frequencies = new int[26];
        for (int t : tasks) {
            frequencies[t - 'A']++;
            // Find out the max frequency
            maxFreq = Math.max(maxFreq, frequencies[t - 'A']);
        }
        //Find tasks with maximum frequencies
        int taskWithMaxFrequencies = 0;

        for (int max : frequencies) {
            if (max == maxFreq) taskWithMaxFrequencies++;
        }

        // Calculate the no of slots
        // why n+1 ??????
        //     because n is idle state and 1 is for the each task
        // why maxFreq - 1?????
        //      because there will be "maxFreq" no of groups for perticular "task" with maximum count
        //      out of which we will consider all the group except the last one as last one will either contain other task or no task but no idle time.


        int noOfGroups = (n + 1) * (maxFreq - 1);

        // Why max of task length and calculated length?????
        //      because, there could be possiblity of availability of no of different tasks than most frequent unique task

        return Math.max(tasks.length, noOfGroups + taskWithMaxFrequencies);

    }
}
