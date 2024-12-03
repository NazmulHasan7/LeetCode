// 135. Candy
package Hard;
import java.util.Arrays;

public class Hard_135_Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        // count of candies for each child
        int[] candies = new int[n];
        // initially all the child has 1 candy
        Arrays.fill(candies,1);

        // Traverse LTR only comparing with the right child
        for (int i=1; i<n; i++)
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;

        // Traverse RTL only comparing with the left child
        for (int i=n-2; i>=0; i--)
            if (ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);

        int answer = 0;
        for (int c : candies) answer += c;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,0,2}));
        System.out.println(candy(new int[]{1,2,2}));
    }
}
