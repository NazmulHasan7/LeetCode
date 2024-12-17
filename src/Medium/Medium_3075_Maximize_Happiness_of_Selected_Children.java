// 3075. Maximize Happiness of Selected Children
package Medium;
import java.util.Arrays;

public class Medium_3075_Maximize_Happiness_of_Selected_Children {
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long answer = 0;
        int n = happiness.length;

        for (int i=0; i<k; i++)
            answer += Math.max((happiness[n-1-i] - i), 0);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1,2,3},2));
        System.out.println(maximumHappinessSum(new int[]{1,1,1,1},2));
        System.out.println(maximumHappinessSum(new int[]{2,3,4,5},1));
    }
}
