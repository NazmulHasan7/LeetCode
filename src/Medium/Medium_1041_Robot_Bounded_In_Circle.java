// 1041. Robot Bounded In Circle
package Medium;

public class Medium_1041_Robot_Bounded_In_Circle {
    public static boolean isRobotBounded(String instructions) {
        // Initial position and direction
        char direction = 'N';
        int x = 0, y = 0;

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                switch (direction) {
                    case 'N' -> y++;
                    case 'S' -> y--;
                    case 'E' -> x++;
                    case 'W' -> x--;
                }
            } else if (instruction == 'L') {
                switch (direction) {
                    case 'N' -> direction = 'W';
                    case 'W' -> direction = 'S';
                    case 'S' -> direction = 'E';
                    case 'E' -> direction = 'N';
                }
            } else {
                switch (direction) {
                    case 'N' -> direction = 'E';
                    case 'E' -> direction = 'S';
                    case 'S' -> direction = 'W';
                    case 'W' -> direction = 'N';
                }
            }
        }
        // Pointing in the same direction after a complete iteration -> never makes a cycle
        if (x == 0 && y == 0) return true;
        if (direction == 'N') return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
    }
}
