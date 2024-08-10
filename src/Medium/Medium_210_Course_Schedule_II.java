// 210. Course Schedule II
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_210_Course_Schedule_II {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Build the Graph and in-degree array
        for (int u=0; u<numCourses; u++)
            adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int pre = prerequisite[1];
            int course = prerequisite[0];
            adj.get(pre).add(course);
            inDegree[course]++;
        }

        // Topological Sort
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] answer = new int[numCourses];

        for (int u=0; u<numCourses; u++) {
            if (inDegree[u] == 0) {
                answer[count++] = u;
                queue.add(u);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int course : adj.get(pre)) {
                inDegree[course]--;
                if (inDegree[course] == 0) {
                    queue.add(course);
                    answer[count++] = course;
                }
            }
        }
        return count == numCourses ? answer : new int[]{};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1,0}})));
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
    }
}
