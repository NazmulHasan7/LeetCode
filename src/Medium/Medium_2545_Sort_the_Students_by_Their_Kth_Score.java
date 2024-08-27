// 2545. Sort the Students by Their Kth Score
package Medium;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Medium_2545_Sort_the_Students_by_Their_Kth_Score {
    public static int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[k] - o1[k];
            }
        });
        return score;
    }
    public static int[][] sortTheStudentsPQ(int[][] score, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        // Store in the priority queue -> kth value, index
        for (int i=0; i<score.length; i++)
            maxHeap.add(new int[]{score[i][k], i});

        int[][] answer = new int[score.length][score[0].length];
        int i=0;
        while (!maxHeap.isEmpty()) {
            int[] temp = maxHeap.poll();
            answer[i++] = score[temp[1]];
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println((Arrays.deepToString(sortTheStudents(
                new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2))));
        System.out.println((Arrays.deepToString(sortTheStudentsPQ(
                new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2))));
    }
}
