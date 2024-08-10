// 888. Fair Candy Swap
package Easy;
import java.util.Arrays;
import java.util.HashSet;

public class Easy_888_Fair_Candy_Swap {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        for (int as : aliceSizes)
            aliceSum += as;

        int bobSum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int bs : bobSizes) {
            bobSum += bs;
            set.add(bs);
        }
        int difference = (aliceSum - bobSum) / 2;
        for (int as : aliceSizes)
            if (set.contains(as-difference))
                return new int[]{as, as-difference};

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{1,2}, new int[]{2,3})));
        System.out.println(Arrays.toString(fairCandySwap(new int[]{2}, new int[]{1,3})));
    }
}
