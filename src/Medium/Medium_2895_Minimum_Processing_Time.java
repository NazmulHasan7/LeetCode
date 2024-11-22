// 2895. Minimum Processing Time
package Medium;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medium_2895_Minimum_Processing_Time {
    public static int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int n = processorTime.size();

        // Sort the processor time in increasing order
        Collections.sort(processorTime);
        // Sort the tasks in decreasing order
        Collections.sort(tasks, (a,b) -> Integer.compare(b,a));

        int answer = 0;
        for (int i=0; i<n; i++)
            answer = Math.max(answer, processorTime.get(i) + tasks.get(i*4));

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(minProcessingTime(new ArrayList<>(List.of(8,10)),
                new ArrayList<>(List.of(2,2,3,1,8,7,4,5))));
        System.out.println(minProcessingTime(new ArrayList<>(List.of(10,20)),
                new ArrayList<>(List.of(2,3,1,2,5,8,4,3))));
    }
}
