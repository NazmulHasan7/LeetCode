// 2126. Destroying Asteroids
package Medium;
import java.util.Arrays;

public class Medium_2126_Destroying_Asteroids {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = mass;
        for (int x : asteroids) {
            if (m < x) return false;
            m += x;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(asteroidsDestroyed(10, new int[]{3,9,19,5,21}));
        System.out.println(asteroidsDestroyed(5, new int[]{4,9,23,4}));
    }
}