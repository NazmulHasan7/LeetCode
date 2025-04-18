// 1865. Finding Pairs With a Certain Sum
package Medium;
import java.util.HashMap;

public class Medium_1865_Finding_Pairs_With_a_Certain_Sum {
    static class FindSumPairs {
        private int[] nums1;
        private int[] nums2;
        private HashMap<Integer, Integer> map;

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.map = new HashMap<>();

            for (int num : nums2)
                this.map.put(num, this.map.getOrDefault(num, 0)+1);
        }

        public void add(int index, int val) {
            int oldValue = this.nums2[index];
            int oldCount = this.map.getOrDefault(oldValue, 0);
            if (oldCount > 0)
                this.map.put(oldValue, this.map.get(oldValue)-1);

            this.nums2[index] += val;
            this.map.put(nums2[index], this.map.getOrDefault(nums2[index],0)+1);
        }

        public int count(int tot) {
            int count = 0;
            for (int num : this.nums1)
                if (this.map.containsKey(tot-num))
                    count += this.map.get(num);

            return count;
        }

        public static void main(String[] args) {
            FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
            findSumPairs.count(7);  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
            findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
            findSumPairs.count(8);  // return 2; pairs (5,2), (5,4) make 3 + 5
            findSumPairs.count(4);  // return 1; pair (5,0) makes 3 + 1
            findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
            findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
            findSumPairs.count(7);
        }
    }
}
