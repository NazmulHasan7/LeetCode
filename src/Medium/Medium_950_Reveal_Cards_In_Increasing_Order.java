// 950. Reveal Cards In Increasing Order
package Medium;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Medium_950_Reveal_Cards_In_Increasing_Order {
    public static int[] deckRevealedIncreasingOpt(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        int[] answer = new int[n];

        boolean skip = false;
        int i = 0, j= 0;

        while (i < n) {
            if (answer[j] == 0) {
                if (!skip) {
                    answer[j] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            // System.out.println(j);
            j = (j+1) % n;
        }
        return answer;
    }
    public static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] answer = new int[n];
        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        // store the indices in the queue
        for (int i=0; i<n; i++) queue.add(i);

        int i = 0;
        while (!queue.isEmpty()) {
            answer[queue.poll()] = deck[i];
            i++;

            if (!queue.isEmpty())
                queue.add(queue.poll());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1,1000})));
    }
}
