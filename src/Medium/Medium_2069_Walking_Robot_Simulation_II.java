// 2069. Walking Robot Simulation II
package Medium;

public class Medium_2069_Walking_Robot_Simulation_II {
    static class Robot {
        private final int width;
        private final int height;
        // E, N, W, S -> Counterclockwise rotation
        private final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        private int x;
        private int y;
        private final int mod;
        private int dir;
        public Robot(int width, int height) {
            this.height = height;
            this.width = width;
            // perimeter - 4 [4 points repeated]
            this.mod = (width + height) * 2 - 4;
        }
        private boolean isValidAxis(int x, int y) {
            return x >= 0 && x < width && y >= 0 && y < height;
        }
        public void step(int num) {
            // to get rid of loops
            num = num % mod;
            if (num == 0) num = mod;

            while (num-- > 0) {
                if (!isValidAxis(x + directions[dir][0], y + directions[dir][1]))
                    dir = (dir + 1) % 4;
                x = directions[dir][0];
                y = directions[dir][1];
            }
        }
        public int[] getPos() {
            return new int[] {x, y};
        }
        public String getDir() {
            return switch (dir) {
                case 0 -> "East";
                case 1 -> "North";
                case 2 -> "West";
                default -> "South";
            };
        }
    }
    public static void main(String[] args) {
        Robot robot = new Robot(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
        robot.step(2);  // It moves two steps East to (2, 0), and faces East.
        robot.step(2);  // It moves two steps East to (4, 0), and faces East.
        robot.getPos(); // return [4, 0]
        robot.getDir(); // return "East"
        robot.step(2);  // It moves one step East to (5, 0), and faces East.
        // Moving the next step East would be out of bounds, so it turns and faces North.
        // Then, it moves one step North to (5, 1), and faces North.
        robot.step(1);  // It moves one step North to (5, 2), and faces North (not West).
        robot.step(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
        // Then, it moves four steps West to (1, 2), and faces West.
        robot.getPos(); // return [1, 2]
        robot.getDir(); // return "West"
    }
}
