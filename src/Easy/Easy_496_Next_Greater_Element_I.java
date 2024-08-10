// 496. Next Greater Element I
package Easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Easy_496_Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n2 : nums2) {
            // For decreasing elements [6,5,4,3,2,1,7] -> [7,7,7,7,7]
            while (!stack.isEmpty() && stack.peek() < n2)
                map.put(stack.pop(), n2);
            stack.push(n2);
        }
        for (int i=0; i<nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
    public static int[] nextGreaterElementBetter(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int nextGreat;
        for (int i=0; i<nums2.length; i++) {
            nextGreat = -1;
            for (int j=i+1; j<nums2.length; j++) {
                if (nums2[i] < nums2[j]) {
                    nextGreat = nums2[j];
                    break;
                }
            } map.put(nums2[i], nextGreat);
        }
        for (int i=0; i<nums1.length; i++)
            nums1[i] = map.get(nums1[i]);
        return nums1;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(
                new int[] {4,1,2}, new int[] {1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(
                new int[] {2,4}, new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(nextGreaterElementBetter(
                new int[] {4,1,2}, new int[] {1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElementBetter(
                new int[] {2,4}, new int[] {1,2,3,4})));
    }
}
