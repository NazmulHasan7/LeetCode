// 228. Summary Ranges
package Easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy_228_Summary_Ranges {
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int k = 0;
            while (i+k+1 < nums.length && nums[i+k]+1 == nums[i+k+1])
                k++;
            if (k > 0) {
                result.add(nums[i] + "->" + nums[i+k]);
                i = i+k;
            } else result.add(String.valueOf(nums[i]));
            // System.out.println(result);
        } return result;
    }
    public static List<String> summaryRangesBetter(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        for (int i=0, k=1; k<=nums.length; ) {
            if (k < nums.length && nums[k-1]+1 == nums[k]) k++;
            else {
                StringBuilder sb = new StringBuilder();
                if (nums[k-1] == nums[i])
                    sb.append(nums[i]);
                else sb.append(nums[i]).append("->").append(nums[k-1]);
                i=k; k=i+1;
                result.add(sb.toString());
            }
        } return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(summaryRanges(new int[] {0,1,2,4,5,7}).toArray()));
        System.out.println(Arrays.toString(summaryRanges(new int[] {0,2,3,4,6,8,9}).toArray()));
        System.out.println(summaryRangesBetter(new int[] {0,1,2,4,5,7}));
        System.out.println(summaryRangesBetter(new int[] {0,2,3,4,6,8,9}));
    }
}
