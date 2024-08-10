// 2090. K Radius Sub-array Averages
package Medium;
import java.util.Arrays;

public class Medium_2090_K_Radius_Subarray_Averages {
    public static int[] getAverages(int[] nums, int k) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);

        int windowSize = 2*k+1;
        if (windowSize > nums.length) return answer;

        long windowSum = 0;
        for (int i=0; i<windowSize; i++)
            windowSum += nums[i];

        answer[k++] = (int)(windowSum / windowSize);
        int left = 0, right = windowSize;
        while (right < nums.length) {
            windowSum += nums[right++];
            windowSum -= nums[left++];
            answer[k++] = (int)(windowSum / windowSize);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAverages(new int[]{7,4,3,9,1,8,5,2,6},3)));
        System.out.println(Arrays.toString(getAverages(new int[]{100000},0)));
        System.out.println(Arrays.toString(getAverages(new int[]{8},100000)));
    }
}
