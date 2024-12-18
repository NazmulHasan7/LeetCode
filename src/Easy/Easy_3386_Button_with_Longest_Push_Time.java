// 3386. Button with Longest Push Time
package Easy;

public class Easy_3386_Button_with_Longest_Push_Time {
    public static int buttonWithLongestTime(int[][] events) {
        int n = events.length;
        int maxTime = events[0][1], idx = events[0][0];

        for (int i=1; i<n; i++) {
            int timeDiff = events[i][1] - events[i-1][1];
            if (timeDiff > maxTime) {
                maxTime = events[i][1] - events[i-1][1];
                idx = events[i][0];
            } else if (timeDiff == maxTime) {
                idx = Math.min(idx, events[i][0]);
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int[][]{{1,2},{2,5},{3,9},{1,15}}));
        System.out.println(buttonWithLongestTime(new int[][]{{10,5},{1,7}}));
    }
}
