// 2465. Number of Distinct Averages
package Easy;
import java.util.Arrays;
import java.util.HashSet;

public class Easy_2465_Number_of_Distinct_Averages {
    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Float> set = new HashSet<>();

        for (int i=0, j=nums.length-1; i<j; i++,j--)
            set.add((float)((nums[i]+nums[j]) / 2.0));
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(distinctAverages(new int[] {4,1,4,0,3,5}));
        System.out.println(distinctAverages(new int[] {1,100}));
        System.out.println(distinctAverages(new int[] {9,5,7,8,7,9,8,2,0,7}));
    }
}
