// 729. My Calendar I
package Medium;
import java.util.TreeMap;

public class Medium_729_My_Calendar_I {
    static class MyCalendar {
        TreeMap<Integer, Integer> bookings;

        public MyCalendar() {
            bookings = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            Integer prevStart = bookings.lowerKey(startTime);
            Integer nextStart = bookings.ceilingKey(startTime);

            // check prev end time and next start time
            if ((prevStart == null || bookings.get(prevStart) <= startTime) &&
                    (nextStart == null || endTime <= nextStart)) {
                bookings.put(startTime, endTime);
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.book(10, 20); // return True
        myCalendar.book(15, 25); // return False
        myCalendar.book(20, 30);
    }
}
