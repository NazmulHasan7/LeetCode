// 2498. Frog Jump II
package Medium;

public class Medium_2498_Frog_Jump_II {
    public static int maxJump(int[] stones) {
        // Minimum cost of a path
        int n = stones.length;
        int answer = stones[1] - stones[0];

        // Alternative stones
        for (int i=2; i<n; i++)
            answer = Math.max(answer, stones[i] - stones[i-2]);

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxJump(new int[]{0,2,5,6,7}));
        System.out.println(maxJump(new int[]{0,3,9}));
    }
}
