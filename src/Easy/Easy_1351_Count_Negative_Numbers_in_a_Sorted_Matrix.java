// 1351. Count Negative Numbers in a Sorted Matrix
package Easy;

public class Easy_1351_Count_Negative_Numbers_in_a_Sorted_Matrix {
    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] gr : grid)
            for (int i=gr.length-1; i>=0; i--)
                if (gr[i] < 0)
                    count++;
        return count;
    }
    public static int countNegativesBetter(int[][] grid) {
        int count = 0, start, end, mid;
        for (int[] gr : grid) {
            start = 0;
            end = gr.length-1;
            while (start <= end) {
                mid = start+(end-start) / 2;
                if (gr[mid] < 0)
                    end = mid-1;
                else start = mid+1;
            }
            count += (gr.length - start);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][] {{4,3,2,-1},
                {3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println(countNegatives(new int[][] {{3,2},{1,0}}));
        System.out.println(countNegativesBetter(new int[][] {{4,3,2,-1},
                {3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println(countNegativesBetter(new int[][] {{3,2},{1,0}}));
    }
}
