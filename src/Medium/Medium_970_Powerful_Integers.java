// 970. Powerful Integers
package Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Medium_970_Powerful_Integers {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> answer = new HashSet<>();

        for (int xPow = 1; xPow <= bound; xPow *= x) {
            for (int yPow = 1; yPow <= bound; yPow *= y) {
                int sum = xPow + yPow;
                if (sum <= bound) answer.add(sum);
                else break;

                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(answer);
    }
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2,3,10));
        System.out.println(powerfulIntegers(3,5,15));
    }
}
