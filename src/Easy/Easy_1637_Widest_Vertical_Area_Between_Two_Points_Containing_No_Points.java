// 1637. Widest Vertical Area Between Two Points Containing No Points
package Easy;
import java.util.Arrays;

public class Easy_1637_Widest_Vertical_Area_Between_Two_Points_Containing_No_Points {
    // The widest vertical area is the one with the maximum width.
    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int max = 0;
        for (int i=0; i<points.length-1; i++)
            max = Math.max(max, points[i+1][0] - points[i][0]);
        return max;
    }
    public static int maxWidthOfVerticalAreaBetter(int[][] points) {
        int[] xAxis = new int[points.length];
        for (int i=0; i<xAxis.length; i++)
            xAxis[i] = points[i][0];
        Arrays.sort(xAxis);

        int max = 0, width;
        for (int i=1; i<xAxis.length; i++) {
            width = xAxis[i] - xAxis[i-1];
            if (width > max) max = width;
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][] {{8,7},{9,9},{7,4},{9,7}}));
        System.out.println(maxWidthOfVerticalArea(new int[][] {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}}));
        System.out.println(maxWidthOfVerticalAreaBetter(new int[][] {{8,7},{9,9},{7,4},{9,7}}));
        System.out.println(maxWidthOfVerticalAreaBetter(new int[][] {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}}));
    }
}
