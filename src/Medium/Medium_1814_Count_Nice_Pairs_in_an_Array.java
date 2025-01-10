// 1814. Count Nice Pairs in an Array
package Medium;
import java.util.HashMap;

public class Medium_1814_Count_Nice_Pairs_in_an_Array {
    public static int countNicePairs(int[] nums) {
        // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        // => nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        HashMap<Integer, Integer> map = new HashMap<>();

        int answer = 0;
        for (int n : nums) {
            int r = reverse(n) - n;
            int c = map.getOrDefault(r, 0);
            answer = (answer + c) % 1000000007;
            map.put(r, c+1);
        }
        return answer;
    }
    private static int reverse(int num) {
        int revNum = 0;
        while (num != 0) {
            int dig = num % 10;
            num /= 10;
            revNum = revNum * 10 + dig;
        }
        return revNum;
    }
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{42,11,1,97}));
        System.out.println(countNicePairs(new int[]{13,10,35,24,76}));
    }
}
