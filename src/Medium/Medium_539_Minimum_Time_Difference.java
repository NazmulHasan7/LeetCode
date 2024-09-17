// 539. Minimum Time Difference
package Medium;
import java.util.Arrays;
import java.util.List;

public class Medium_539_Minimum_Time_Difference {
    public static int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutesArr = new int[n];
        int idx = 0;

        for (String time : timePoints) {
            int hour = Integer.parseInt(time.substring(0,2));
            int minutes = Integer.parseInt(time.substring(3));
            minutesArr[idx++] = hour * 60 + minutes;
        }
        int answer = Integer.MAX_VALUE;
        Arrays.sort(minutesArr);
        for (int i=1; i<n; i++)
            answer = Math.min(answer, minutesArr[i] - minutesArr[i-1]);

        return Math.min(answer, (24 * 60 + minutesArr[0]) - minutesArr[n-1]);
    }
    public static void main(String[] args) {
        System.out.println(findMinDifference(List.of("23:59","00:00")));
        System.out.println(findMinDifference(List.of("00:00","23:59","00:00")));
    }
}
