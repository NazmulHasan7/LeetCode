// 2079. Watering Plants
package Medium;

public class Medium_2079_Watering_Plants {
    public static int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int steps = 1; // 1 step to water the 1st plant
        int waterInCan = capacity - plants[0];

        for (int i=1; i<n; i++) {
            if (plants[i] <= waterInCan) {
                steps++; // have enough water to plant the current plant
            } else {
                steps += (i+1) * 2 - 1; // go back to -1 and get back to current plant
                waterInCan = capacity; // the can in refilled
            }
            waterInCan -= plants[i];
        }
        return steps;
    }
    public static void main(String[] args) {
        System.out.println(wateringPlants(new int[]{2,2,3,3},5));
        System.out.println(wateringPlants(new int[]{1,1,1,4,2,3},4));
        System.out.println(wateringPlants(new int[]{7,7,7,7,7,7,7},8));
    }
}
