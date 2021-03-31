package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoints[] buildingPoints = new BuildingPoints[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            buildingPoints[index] = new BuildingPoints(building[0], building[2], true);
            buildingPoints[index + 1] = new BuildingPoints(building[1], building[2], false);
            index = index + 2;
        }
        Arrays.sort(buildingPoints, (a, b) -> a.x == b.x ? (a.isStart ? -a.height : a.height) - (b.isStart ? -b.height : b.height) : a.x - b.x);
        TreeMap<Integer, Integer> buildingMap = new TreeMap<>();
        buildingMap.put(0, 1);
        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (BuildingPoints buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                buildingMap.put(buildingPoint.height, buildingMap.getOrDefault(buildingPoint.height, 0) + 1);
            } else {
                buildingMap.put(buildingPoint.height, buildingMap.getOrDefault(buildingPoint.height, 0) - 1);
            }
            int currentMaxHeight = buildingMap.lastKey();
            if (prevMaxHeight != currentMaxHeight) {
                List<Integer> list = new ArrayList<>();
                list.add(buildingPoint.x);
                list.add(buildingPoint.height);
                result.add(list);
            }
        }
        return result;
    }

    class BuildingPoints {

        int x;
        int height;
        boolean isStart;

        BuildingPoints(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
}
