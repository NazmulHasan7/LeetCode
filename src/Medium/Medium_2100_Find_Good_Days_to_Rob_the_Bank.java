// 2100. Find Good Days to Rob the Bank
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2100_Find_Good_Days_to_Rob_the_Bank {
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> answer = new ArrayList<>();

        if (time == 0) {
            for (int i=0; i<n; i++)
                answer.add(i);
            return answer;
        }

        // Non-increasing
        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i=1; i<n; i++) {
            prefix[i] = 1;
            if (security[i-1] >= security[i])
                prefix[i] += prefix[i-1];
        }

        // Non-decreasing
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            suffix[i] = 1;
            if (security[i+1] >= security[i])
                suffix[i] += suffix[i+1];
        }

        for (int i=time; i<n-time; i++)
            // at least time days before and after
            if (prefix[i] >= time + 1 && suffix[i] >= time + 1)
                answer.add(i);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(goodDaysToRobBank(new int[]{5,3,3,3,5,6,2},2));
        System.out.println(goodDaysToRobBank(new int[]{1,1,1,1,1},0));
        System.out.println(goodDaysToRobBank(new int[]{1,2,3,4,5,6},2));
    }
}
