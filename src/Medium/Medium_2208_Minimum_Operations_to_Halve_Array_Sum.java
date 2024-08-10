// 2208. Minimum Operations to Halve Array Sum
package Medium;
import java.util.PriorityQueue;

public class Medium_2208_Minimum_Operations_to_Halve_Array_Sum {
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b,a));
        double sum = 0;
        for (int x : nums) {
            sum += x;
            maxHeap.add((double)x);
        }
        double halfSum = sum / 2.0;
        int ops = 0;
        while (sum > halfSum && !maxHeap.isEmpty()) {
            ops++;
            double x = maxHeap.poll();
            x /= 2.0;
            sum -= x;
            maxHeap.add(x);
        }
        return ops;
    }
    public static void main(String[] args) {
        System.out.println(halveArray(new int[]{5,19,8,1}));
        System.out.println(halveArray(new int[]{3,8,20}));
    }
}
