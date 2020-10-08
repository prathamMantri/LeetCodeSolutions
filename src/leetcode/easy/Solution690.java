package leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees)
            map.put(emp.id, emp);
        importance = getImportance(id, map);
        return importance;
    }

    private int getImportance(int id, Map<Integer, Employee> map) {
        Employee emp = map.get(id);
        int importance = emp.importance;
        for (Integer subid : emp.subordinates) {
            importance = importance + getImportance(subid, map);
        }
        return importance;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }
}
