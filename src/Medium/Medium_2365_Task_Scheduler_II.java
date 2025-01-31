// 2365. Task Scheduler II
package Medium;
import java.util.HashMap;

public class Medium_2365_Task_Scheduler_II {
    public static long taskSchedulerII(int[] tasks, int space) {
        // Keep track of the type of tasks last performed
        HashMap<Integer, Long> taskLastCompleted = new HashMap<>();

        long days = 0;
        for (int taskId : tasks) {
            days++;
            if (taskLastCompleted.containsKey(taskId)) {
                // Check when was this task done before
                long lastDone = taskLastCompleted.get(taskId);
                long gap = days - lastDone;
                if (gap <= space)
                    days = lastDone + space + 1;
            }
            taskLastCompleted.put(taskId, days);
        }
        return days;
    }
    public static void main(String[] args) {
        System.out.println(taskSchedulerII(new int[]{1,2,1,2,3,1},3));
        System.out.println(taskSchedulerII(new int[]{5,8,8,5},2));
        System.out.println(taskSchedulerII(new int[]{4,10,10,9,10,4,10,4},8));
    }
}
