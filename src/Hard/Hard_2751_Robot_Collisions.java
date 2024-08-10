// 2751. Robot Collisions
package Hard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Hard_2751_Robot_Collisions {
    static class Robot {
        int pos, health, originalIndex;
        char dir;
        Robot(int pos, int health, char dir, int originalIndex) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.originalIndex = originalIndex;
        }
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        for (int i = 0; i < n; i++)
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);

        // Sort robots based on their positions
        Arrays.sort(robots, (r1, r2) -> r1.pos - r2.pos);
        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.dir == 'R') {
                stack.push(robot);
            } else { // current robot direction is L
                while (!stack.isEmpty()) {
                    Robot topRobot = stack.peek();

                    if (topRobot.health < robot.health) {
                        stack.pop();
                        topRobot.health = 0;
                        robot.health -= 1;
                    } else if (topRobot.health > robot.health) {
                        topRobot.health -= 1;
                        robot.health = 0;
                    } else {
                        stack.pop();
                        topRobot.health = robot.health = 0;
                    }
                    if (robot.health == 0) break;
                }
            }
        }
        Arrays.sort(robots, (a,b) -> a.originalIndex - b.originalIndex);
        List<Integer> answer = new ArrayList<>();
        for (Robot robot : robots)
            if (robot.health > 0)
                answer.add(robot.health);
        return answer;
    }
    static class RobotX {
        public int index;
        public int position;
        public int health;
        public char direction;
        public RobotX(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }
    public static List<Integer> survivedRobotsHealthsBetter(int[] positions, int[] healths, String directions) {
        List<Integer> answer = new ArrayList<>();
        RobotX[] robots = new RobotX[positions.length];
        List<RobotX> stack = new ArrayList<>();

        for (int i = 0; i < positions.length; ++i)
            robots[i] = new RobotX(i, positions[i], healths[i], directions.charAt(i));

        Arrays.sort(robots, (a, b) -> a.position - b.position);

        for (RobotX robot : robots) {
            if (robot.direction == 'R') {
                stack.add(robot);
                continue;
            }
            // Collide with robots going right if any.
            while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
                if (stack.get(stack.size() - 1).health == robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health = 0;
                } else if (stack.get(stack.size() - 1).health < robot.health) {
                    stack.remove(stack.size() - 1);
                    robot.health -= 1;
                } else {
                    stack.get(stack.size() - 1).health -= 1;
                    robot.health = 0;
                }
            }
            if (robot.health > 0) stack.add(robot);
        }

        stack.sort((a, b) -> a.index - b.index);
        for (RobotX robot : stack)
            answer.add(robot.health);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(survivedRobotsHealths(new int[]{5,4,3,2,1}, new int[]{2,17,9,15,10}, "RRRRR"));
        System.out.println(survivedRobotsHealths(new int[]{3,5,2,6}, new int[]{10,10,15,12}, "RLRL"));
        System.out.println(survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL"));
    }
}
