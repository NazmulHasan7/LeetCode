// 401. Binary Watch
package Easy;
import java.util.ArrayList;
import java.util.List;

public class Easy_401_Binary_Watch {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();
        StringBuilder time = new StringBuilder();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    time.setLength(0);
                    time.append(hour).append(":");
                    if (minute < 10) time.append(0);
                    time.append(minute);
                    answer.add(time.toString());
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(9));
    }
}
