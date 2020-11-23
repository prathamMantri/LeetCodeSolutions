package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return canFinishBFS(numCourses, prerequisites) && canFinishDFS(numCourses, prerequisites); // Just for fun

    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        int level = 0;
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] course : prerequisites) {
            graph[course[0]].add(course[1]);
            degree[course[1]]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                level++;
                qu.offer(i);
            }
        }
        while (!qu.isEmpty()) {
            int course = qu.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int current = graph[course].get(i);
                degree[current]--;
                if (degree[current] == 0) {
                    qu.offer(current);
                    level++;
                }
            }
        }
        return level == numCourses;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] course : prerequisites) {
            graph[course[1]].add(course[0]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, graph, i, dp)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] visited, ArrayList<Integer>[] graph, int course, boolean[] dp) {
        if (visited[course])
            return dp[course];
        visited[course] = true;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(visited, graph, graph[course].get(i), dp)) {
                dp[course] = false;
                return false;
            }
        }
        dp[course] = true;
        return true;
    }
}
