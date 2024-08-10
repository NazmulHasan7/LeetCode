// 1845. Seat Reservation Manager
package Medium;
import java.util.PriorityQueue;

public class Medium_1845_Seat_Reservation_Manager {
    static class SeatManager {
        // Keeps track of the unreserved seats
        PriorityQueue<Integer> minHeap;
        // Keeps the track of the latest continuous seats that has been reserved
        int lastReserved;
        public SeatManager(int n) {
            lastReserved = 0;
            minHeap = new PriorityQueue<>();
        }
        public int reserve() {
            if (minHeap.isEmpty())
                return ++lastReserved;
            return minHeap.poll();
        }
        public void unreserve(int seatNumber) {
            if (lastReserved == seatNumber)
                lastReserved--;
            else minHeap.add(seatNumber);
        }
    }
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
        seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
        seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
        seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
        seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
        seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
        seatManager.reserve();    // The only available seat is seat 5, so return 5.
        seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
    }
}
