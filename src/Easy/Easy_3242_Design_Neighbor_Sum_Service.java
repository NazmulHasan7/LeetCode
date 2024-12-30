// 3242. Design Neighbor Sum Service
package Easy;

public class Easy_3242_Design_Neighbor_Sum_Service {
    static class NeighborSum {
        private final int[][] grid;
        private final int n;

        public NeighborSum(int[][] grid) {
            this.grid = grid;
            this.n = grid.length;
        }
        private int[] getPosition(int value) {
            for (int r=0; r<n; r++)
                for (int c=0; c<n; c++)
                    if (value == this.grid[r][c])
                        return new int[]{r,c};
            return new int[]{-1,-1};
        }
        public int adjacentSum(int value) {
            int[] pos = getPosition(value);
            int r = pos[0], c = pos[1];

            int sum = 0;
            if (r-1 >= 0) sum += grid[r-1][c];
            if (c-1 >= 0) sum += grid[r][c-1];
            if (c+1 < n)  sum += grid[r][c+1];
            if (r+1 < n)  sum += grid[r+1][c];
            return sum;
        }
        public int diagonalSum(int value) {
            int[] pos = getPosition(value);
            int r = pos[0], c = pos[1];

            int sum = 0;
            if (r-1 >= 0 && c-1 >= 0) sum += grid[r-1][c-1];
            if (r-1 >= 0 && c+1 < n) sum += grid[r-1][c+1];
            if (r+1 < n && c-1 >= 0) sum += grid[r+1][c-1];
            if (r+1 < n && c+1 < n) sum += grid[r+1][c+1];
            return sum;
        }
    }
    public static void main(String[] args) {
        NeighborSum ns = new NeighborSum(new int[][]{{0,1,2},{3,4,5},{6,7,8}});
        System.out.println(ns.adjacentSum(1));
        System.out.println(ns.adjacentSum(4));
        System.out.println(ns.diagonalSum(4));
        System.out.println(ns.diagonalSum(8));
    }
}
