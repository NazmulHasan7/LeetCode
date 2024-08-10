// 797. All Paths From Source to Target
package Medium;
import java.util.ArrayList;
import java.util.List;

public class Medium_797_All_Paths_From_Source_to_Target {
    // Source : 0, Destination : n-1
    public static void dfs(int[][] graph, List<List<Integer>> answer, List<Integer> path, int idx) {
        // If the current neighbor is the destination
        if (idx == graph.length-1) {
            answer.add(new ArrayList<>(path));
            return;
        }
        // Backtracking
        for (int neighbor : graph[idx]) {
            path.add(neighbor);
            dfs(graph, answer, path, neighbor);
            path.remove(path.size()-1);
        }
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, answer, path, 0);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
        System.out.println(allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));
    }
}
