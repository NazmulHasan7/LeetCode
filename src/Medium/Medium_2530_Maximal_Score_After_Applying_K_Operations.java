// 2530. Maximal Score After Applying K Operations
package Medium;
import java.util.PriorityQueue;

public class Medium_2530_Maximal_Score_After_Applying_K_Operations {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for (int x : nums) maxHeap.add(x);

        long score = 0;
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int max = maxHeap.poll();
            score += max;
            maxHeap.add(Math.ceilDiv(max, 3));
        }
        return score;
    }
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{10,10,10,10,10},5));
        System.out.println(maxKelements(new int[]{1,10,3,3,3},3));
    }
}
