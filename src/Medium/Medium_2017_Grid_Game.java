// 2017. Grid Game
package Medium;

public class Medium_2017_Grid_Game {
    public static long gridGame(int[][] grid) {
        // Approach -> Since Robot1 is starting first, the turn Down index is important
        // Robot2 can only the after turn down index from row1 or
        // before turn down index from row2
        int n = grid[0].length;

        long firstRowSum = 0;
        for (int i=0; i<n; i++) firstRowSum += grid[0][i];

        long secondRowSum = 0;
        long answer = Long.MAX_VALUE;

        // Trying each index as the turn down index for robot1
        for (int turnDownIndex=0; turnDownIndex<n; turnDownIndex++) {
            firstRowSum -= grid[0][turnDownIndex];
            // Robot2 will take the path with the maximum sum
            long robot2Takes = Math.max(firstRowSum, secondRowSum);
            answer = Math.min(answer, robot2Takes);
            secondRowSum += grid[1][turnDownIndex];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(gridGame(new int[][]{{2,5,4},{1,5,1}}));
        System.out.println(gridGame(new int[][]{{3,3,1},{8,5,2}}));
        System.out.println(gridGame(new int[][]{{1,3,1,15},{1,3,3,1}}));
    }
}
