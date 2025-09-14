// 396. Rotate Function
package Medium;

public class Medium_396_Rotate_Function {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sumOfArray = 0;
        int f0 = 0;

        for (int i=0; i<n; i++) {
            sumOfArray += nums[i];
            f0 += i * nums[i];
        }
        int answer = f0;
        int rightSum = 0;
        for (int i=1; i<n; i++) {
            rightSum += nums[n-i];
            int fi = f0 + i*sumOfArray - n*rightSum;
            // System.out.println(fi);
            answer = Math.max(answer, fi);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
        System.out.println(maxRotateFunction(new int[]{100}));
    }
}
