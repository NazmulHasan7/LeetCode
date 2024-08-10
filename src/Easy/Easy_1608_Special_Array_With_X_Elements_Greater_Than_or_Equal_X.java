// 1608. Special Array With X Elements Greater Than or Equal X
package Easy;

public class Easy_1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    public static int getCount(int[] arr, int target) {
        int count = 0;
        for (int num : arr)
            if (num >= target)
                count++;
        return count;
    }
    public static int specialArray(int[] nums) {
        int start = 1, end = nums.length;
        int x;
        while (start <= end) {
            x = (start + end) / 2;
            int count = getCount(nums, x);
            if (x == count)
                return x;
            else if (x < count)
                start = x + 1;
            else end = x - 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3,5}));
        System.out.println(specialArray(new int[]{0,0}));
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
}
