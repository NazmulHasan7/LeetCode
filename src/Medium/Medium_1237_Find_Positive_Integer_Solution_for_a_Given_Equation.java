// 1237. Find Positive Integer Solution for a Given Equation
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1237_Find_Positive_Integer_Solution_for_a_Given_Equation {
    static class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }
    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int x=1; x<=1000; x++) {
            int start = 1, end = 1000;
            while (start <= end) {
                int y = (start + end) / 2;
                int zRet = customfunction.f(x, y);
                if (zRet == z) {
                    answer.add(Arrays.asList(x, y));
                    break;
                } else if (zRet > z) {
                    end = y - 1;
                } else {
                    start = y + 1;
                }
            }
        } return answer;
    }
    public List<List<Integer>> findSolutionBetter(CustomFunction customfunction, int z) {
        List<List<Integer>> answer  = new ArrayList<>();
        int left = 1, right = z;
        while(left < 1001 &&  right > 0) {
            if(customfunction.f(left, right) == z) {
                answer.add(Arrays.asList(left, right));
                right--;
                left++;
            } else if(customfunction.f(left, right) > z) {
                right--;
            } else {
                left ++;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(findSolution(new CustomFunction(), 5));
    }
}
