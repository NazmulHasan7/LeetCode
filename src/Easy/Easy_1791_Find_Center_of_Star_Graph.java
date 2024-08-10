// 1791. Find Center of Star Graph
package Easy;

public class Easy_1791_Find_Center_of_Star_Graph {
    public static int findCenter(int[][] edges) {
        // The Center node is the only node that has more than one edge
        // All the nodes are connected to the center node
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        return edges[0][1];
    }
    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2},{2,3},{4,2}}));
        System.out.println(findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }
}
