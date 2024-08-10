// 2233. Maximum Product After K Increments
package Medium;
import java.util.PriorityQueue;

public class Medium_2233_Maximum_Product_After_K_Increments {
    public static int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) minHeap.add(n);

        while (k-- > 0) minHeap.add(minHeap.remove()+1);
        long answer = 1;
        while (!minHeap.isEmpty()) {
            answer *= minHeap.poll();
            answer %= 1000000007;
        }
        return (int) answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{0,4},5));
        System.out.println(maximumProduct(new int[]{6,3,3,2},2));
    }
}
