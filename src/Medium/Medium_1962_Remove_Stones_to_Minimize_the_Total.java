// 1962. Remove Stones to Minimize the Total
package Medium;
import java.util.PriorityQueue;

public class Medium_1962_Remove_Stones_to_Minimize_the_Total {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for (int x : piles) maxHeap.add(x);

        while (k-- > 0 && !maxHeap.isEmpty()) {
            int remove = maxHeap.poll();
            maxHeap.add(remove - remove/2);
        }
        int sum = 0;
        for (int x : maxHeap) sum += x;
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5,4,9},2));
        System.out.println(minStoneSum(new int[]{4,3,6,7},3));
    }
}
