// 731. My Calendar II
package Medium;
import java.util.Map;
import java.util.TreeMap;

public class Medium_731_My_Calendar_II {
    static class MyCalendarTwo {
        TreeMap<Integer, Integer> bookings;

        public MyCalendarTwo() {
            this.bookings = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            // update the bookings map
            bookings.put(startTime, bookings.getOrDefault(startTime, 0)+1);
            bookings.put(endTime, bookings.getOrDefault(endTime, 0)-1);

            int overlapCount = 0;
            // now check if there is any triple booking
            for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
                overlapCount += entry.getValue();
                if (overlapCount >= 3) {
                    // revert back the changes
                    bookings.put(startTime, bookings.get(startTime)-1);
                    bookings.put(endTime, bookings.get(endTime)+1);

                    if (bookings.get(startTime) == 0)
                        bookings.remove(startTime);
                    if (bookings.get(endTime) == 0)
                        bookings.remove(endTime);
                    return false;
                }
            } return true;
        }
    }
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20); // return True, The event can be booked.
        myCalendarTwo.book(50, 60); // return True, The event can be booked.
        myCalendarTwo.book(10, 40); // return True, The event can be double booked.
        myCalendarTwo.book(5, 15);  // return False, The event cannot be booked, because it would result in a triple booking.
        myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        myCalendarTwo.book(25, 55); // return True,
    }
}
