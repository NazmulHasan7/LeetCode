// 735. Asteroid Collision
package Medium;
import java.util.Arrays;
import java.util.Stack;

public class Medium_735_Asteroid_Collision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int ast : asteroids) {
            // Asteroids are moving forward and do not collide
            if (ast > 0) stack.push(ast);
                // Asteroids moving backward collides with the first asteroid
            else {
                // If backward asteroid has higher magnitude then it destroys the top one
                while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(ast))
                    stack.pop();

                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(ast);
                else if (stack.peek() == Math.abs(ast))
                    stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        for (int ast : stack)
            result[index++] = ast;
        return result;
    }
    public int[] asteroidCollisionBetter(int[] asteroids) {
        int top = -1;
        for (int i=0; i<asteroids.length; i++) {
            // Asteroids moving backward collides with the first asteroid
            if (asteroids[i] < 0) {
                // If backward asteroid has higher magnitude then it destroys the top one
                while (top>-1 && asteroids[top]>0 && asteroids[top]<Math.abs(asteroids[i]))
                    top--;
                if (top==-1 || asteroids[top]<0)
                    asteroids[++top] = asteroids[i];
                else if(asteroids[top] == Math.abs(asteroids[i]))
                    top--;
            } else {
                // Asteroids are moving forward and do not collide
                asteroids[++top] = asteroids[i];
            }
        }
        int[] result = new int[top+1];
        System.arraycopy(asteroids, 0, result, 0, top+1);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-4, 6})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{4, -6})));
        System.out.println(Arrays.toString(asteroidCollision(new int[] {-2,-2,1,-2})));
    }
}
