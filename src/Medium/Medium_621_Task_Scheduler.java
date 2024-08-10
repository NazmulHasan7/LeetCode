// 621. Task Scheduler
package Medium;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Medium_621_Task_Scheduler {
    public static int leastInterval(char[] tasks, int n) {
        // Approach --> Greedily finish the task of maximum frequency
        int[] freqArr = new int[26];
        for (int x : tasks) freqArr[x-'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));
        for (int freq : freqArr)
            if (freq > 0) maxHeap.add(freq);

        int answer = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // To run the same task need to wait for the n time for cooling
            // So, the same task can be run at n+1 time
            for (int i=0; i<=n; i++)
                if (!maxHeap.isEmpty())
                    temp.add(maxHeap.poll()-1);

            // Now add the updated frequency back to the queue
            for (int freq : temp)
                if (freq > 0) maxHeap.add(freq);
            // Update answer
            answer += maxHeap.isEmpty() ? temp.size() : n+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2));
        System.out.println(leastInterval(new char[]{'A','C','A','B','D','B'},1));
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},3));
    }
}
