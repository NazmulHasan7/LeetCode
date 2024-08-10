// 2389. Longest Subsequence With Limited Sum
package Easy;
import java.util.Arrays;

public class Easy_2389_Longest_Subsequence_With_Limited_Sum {
    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int query : queries) {
            int count = 0, sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum <= query) count++;
            } answer[idx++] = count;
        } return answer;
    }
    public static int getCount(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while (start <= end) {
            int mid = (end+start) / 2;
            if (arr[mid] == target)
                return mid + 1;
            else if (arr[mid] < target)
                start = mid + 1;
            else end = mid - 1;
        } return end + 1;
    }
    public static int[] answerQueriesBetter(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for (int i=1; i<nums.length; i++)
            sumArr[i] = sumArr[i-1] + nums[i];

        int[] answer = new int[queries.length];
        int idx = 0;
        for (int query : queries)
            answer[idx++] = getCount(sumArr, query);
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueriesBetter(new int[]{4,5,2,1}, new int[]{3,10,21})));
        System.out.println(Arrays.toString(answerQueriesBetter(new int[]{2,3,4,5}, new int[]{1})));
    }
}
