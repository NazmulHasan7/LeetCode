// 2640. Find the Score of All Prefixes of an Array
package Medium;
import java.util.Arrays;

public class Medium_2640_Find_the_Score_of_All_Prefixes_of_an_Array {
    public static long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] conver = new long[n];

        int max = nums[0];
        conver[0] = nums[0] + nums[0];

        for (int i=1; i<n; i++) {
            if (nums[i] > max) max = nums[i];
            conver[i] = max + nums[i];
            conver[i] += conver[i-1];
        }
        return conver;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPrefixScore(new int[]{2,3,7,5,10})));
        System.out.println(Arrays.toString(findPrefixScore(new int[]{1,1,2,4,8,16})));
    }
}
