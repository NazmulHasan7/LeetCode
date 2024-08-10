// 2651. Calculate Delayed Arrival Time
package Easy;

public class Easy_2651_Calculate_Delayed_Arrival_Time {
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(15, 5));
        System.out.println(findDelayedArrivalTime(13, 11));
    }
}
