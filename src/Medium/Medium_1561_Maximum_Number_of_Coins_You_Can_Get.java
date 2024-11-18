// 1561. Maximum Number of Coins You Can Get
package Medium;
import java.util.Arrays;

public class Medium_1561_Maximum_Number_of_Coins_You_Can_Get {
    public static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;

        // Since the array is sorted in ascending order
        // Alice takes the last one [largest]
        // I take the 2nd last one [2nd largest]
        // Bob takes the first one [smallest]

        int answer = 0;
        int I = n-2, B = 0;
        while (B < I) {
            answer += piles[I];
            I -= 2;
            B++;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(maxCoins(new int[]{2,4,5}));
        System.out.println(maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }
}
