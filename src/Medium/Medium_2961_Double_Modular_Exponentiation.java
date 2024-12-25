// 2961. Double Modular Exponentiation
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2961_Double_Modular_Exponentiation {
    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];

            if (power(power(a,b,10) % 10, c, m) == target)
                answer.add(i);
        }
        return answer;
    }
    private static int power(int num, int power, int mod) {
        int answer = 1;
        while (power-- > 0)
            answer = (answer * num) % mod;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(getGoodIndices(new int[][]{
                {2,3,3,10},{3,3,3,1},{6,1,1,4}}, 2));
        System.out.println(getGoodIndices(new int[][]{
                {39,3,1000,1000}}, 17));
    }
}
