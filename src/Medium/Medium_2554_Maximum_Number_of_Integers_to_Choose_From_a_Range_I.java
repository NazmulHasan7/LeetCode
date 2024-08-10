// 2554. Maximum Number of Integers to Choose From a Range I
package Medium;
import java.util.Arrays;

public class Medium_2554_Maximum_Number_of_Integers_to_Choose_From_a_Range_I {
    public static boolean contains(int[] arr, int num, int n) {
        int start = 0, end = n-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num)
                return true;
            if (arr[mid] < num)
                start = mid + 1;
            else end = mid - 1;
        } return false;
    }
    public static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0, i = 1, count = 0;
        int len = banned.length;

        while (i <= n) {
            if (!contains(banned, i, len)) {
                count++;
                sum += i;
                if (sum > maxSum)
                    return count-1;
            } i++;
        } return count;
    }
    public static int maxCountBetter(int[] banned, int n, int maxSum) {
        int sum = 0, count = 0;
        boolean []arr = new boolean[10001];
        for(int num : banned) arr[num] = true;

        for(int i=1; i<=n; i++){
            if(!arr[i]) {
                sum += i;
                if (sum > maxSum)
                    break;
                count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{1,6,5},5,6));
        System.out.println(maxCount(new int[]{1,2,3,4,5,6,7},8,1));
        System.out.println(maxCount(new int[]{11},7,50));
    }
}
