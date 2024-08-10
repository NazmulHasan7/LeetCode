// 713. Sub-array Product Less Than K
package Medium;

public class Medium_713_Subarray_Product_Less_Than_K {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, right = 0, answer = 0;
        int prod = 1;

        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            answer += (right-left+1);
            right++;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
        System.out.println(numSubarrayProductLessThanK(new int[]{1,1,1}, 1));
    }
}
