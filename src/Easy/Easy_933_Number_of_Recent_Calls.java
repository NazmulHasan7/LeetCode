// 933. Number of Recent Calls
package Easy;
import java.util.LinkedList;
import java.util.Queue;

public class Easy_933_Number_of_Recent_Calls {
    static class RecentCounter {
        Queue<Integer> queue;
        public RecentCounter() {
            queue = new LinkedList<>();
        }
        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t-3000)
                queue.poll();
            System.out.println(queue.size());
            return queue.size();
        }
    }
    static class RecentCounterBetter {
        int[] queue;
        int front, back;
        public RecentCounterBetter() {
            queue = new int[10000];
            front = back = 0;
        }
        public int ping(int t) {
            queue[back++] = t;
            while (queue[front] < t-3000)
                front++;
            System.out.println(back-front);
            return back - front;
        }
    }
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);           // requests = [1], range is [-2999,1], return 1
        recentCounter.ping(100);         // requests = [1, 100], range is [-2900,100], return 2
        recentCounter.ping(3001);        // requests = [1, 100, 3001], range is [1,3001], return 3
        recentCounter.ping(3002);        // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        RecentCounterBetter recentCounterBetter = new RecentCounterBetter();
        recentCounterBetter.ping(1);     // requests = [1], range is [-2999,1], return 1
        recentCounterBetter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
        recentCounterBetter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
        recentCounterBetter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
