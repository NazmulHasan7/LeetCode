// 1870. Minimum Speed to Arrive on Time
package Medium;

public class Medium_1870_Minimum_Speed_to_Arrive_on_Time {
    public static int minSpeedOnTime(int[] dist, double hour) {
        int start = 1, end = 10000000, n = dist.length-1;
        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            double hours = 0;

            for (int i=0; i<n; i++)
                // hours += Math.ceil((double) dist[i] / mid);
                hours += (double) (dist[i] + mid - 1) / mid;
            hours += (double) dist[n] / mid;

            if (hours <= hour) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1,3,2},6));
        System.out.println(minSpeedOnTime(new int[]{1,3,2},2.7));
        System.out.println(minSpeedOnTime(new int[]{1,3,2},1.9));
        System.out.println(minSpeedOnTime(new int[]{1,1,100000},2.01));
    }
}
