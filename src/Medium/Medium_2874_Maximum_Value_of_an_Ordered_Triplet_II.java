// 2874. Maximum Value of an Ordered Triplet II
package Medium;

public class Medium_2874_Maximum_Value_of_an_Ordered_Triplet_II {
    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        // prefix max array -> keep track of max elements in before indices
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        // postfix max array -> keep track of max elements in before indices
        int[] postfix = new int[n];
        postfix[n-1] = nums[n-1];

        for (int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], nums[i]);
            postfix[n-i-1] = Math.max(postfix[n-i], nums[n-i-1]);
        }
        long answer = 0;

        for (int j=1; j<n-1; j++) {
            int i = j-1;
            int k = j+1;
            answer = Math.max(answer, (long)(prefix[i]-nums[j])*postfix[k]);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println(maximumTripletValue(new int[]{1,2,3}));
    }
}
