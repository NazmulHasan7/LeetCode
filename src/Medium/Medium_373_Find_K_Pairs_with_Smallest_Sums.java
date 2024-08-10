// 373. Find K Pairs with Smallest Sums
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Medium_373_Find_K_Pairs_with_Smallest_Sums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // Maintain a min heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a,b) -> (a[0]+a[1]) - (b[0]+b[1]));

        // Pairs --> {n1[0], n2[0]}, {n1[1], n2[0]}, {n1[2], n2[0]} .......
        // Since the array is sorted order we need to check the first k numbers only
        for (int i=0; i<k && i<nums1.length; i++)
            minHeap.add(new int[] {nums1[i], nums2[0], 0});

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            result.add(Arrays.asList(current[0], current[1]));
            // We have already added all the nums1[i] paired with nums[0] to the heap
            // Check if the index is within the range of nums[2] keep adding
            if (current[2] < nums2.length - 1) {
                minHeap.add(new int[] { current[0], nums2[current[2]+1], current[2]+1 });
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<Integer>>  res1 = kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3);
        for (List<Integer> arr : res1)
            System.out.println(arr);
        List<List<Integer>>  res2 = kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},3);
        for (List<Integer> arr : res2)
            System.out.println(arr);
    }
}
