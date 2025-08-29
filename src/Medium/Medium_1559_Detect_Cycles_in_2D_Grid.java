// 1559. Detect Cycles in 2D Grid
package Medium;

public class Medium_1559_Detect_Cycles_in_2D_Grid {
    private static int rows;
    private static int cols;
    private static boolean[][] visited;
    private static int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public static boolean containsCycle(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int r=0; r<rows; r++)
            for (int c=0; c<cols; c++)
                if (!visited[r][c] && dfs(grid, r, c, -1, -1))
                    return true;
        return false;
    }
    private static boolean dfs(char[][] grid, int r, int c, int prevR, int prevC) {
        // mark as visited
        visited[r][c] = true;

        for (int[] dir : DIRS) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            // check valid range
            if (newR >= 0 && newR < rows && newC >= 0 && newC < cols) {
                // check if we are coming from the parent
                if (!(newR == prevR && newC == prevC)) {
                    // check if the values are same
                    if (grid[r][c] == grid[newR][newC]) {
                        if (visited[newR][newC])
                            return true;
                        else if (dfs(grid, newR, newC, r, c))
                            return true;
                    }
                }
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(containsCycle(new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}}));
        System.out.println(containsCycle(new char[][]{{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}}));
        System.out.println(containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
    }
}
