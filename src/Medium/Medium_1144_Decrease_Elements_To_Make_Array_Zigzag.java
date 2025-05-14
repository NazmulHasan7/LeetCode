// 1144. Decrease Elements To Make Array Zigzag
package Medium;

public class Medium_1144_Decrease_Elements_To_Make_Array_Zigzag {
    public static int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        // Only decreasing is allowed
        // Every even-indexed element is greater than adjacent elements
        // OR, every odd-indexed element is greater than adjacent elements

        int moveCase1 = 0;
        int prev = 0;
        for (int i=0; i<n; i+=2) {
            int curr = nums[i];
            int next = i+1 < n ? nums[i+1] : 0;

            if (prev >= curr)
                moveCase1 += (prev - curr + 1);
            if (next >= curr) {
                moveCase1 += (next - curr + 1);
                next =  curr - 1;
            }
            prev = next; // update the prev
        }

        int moveCase2 = 0;
        prev = nums[0];
        for (int i=1; i<n; i+=2) {
            int curr = nums[i];
            int next = i+1 < n ? nums[i+1] : 0;

            if (prev >= curr)
                moveCase2 += (prev - curr + 1);
            if (next >= curr) {
                moveCase2 += (next - curr + 1);
                next = curr - 1;
            }
            prev = next;
        }
        return Math.min(moveCase1, moveCase2);
    }
    public static void main(String[] args) {
        System.out.println(movesToMakeZigzag(new int[]{1,2,3}));
        System.out.println(movesToMakeZigzag(new int[]{9,6,1,6,2}));
        System.out.println(movesToMakeZigzag(new int[]{10,4,4,10,10,6,2,3}));
        System.out.println(movesToMakeZigzag(new int[]{2,7,10,9,8,9}));
    }
}
