// 1985. Find the Kth Largest Integer in the Array
package Medium;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Medium_1985_Find_the_Kth_Largest_Integer_in_the_Array {
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(
                (a,b) -> {
                    int aLen = a.length();
                    int bLen = b.length();
                    if (aLen == bLen) return a.compareTo(b);
                    return aLen - bLen;
                }
        );
        for (String num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.poll();
    }
    public String kthLargestNumberBetter(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                // First compare by length (descending order)
                if (num1.length() != num2.length()) {
                    return num2.length() - num1.length();
                } else {
                    // If lengths are the same, compare lexicographically (descending order)
                    return num2.compareTo(num1);
                }
            }
        }); // Return the k-th largest element
        return nums[k - 1];
    }
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"3","6","7","10"},4));
        System.out.println(kthLargestNumber(new String[]{"2","21","12","1"},3));
    }
}
