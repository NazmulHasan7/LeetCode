// 1926. Nearest Exit from Entrance in Maze
package Medium;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_1926_Nearest_Exit_from_Entrance_in_Maze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] current;

        // To traverse in right, left, up, down
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // Mark as visited

        int steps = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            steps++;

            while (n-- > 0) {
                current = queue.poll();
                for (int[] dir : directions) {
                    int x = dir[0] + current[0];
                    int y = dir[1] + current[1];

                    if (x < 0 || x >= rows || y < 0 || y >= cols)
                        continue;
                    if (maze[x][y] == '+')
                        continue;
                    if (x == 0 || x == rows-1 || y == 0 || y == cols-1)
                        return steps;
                    queue.add(new int[]{x,y});
                    maze[x][y] = '+'; // Mark as visited
                }
            }
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(nearestExit(new char[][]{{'+','+','.','+'},{'.','.','.','+'},
                {'+','+','+','.'}}, new int[]{1,2}));
        System.out.println(nearestExit(new char[][]{{'+','+','+'},{'.','.','.'},
                {'+','+','+'}}, new int[]{1,0}));
    }
}
