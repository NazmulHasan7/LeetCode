// 3175. Find The First Player to win K Games in a Row
package Medium;
import java.util.ArrayDeque;
import java.util.Deque;

public class Medium_3175_Find_The_First_Player_to_win_K_Games_in_a_Row {
    // Simulation Approach -> TC & SC -> O(n)
    public static int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        if (k >= n) {
            // K >= n ? Player with maximum skill is the winner
            int maxi = 0;
            for (int i=1; i<n; i++)
                maxi = skills[i] > skills[maxi] ? i : maxi;
            return maxi;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<n; i++)
            queue.addLast(i);

        int winner = 0, winCount = 0;

        while (true) {
            int nextPlayer = queue.pollFirst();
            if (skills[winner] > skills[nextPlayer]) {
                winCount++;
                // otherwise add the loser to the end of queue
                queue.addLast(nextPlayer);
            } else {
                // previous winner loses, push him to the end of queue
                queue.addLast(winner);
                winner = nextPlayer;
                winCount = 1;
            }
            if (winCount == k) return winner;
        }
    }
    public static int findWinningPlayerOpt(int[] skills, int k) {
        // Instead of simulating the process, think about
        // If we cannot find the player with k wins in a single traversal, then player with maximum skill is the winner
        int n = skills.length;

        int winner = 0, winCount = 0;
        for (int i=1; i<n; i++) {
            if (skills[winner] < skills[i]) {
                winCount = 1;
                winner = i;
            } else {
                winCount++;
            }
            if (winCount >= k) break;
        }
        return winner;
    }
    public static void main(String[] args) {
        System.out.println(findWinningPlayer(new int[]{4,2,6,3,9},2));
        System.out.println(findWinningPlayer(new int[]{2,5,4},3));
    }
}
