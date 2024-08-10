// 1834. Single-Threaded CPU
package Medium;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Medium_1834_Single_Threaded_CPU {
    static class Task {
        int enqueueTime, processingTime, index;
        Task (int enqueueTime, int processingTime, int index) {
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }
    }
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];
        for (int i=0; i<n; i++)
            arr[i] = (new Task(tasks[i][0], tasks[i][1], i));

        // Sort the array based on enqueue time
        Arrays.sort(arr, (a, b) -> a.enqueueTime - b.enqueueTime);
        // Maintain a min heap -> Get all the tasks and push to the heap that can be processed now
        PriorityQueue<Task> minHeap = new PriorityQueue<>(
                (a,b) -> {
                    if (a.processingTime == b.processingTime)
                        return a.index - b.index;
                    return a.processingTime - b.processingTime;
                }
        );

        int[] answer = new int[n];
        int idx = 0, taskIdx = 0, time = 0;
        while (idx < n) {
            while (taskIdx < n && arr[taskIdx].enqueueTime <= time) {
                minHeap.add(arr[taskIdx]);
                taskIdx++;
            }
            if (minHeap.isEmpty()) {
                time = arr[taskIdx].enqueueTime;
            } else {
                time += minHeap.peek().processingTime;
                answer[idx++] = minHeap.poll().index;
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrder(new int[][]{{1,2},{2,4},{3,2},{4,1}})));
        System.out.println(Arrays.toString(getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}})));
    }
}
