// 152. Maximum Product Sub-array
package Medium;

public class Medium_152_Maximum_Product_Subarray {
    /**
     * A negative number can turn a large product into a small one,
     * but it can also make a smaller negative product into a larger positive one.
     * Thus, the approach needs to account for both forward and backward passes through the array
     * to capture the effects of negative numbers and zeros.
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int prefixProd = 1, suffixProd = 1;

        int answer = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            if (prefixProd == 0)
                prefixProd = 1;
            if (suffixProd == 0)
                suffixProd = 1;

            prefixProd = prefixProd * nums[i];
            suffixProd = suffixProd * nums[n-i-1];
            answer = Math.max(answer, Math.max(prefixProd, suffixProd));
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }
}
