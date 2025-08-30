// 3000. Maximum Area of Longest Diagonal Rectangle
package Easy;

public class Easy_3000_Maximum_Area_of_Longest_Diagonal_Rectangle {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = 0;

        for (int[] di : dimensions) {
            double diagonal = Math.sqrt((di[0]*di[0]) + (di[1]*di[1]));
            int area = di[0]*di[1];

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        } return maxArea;
    }
     public static void main(String[] args) {
         System.out.println(areaOfMaxDiagonal(new int[][]{{9,3}, {8,6}}));
         System.out.println(areaOfMaxDiagonal(new int[][]{{3,4}, {4,3}}));
     }
}
