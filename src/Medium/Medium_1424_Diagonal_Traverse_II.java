// 1424. Diagonal Traverse II
package Medium;
import java.util.*;

public class Medium_1424_Diagonal_Traverse_II {
    public static int[] findDiagonalOrder(ArrayList<ArrayList<Integer>> nums) {
        // BFS Approach
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            answer.add(nums.get(row).get(col));

            // If 1st column element push down element
            if (col == 0 && row+1 < nums.size())
                queue.add(new int[]{row+1, 0});

            // Push the right element to the queue
            if (col+1 < nums.get(row).size())
                queue.add(new int[]{row, col+1});
        }
        int[] arr = new int[answer.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = answer.get(i);
        return arr;
    }
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int[] ints : arr) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int anInt : ints)
                innerList.add(anInt);
            arrayList.add(innerList);
        }
        System.out.println(Arrays.toString(findDiagonalOrder(arrayList)));
    }
}
