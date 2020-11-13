package interview_questions_google;

import java.util.HashSet;
import java.util.Set;


/*

You want to invite as many friends to your party as possible. You're given list of tuples where each tuple consists of two friend ids and they don't like each other. Your task is to invite as many friends as possible. Output of the task - max number of friends you can invite which don't have conflicts with each other.

Input: [(1, 2), (2, 3), (3, 4)]
Ouput: 2 (it's either (1, 3) or (2, 4) or (1, 4)


 */


public class InviteFriends {
    public int inviteFriends(int[][] pairs) {
        if (pairs.length < 2) {
            return 0;
        }

        int max = 0;

        for (int[] pair : pairs) {
            max = Math.max(Math.max(pair[0], pair[1]), max);
        }

        int[][] friendsMap = new int[max][max];

        for (int[] pair : pairs) {
            friendsMap[pair[0] - 1][pair[1] - 1] = -1;
            friendsMap[pair[1] - 1][pair[0] - 1] = -1;
        }

        /*
            1   2   3   4
        1
        2
        3
        4





         */


        Set<Integer> friends = new HashSet<>();

        for (int i = 0; i < friendsMap.length; i++)
            for (int j = 0; j < friendsMap[0].length; j++)
                if (friendsMap[i][j] != -1 && i != j) {
                    friends.add(i);
                    friends.add(j);
                }
        return friends.size() == 0 ? -1 : friends.size();
    }
}
