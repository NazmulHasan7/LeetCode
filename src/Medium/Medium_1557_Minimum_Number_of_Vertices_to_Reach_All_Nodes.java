// 1557. Minimum Number of Vertices to Reach All Nodes
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Medium_1557_Minimum_Number_of_Vertices_to_Reach_All_Nodes {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // If there is an incoming edge, then that node must be accessible from some other node
        // So, nodes having in-degree are ignored
        HashSet<Integer> nodesWithIncomingEdge = new HashSet<>();
        for (List<Integer> edge : edges)
            nodesWithIncomingEdge.add(edge.get(1));

        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++)
            if (!nodesWithIncomingEdge.contains(i))
                answer.add(i);
        return answer;
    }
    public static List<Integer> findSmallestSetOfVerticesBetter(int n, List<List<Integer>> edges) {
        // If there is an incoming edge, then that node must be accessible from some other node
        // So, nodes having in-degree are ignored
        boolean[] visited = new boolean[n];
        for (List<Integer> edge : edges)
            visited[edge.get(1)] = true;

        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++)
            if (!visited[i]) answer.add(i);
        return answer;
    }
    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));
        System.out.println(findSmallestSetOfVertices(6, edges));
        System.out.println(findSmallestSetOfVerticesBetter(6, edges));

        edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(2, 4));
        System.out.println(findSmallestSetOfVertices(5, edges));
        System.out.println(findSmallestSetOfVerticesBetter(5, edges));
    }
}
