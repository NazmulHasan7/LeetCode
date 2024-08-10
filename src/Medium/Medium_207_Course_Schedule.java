// 207. Course Schedule
package Medium;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_207_Course_Schedule {
    private static boolean hasCycleBFS(int n, ArrayList<ArrayList<Integer>> adj, int[] inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int u=0; u<n; u++) {
            if (inDegree[u] == 0) {
                queue.add(u);
                count++;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                    count++;
                }
            }
        }
        // Check for cycle
        return count != n;
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Create Graph
        for (int u=0; u<numCourses; u++)
            adj.add(new ArrayList<>());

        // [0, 1], indicates that to take course 0 you have to first take course 1
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }
        // If there is a cycle or not all the nodes are visited then return false
        return !hasCycleBFS(numCourses, adj, inDegree);
    }
    private static boolean hasCycleDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] visitedInCurrentRecursion, int pre) {
        visited[pre] = visitedInCurrentRecursion[pre] = true;
        for (int course : adj.get(pre)) {
            if (!visited[course] && hasCycleDFS(adj, visited, visitedInCurrentRecursion, course))
                return true;
            else if (visitedInCurrentRecursion[course])
                return true;
        }
        visitedInCurrentRecursion[pre] = false;
        return false;
    }
    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visitedInCurrRecursion = new boolean[numCourses];

        // Create Graph
        for (int u=0; u<numCourses; u++)
            adj.add(new ArrayList<>());

        // [0, 1], indicates that to take course 0 you have to first take course 1
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(pre).add(course);
        }
        for (int u=0; u<numCourses; u++)
            if (!visited[u] && hasCycleDFS(adj, visited, visitedInCurrRecursion, u))
                return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
        System.out.println(canFinish(2, new int[][]{{1,0},{0,1}}));
        System.out.println(canFinishDFS(2, new int[][]{{1,0}}));
        System.out.println(canFinishDFS(2, new int[][]{{1,0},{0,1}}));
    }
}
