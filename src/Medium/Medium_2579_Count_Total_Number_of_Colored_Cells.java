// 2579. Count Total Number of Colored Cells
package Medium;

public class Medium_2579_Count_Total_Number_of_Colored_Cells {
    // New add 1 -> 1, 2 -> 4, 3 -> 8, 4 -> 12
    public static long coloredCells(int n) {
        // long answer = 1;
        // for (int i=2; i<=n; i++)
        //     answer += (i-1) * 4;

        // return answer;
        return 1 + (long) 4 * n * (n - 1) / 2;
    }
    public static void main(String[] args) {
        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));
    }
}
