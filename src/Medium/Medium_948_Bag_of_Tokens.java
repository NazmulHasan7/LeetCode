// 948. Bag of Tokens
package Medium;
import java.util.Arrays;

public class Medium_948_Bag_of_Tokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int score = 0, maxScore = 0;

        int i = 0, j = n-1;
        while (i<=j) {
            if (tokens[i] <= power) {
                score++;
                power -= tokens[i];
                i++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                score--;
                power += tokens[j];
                j--;
            } else {
                return maxScore;
            }
        } return maxScore;
    }
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{200,100}, 150));
        System.out.println(bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }
}
