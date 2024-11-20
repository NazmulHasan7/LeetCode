// 2178. Maximum Split of Positive Even Integers
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_2178_Maximum_Split_of_Positive_Even_Integers {
    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> answer = new ArrayList<>();
        if (finalSum % 2 != 0) return answer;

        long nextEven = 2, sum = 0;
        while (sum + nextEven <= finalSum) {
            sum += nextEven;
            answer.add(nextEven);
            nextEven += 2;
        }

        if (sum < finalSum) {
            long lastEven = answer.removeLast();
            lastEven = finalSum - sum + lastEven;
            answer.add(lastEven);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(8));
        System.out.println(maximumEvenSplit(7));
    }
}
