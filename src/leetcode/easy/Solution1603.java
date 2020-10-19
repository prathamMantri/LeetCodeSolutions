package leetcode.easy;

public class Solution1603 {

    public static class ParkingSystem {
        int big;
        int medium;
        int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                return this.big-- <= 0;
            } else if (carType == 2) {
                return this.medium-- <= 0;
            } else {
                return this.small-- <= 0;
            }
        }
    }
}
