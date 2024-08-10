// 2332. The Latest Time to Catch a Bus
package Medium;
import java.util.Arrays;

public class Medium_2332_The_Latest_Time_to_Catch_a_Bus {
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int pi = 0, pn = passengers.length;
        int bn = buses.length, cap = 0;
        for (int bus : buses) {
            cap = 0;
            while (pi < pn && passengers[pi] <= bus && cap < capacity) {
                cap++;
                pi++;
            } // the pi - 1 is the last person on the last bus
        }
        // Space left in last bus ? just appear in a unique time before the departure
        // Otherwise appear before a unique time before the last passenger who get into the bus
        int time = cap < capacity ? buses[bn-1] : passengers[pi-1]-1;
        while (Arrays.binarySearch(passengers, time) >= 0)
            time--; // As the time should be unique
        return time;
    }
    public static void main(String[] args) {
        System.out.println(latestTimeCatchTheBus(new int[]{20,30,10}, new int[]{19,13,26,4,25,11,21}, 2));
        System.out.println(latestTimeCatchTheBus(new int[]{10,20}, new int[]{2,17,18,19}, 2));
    }
}
