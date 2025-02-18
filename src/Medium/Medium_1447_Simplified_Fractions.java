// 1447. Simplified Fractions
package Medium;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Medium_1447_Simplified_Fractions {
    public static List<String> simplifiedFractions(int n) {
        HashSet<Double> set = new HashSet<>();

        List<String> answer = new ArrayList<>();
        for (int i=1; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                double value = (double)i/j;
                if (!set.contains(value))
                    answer.add(i + "/" + j);

                set.add(value);
            }
        } return answer;
    }

    // Optimized Approach
    private static int gcd(int i, int j) {
        if (j == 0) 
            return i;
        return gcd(j, i%j);
    }

    /*The condition gcd(i, j) == 1 is used to check if two numbers, i (the numerator) and j (the denominator), 
    are coprime or relatively prime. This means that the greatest common divisor (GCD) of i and j is 1. */

    public static List<String> simplifiedFractionsOpt(int n) {
        List<String> answer = new ArrayList<>();
        for (int i=1; i<n; i++) {
            for (int j=2; j<=n; j++) {
                if (i < j && gcd(i, j) == 1)
                    answer.add(i + "/" + j);
            }
        } return answer;
    }

    public static void main(String[] args) {
        System.out.println(simplifiedFractions(2));
        System.out.println(simplifiedFractions(3));
        System.out.println(simplifiedFractions(4));
    }
}
