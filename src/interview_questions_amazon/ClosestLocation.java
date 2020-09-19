package interview_questions_amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClosestLocation {

    public static void main(String[] args) {
        ClosestLocation closestLocation = new ClosestLocation();

        List<PairInt> allLocations0 = new ArrayList<>();

        allLocations0.add(new PairInt(1, 2));
        allLocations0.add(new PairInt(3, 4));
        allLocations0.add(new PairInt(1, -1));

        List<PairInt> allLocations1 = new ArrayList<>();

        allLocations1.add(new PairInt(1, -3));
        allLocations1.add(new PairInt(1, 2));
        allLocations1.add(new PairInt(3, 4));


        List<PairInt> allLocations2 = new ArrayList<>();

        allLocations2.add(new PairInt(3, 6));
        allLocations2.add(new PairInt(2, 4));
        allLocations2.add(new PairInt(5, 3));
        allLocations2.add(new PairInt(2, 7));
        allLocations2.add(new PairInt(1, 8));
        allLocations2.add(new PairInt(7, 9));

        List<PairInt> closestLocations0 = closestLocation.closestLocations(3, allLocations0, 2);
        List<PairInt> closestLocations1 = closestLocation.closestLocations(3, allLocations1, 1);
        List<PairInt> closestLocations2 = closestLocation.closestLocations(6, allLocations2, 3);

        for (PairInt location : closestLocations2) {
            System.out.println(location.first + " " + location.second);
        }


    }

    List<PairInt> closestLocations(int totalCrates, List<PairInt> allLocations, int truckCapacity) {

        List<PairInt> result = new ArrayList<>();
        PairInt emptyPair = new PairInt();
        if (allLocations == null || allLocations.isEmpty()) {
            result.add(emptyPair);
            return result;
        }
        if (truckCapacity == 0) {
            result.add(emptyPair);
            return result;
        }
        if (totalCrates == 0) {
            result.add(emptyPair);
            return result;
        }

        Map<Double, List<PairInt>> countMap = new TreeMap<>();

        // int noOfTrucks = totalCrates % truckCapacity == 0 ? (totalCrates / truckCapacity) : (totalCrates / truckCapacity) + 1 ;
        for (PairInt location : allLocations) {
            Double distance = Math.sqrt(Math.pow(location.first, 2) + Math.pow(location.second, 2));
            List<PairInt> locations = new ArrayList<>();
            if (countMap.containsKey(distance)) {
                locations.addAll(countMap.get(distance));
            }
            locations.add(location);
            countMap.put(distance, locations);
        }
        int count = 0;
        for (Map.Entry<Double, List<PairInt>> entry : countMap.entrySet()) {
            if (truckCapacity == count) {
                return result;
            }
            List<PairInt> locations = entry.getValue();
            for (PairInt location : locations) {
                result.add(location);
                count++;
            }
        }
        return result;

    }

}
