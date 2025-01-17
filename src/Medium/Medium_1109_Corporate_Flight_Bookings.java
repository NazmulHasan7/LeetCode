// 1109. Corporate Flight Bookings
package Medium;
import java.util.Arrays;

public class Medium_1109_Corporate_Flight_Bookings {
    // Difference Array technique, TC -> O(n), SC -> O(n)
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diffArr = new int[n+2]; // 1-n flights, n+1 -> diff array

        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            diffArr[first] += seats;
            diffArr[last+1] -= seats;
        }
        for (int i=1; i<=n; i++)
            diffArr[i] += diffArr[i-1];

        return Arrays.copyOfRange(diffArr,1,n+1);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5)));
        System.out.println(Arrays.toString(corpFlightBookings(new int[][]{{1,2,10},{2,2,15}}, 2)));
    }
}
