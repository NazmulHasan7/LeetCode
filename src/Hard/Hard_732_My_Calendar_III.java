// 732. My Calendar III
package Hard;
import java.util.TreeMap;

public class Hard_732_My_Calendar_III {
    static class MyCalendarThree {
        TreeMap<Integer, Integer> bookings;
        public MyCalendarThree() {
            bookings = new TreeMap<>();
        }
        public int book(int startTime, int endTime) {
            bookings.put(startTime, bookings.getOrDefault(startTime, 0)+1);
            bookings.put(endTime, bookings.getOrDefault(endTime, 0)-1);

            int currentBookings = 0, k = 0;
            for (int count : bookings.values()) {
                currentBookings += count;
                k = Math.max(currentBookings, k);
            }
            return k;
        }
    }
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        myCalendarThree.book(10, 20); // return 1
        myCalendarThree.book(50, 60); // return 1
        myCalendarThree.book(10, 40); // return 2
        myCalendarThree.book(5, 15); // return 3
        myCalendarThree.book(5, 10); // return 3
        myCalendarThree.book(25, 55); // return 3
    }
}
