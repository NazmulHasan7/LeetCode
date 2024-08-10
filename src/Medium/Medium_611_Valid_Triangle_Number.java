// 611. Valid Triangle Number
package Medium;
import java.util.Arrays;

public class Medium_611_Valid_Triangle_Number {
    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        int start, end;

        for (int i=nums.length-1; i>=2; i--) {
            start = 0;
            end = i-1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    // As the array is sorted, all the elements between start and end
                    // can form a valid triangle where nums[i] is the longest side
                    count += end - start;
                    end--;
                } else { start++; }
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
        System.out.println(triangleNumber(new int[]{4,2,3,4}));
    }
}
