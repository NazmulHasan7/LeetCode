// 853. Car Fleet
package Medium;
import java.util.Arrays;

public class Medium_853_Car_Fleet {
    private static class Car {
        int position;
        double arrivalTime;
        Car (int pos, double time) {
            this.position = pos;
            this.arrivalTime = time;
        }
    }
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i=0; i<n; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }

        // Sort the cars based on position
        Arrays.sort(cars, (a, b) -> (a.position - b.position));

        int idx = n-1;
        int fleets = 0;
        while (idx > 0) {
            // previous car cannot catch this car, so a separate fleet found
            if (cars[idx].arrivalTime < cars[idx-1].arrivalTime)
                fleets++;
                // part of the current fleet
                // The speed of the car fleet is the minimum speed of any car in the fleet
            else cars[idx-1] = cars[idx]; // assuming as the same car
            idx--;
        }
        return fleets + 1; // last car fleet
    }
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        System.out.println(carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(carFleet(100, new int[]{0,2,4}, new int[]{4,2,1}));
    }
}
