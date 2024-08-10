// 2187. Minimum Time to Complete Trips
package Medium;

public class Medium_2187_Minimum_Time_to_Complete_Trips {
    public static long minimumTime(int[] time, int totalTrips) {
        long end = (long) Math.pow(10,7) * totalTrips;
        long start = 1, answer = end;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long tripCount = 0;

            for (int t : time) {
                // possible trip in current time => total time / time
                tripCount += mid / t;
                if (tripCount >= totalTrips) {
                    answer = mid;
                    end = mid - 1;
                    break;
                }
            }
            if (tripCount < totalTrips)
                start = mid + 1;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(minimumTime(new int[]{1,2,3},5));
        System.out.println(minimumTime(new int[]{2},1));
    }
}
