// 1823. Find the Winner of the Circular Game
package Medium;
import java.util.ArrayDeque;

public class Medium_1823_Find_the_Winner_of_the_Circular_Game {
    // Simulation Approach -> O(n * k)
    public static int findTheWinner(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<=n; i++) queue.add(i);

        while (queue.size() > 1) {
            // Keep removing from front and add it to the end
            for (int i=0; i<k-1; i++)
                queue.addLast(queue.pollFirst());

            queue.pollFirst(); // remove the kth number
        }
        return queue.peek();
    }
    public static int findTheWinnerOpt(int n, int k) {
        return solve(n, k) + 1;
    }
    private static int solve(int n, int k) {
        if (n == 1) return 0;
        // original index in the previous array
        int idx = (solve(n-1, k) + k) % n;
        return idx;
    }
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
        System.out.println(findTheWinner(6,5));
    }
}
