// 874. Walking Robot Simulation
package Medium;
import java.util.HashSet;

public class Medium_874_Walking_Robot_Simulation {
    public static int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        // Pair the obstacles into space separated string -> O(m)
        for (int[] obs : obstacles)
            set.add(obs[0] + " " + obs[1]);

        // Direction -> North, South, East, West
        // From N, if it rotates 90 right, then it points to E
        // From N. if it rotates 90 left, then it points to W
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0, maxDis = 0, x = 0, y = 0;

        for (int c : commands) {
            if (c == -1) {
                // since the direction array is of length 4
                dir = (dir + 1) % 4; // turn right
            } else if (c  == -2) {
                dir = (dir + 3) % 4; // turn left
            } else {
                // keep going to the direction
                for (int i=0; i<c; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    if (set.contains(newX + " " + newY))
                        break; // obstacle found
                    x = newX;
                    y = newY;
                }
                maxDis = Math.max(maxDis, x * x + y * y);
            }
        } return maxDis;
    }
    public static void main(String[] args) {
        System.out.println(robotSim(new int[]{4,-1,3}, new int[][]{}));
        System.out.println(robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
        System.out.println(robotSim(new int[]{6,-1,-1,6}, new int[][]{}));
    }
}
