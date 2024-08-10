// 2529. Maximum Count of Positive Integer and Negative Integer
package Easy;

public class Easy_2529_Maximum_Count_of_Positive_Integer_and_Negative_Integer {
    public static int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num < 0) neg++;
            else if (num > 0) pos++;
        } return Math.max(pos, neg);
    }
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[] {-2,-1,-1,1,2,3}));
        System.out.println(maximumCount(new int[] {-3,-2,-1,0,0,1,2}));
        System.out.println(maximumCount(new int[] {5,20,66,1314}));
    }
}
