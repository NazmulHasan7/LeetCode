// 857. Minimum Cost to Hire K Workers
package Hard;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class Hard_857_Minimum_Cost_to_Hire_K_Workers {
    static class Worker {
        double baseWage;
        int quality;
        Worker (double baseWage, int quality) {
            this.baseWage = baseWage;
            this.quality = quality;
        }
    }
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i=0; i<n; i++) {
            workers[i] = new Worker((double) wage[i] / quality[i], quality[i]);
        }
        // Sort the array on the basis of wages in increasing order
        // As we aim to reduce the cost, choosing workers with low base wage would be wise
        Arrays.sort(workers, (w1, w2) -> Double.compare(w1.baseWage, w2.baseWage));

        // Maintain a max Heap based on the quality of the worker
        // To reduce the cost, remove the worker with maximum quality
        PriorityQueue<Worker> maxHeap = new PriorityQueue<>((w1, w2) -> (w2.quality - w1.quality));

        double minCost = Double.MAX_VALUE;
        int totalQuality = 0;
        for (Worker worker : workers) {
            maxHeap.add(worker);
            totalQuality += worker.quality;

            if (maxHeap.size() == k) {
                // Calculate the cost -> Worker array is sorted based on baseWage
                // The current worker should have the highest wage than the previous ones
                minCost = Math.min(minCost, totalQuality * worker.baseWage);
                // Remove the worker with the maximum quality, it could reduce the cost
                totalQuality -= Objects.requireNonNull(maxHeap.poll()).quality;
            }
        } return minCost;
    }
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{10,20,5},new int[]{70,50,30},2));
        System.out.println(mincostToHireWorkers(new int[]{3,1,10,10,1},new int[]{4,8,2,2,7},3));
    }
}
