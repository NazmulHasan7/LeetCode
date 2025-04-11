// 2780. Minimum Index of a Valid Split
package Medium;
import java.util.List;

public class Medium_2780_Minimum_Index_of_a_Valid_Split {
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        // use Bayer Moor's voting algorithm to find ME
        int ME = -1, count = 0;

        for (int num : nums) {
            if (count == 0) ME = num;
            if (ME == num) count++;
            else count--;
        }

        int meCount = 0; // count the frequency
        for (int num : nums)
            if (num == ME) meCount++;

        count = 0;
        for (int i=0; i<n; i++) {
            if (nums.get(i) == ME)
                count++;
            int remCount = meCount - count;

            // check if both partition is valid
            if (count * 2 > i+1 && remCount * 2 > n-i-1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(minimumIndex(List.of(1,2,2,2)));
        System.out.println(minimumIndex(List.of(2,1,3,1,1,1,7,1,2,1)));
        System.out.println(minimumIndex(List.of(3,3,3,3,7,2,2)));
    }
}
