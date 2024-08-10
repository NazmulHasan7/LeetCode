// 303. Range Sum Query - Immutable
package Easy;

public class Easy_303_Range_Sum_Query_Immutable {
    static class NumArray {
        // int[] arr;
        int[] prefixSum;
        public NumArray(int[] nums) {
            // this.arr = nums;
            prefixSum = nums;
            for (int i=1; i<nums.length; i++)
                prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        public int sumRange(int left, int right) {
            // int sum = 0;
            // for (int i=left; i<=right; i++)
            //   sum += arr[i];
            if (left == 0) return prefixSum[right];
            else return prefixSum[right] - prefixSum[left-1];
        }
    }
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
