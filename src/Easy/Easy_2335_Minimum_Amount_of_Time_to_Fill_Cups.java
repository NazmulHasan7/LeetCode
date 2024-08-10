// 2335. Minimum Amount of Time to Fill Cups
package Easy;
import java.util.PriorityQueue;

public class Easy_2335_Minimum_Amount_of_Time_to_Fill_Cups {
    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));
        for (int x : amount) maxHeap.add(x);

        int time = 0;
        while (!maxHeap.isEmpty()) {
            int a = maxHeap.poll();
            int b = maxHeap.isEmpty() ? 0 : maxHeap.poll();
            if (a <= 0 && b <= 0) break;
            a--; b--; time++;
            maxHeap.add(a);
            maxHeap.add(b);
        } return time;
    }
    public int fillCupsBetter(int[] amount) {
        int time = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            if (amount[0] >= amount[1] && amount[2] >= amount[1]) {
                time++;
                amount[0]--;
                amount[2]--;
            } else if (amount[0] >= amount[2]) {
                time++;
                amount[0]--;
                amount[1]--;
            } else {
                time++;
                amount[1]--;
                amount[2]--;
            }
        } return time;
    }
    public static void main(String[] args) {
        System.out.println(fillCups(new int[]{1,4,2}));
        System.out.println(fillCups(new int[]{5,4,4}));
        System.out.println(fillCups(new int[]{5,0,0}));
    }
}
