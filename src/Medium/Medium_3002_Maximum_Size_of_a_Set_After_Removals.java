// 3002. Maximum Size of a Set After Removals
package Medium;
import java.util.HashSet;

public class Medium_3002_Maximum_Size_of_a_Set_After_Removals {
    public static int maximumSetSize(int[] nums1, int[] nums2) {
        HashSet<Integer> finalSet = new HashSet<>();

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            finalSet.add(num);
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            finalSet.add(num);
            set2.add(num);
        }

        int size = 0;
        int maxSize = nums1.length / 2;
        size += Math.min(set1.size(), maxSize);
        size += Math.min(set2.size(), maxSize);

        return Math.min(finalSet.size(), size);
    }
    // space optimized
    public static int maximumSetSizeOpt(int[] nums1, int[] nums2) {
        int size = 0;
        int maxSize = nums1.length / 2;

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);

        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                set2.add(num);
            } else if (set1.size() > maxSize) {
                set1.remove(num);
                set2.add(num);
            }
        }
        size += Math.min(set1.size(), maxSize);
        size += Math.min(set2.size(), maxSize);
        return size;
    }
    public static void main(String[] args) {
        System.out.println(maximumSetSize(new int[]{1,2,1,2}, new int[]{1,1,1,1}));
        System.out.println(maximumSetSize(new int[]{1,2,3,4,5,6}, new int[]{2,3,2,3,2,3}));
        System.out.println(maximumSetSize(new int[]{1,1,2,2,3,3}, new int[]{4,4,5,5,6,6}));
    }
}
