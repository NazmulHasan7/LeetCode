// 1686. Stone Game VI
package Medium;
import java.util.Arrays;

public class Medium_1686_Stone_Game_VI {
    static class Pair {
        int sum, alice, bob;
        Pair (int alice, int bob) {
            this.sum = alice + bob;
            this.alice = alice;
            this.bob = bob;
        }
    }
    public static int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Pair[] arr = new Pair[n];

        for (int i=0; i<n; i++)
            arr[i] = new Pair(aliceValues[i], bobValues[i]);

        Arrays.sort(arr, (p1, p2) -> (p2.sum - p1.sum));

        boolean aliceTurn = true;
        int aliceScore = 0, bobScore = 0;
        for (int i=0; i<n; i++) {
            if (aliceTurn)
                aliceScore += arr[i].alice;
            else bobScore += arr[i].bob;
            aliceTurn = !aliceTurn;
        }
        return Integer.compare(aliceScore, bobScore);
    }
    public static void main(String[] args) {
        System.out.println(stoneGameVI(new int[]{1,3}, new int[]{2,1}));
        System.out.println(stoneGameVI(new int[]{1,2}, new int[]{3,1}));
        System.out.println(stoneGameVI(new int[]{2,4,3}, new int[]{1,6,7}));
    }
}
