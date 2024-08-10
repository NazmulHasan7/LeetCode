// 704. Binary Search
package Easy;

public class Easy_704_Binary_Search {
    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else start = mid + 1;
        } return -1;
    }
    public static void main(String[] args) {
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[] {-1,0,3,5,9,12}, 2));
    }
}
