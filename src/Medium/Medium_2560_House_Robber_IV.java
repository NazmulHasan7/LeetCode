// Medium 2560. House Robber IV
package Medium;

public class Medium_2560_House_Robber_IV {
    public static boolean canRob(int[] arr, int k, int capacity) {
        int houseCount = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= capacity) {
                i++; // Robber refuses to rob consecutive houses
                houseCount++;
                if (houseCount == k) return true;
            }
        } return houseCount >= k;
    }
    public static int minCapability(int[] nums, int k) {
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (int n : nums) {
            start = Math.min(start, n);
            end = Math.max(end, n);
        }
        int answer = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canRob(nums, k, mid)) {
                answer = mid;
                end = mid - 1;
            } else start = mid + 1;
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2,3,5,9},2));
        System.out.println(minCapability(new int[]{2,7,9,3,1},2));
    }
}
