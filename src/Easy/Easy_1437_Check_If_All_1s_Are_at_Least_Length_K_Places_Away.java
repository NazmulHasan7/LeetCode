// 1437. Check If All 1's Are at Least Length K Places Away
package Easy;

public class Easy_1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away {
    public static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        // To handle the first appearance of 1
        int lastIdx = -(2*n);

        for (int i=0; i<n; i++) {
            if (nums[i] == 1) {
                if (i - lastIdx <= k)
                    return false;
                lastIdx = i;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1,0,0,0,1,0,0,1},2));
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,1},2));
    }
}
