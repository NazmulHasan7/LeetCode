// 3169. Count Days Without Meetings
package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Medium_3169_Count_Days_Without_Meetings {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(meetings[0]);

        int n = meetings.length;
        for (int i=1; i<n; i++) {
            int[] temp = new int[2];
            if (arr.getLast()[1] >= meetings[i][0]) {
                temp[0] = Math.min(arr.getLast()[0], meetings[i][0]);
                temp[1] = Math.max(arr.getLast()[1], meetings[i][1]);
                arr.set(arr.size()-1, temp);
            } else {
                arr.add(meetings[i]);
            }
        }
        for (int[] a : arr)
            days -= (a[1] - a[0] + 1);

        return days;
    }
    public static int countDaysOpt(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> (a[0] - b[0]));
        int cntDays = meetings[0][0]-1, end = meetings[0][1];

        for(int idx = 1; idx < meetings.length; idx++){
            int start = meetings[idx][0];
            if(start > end)
                cntDays += (start - end - 1);
            end = Math.max(end, meetings[idx][1]);
        }
        if(end < days)
            return days - end + cntDays;
        return cntDays;
    }
    public static void main(String[] args) {
        System.out.println(countDays(10, new int[][]{{5,7},{1,3},{9,10}}));
        System.out.println(countDays(5, new int[][]{{2,4},{1,3}}));
        System.out.println(countDays(6, new int[][]{{1,6}}));
    }
}
