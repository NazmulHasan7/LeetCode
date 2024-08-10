// 502. IPO
package Hard;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Hard_502_IPO {
    static class Pair {
        int capital, profit;
        Pair (int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Pair> arr = new ArrayList<>();
        for (int i=0; i<n; i++)
            arr.add(new Pair(capital[i], profits[i]));

        // Sort the array based on capital in increasing order
        arr.sort((a, b) -> (a.capital - b.capital));
        // The projects we are able to take currently are pushed in the heap
        // Maintain a max heap so that projects with maximum profit is always at the root
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        int idx = 0;
        while (k-- > 0) {
            while (idx < n && arr.get(idx).capital <= w) {
                maxHeap.add(arr.get(idx).profit);
                idx++;
            }
            if (maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
    public static void main(String[] args) {
        System.out.println(findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
        System.out.println(findMaximizedCapital(3,0,new int[]{1,2,3},new int[]{0,1,2}));
    }
}
