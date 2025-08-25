// 3408. Design Task Manager
package Medium;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Medium_3408_Design_Task_Manager {
    static class TaskManager {
        TreeSet<int[]> taskSet = new TreeSet<>((a, b) -> {
            if (a[2] == b[2]) return b[1] - a[1]; // sort by task id for same priority
            return b[2] - a[2]; // sort by task priority
        });;
        HashMap<Integer, int[]> map = new HashMap<>();

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                int[] newTask = new int[]{task.get(0), task.get(1), task.get(2)};
                taskSet.add(newTask);
                map.put(task.get(1), newTask);
            }
        }
        public void add(int userId, int taskId, int priority) {
            int[] newTask = new int[]{userId, taskId, priority};
            taskSet.add(newTask);
            map.put(taskId, newTask);
        }
        public void edit(int taskId, int newPriority) {
            int[] task = map.get(taskId);
            taskSet.remove(task);
            task[2] = newPriority;
            taskSet.add(task);
            map.put(taskId, task);
        }
        public void rmv(int taskId) {
            int[] task = map.get(taskId);
            taskSet.remove(task);
            map.remove(taskId);
        }
        public int execTop() {
            if (taskSet.isEmpty()) return -1;
            return taskSet.removeFirst()[0];
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> tasks = Arrays.asList(
                Arrays.asList(1, 101, 10),
                Arrays.asList(2, 102, 20),
                Arrays.asList(3, 103, 15)
        );
        TaskManager taskManager = new TaskManager(tasks); // Initializes with three tasks for Users 1, 2, and 3.
        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager.execTop(); // return 3. Executes task 103 for User 3.
        taskManager.rmv(101); // Removes task 101 from the system.
        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        taskManager.execTop(); // return 5. Executes task 105 for User 5.
    }
}
