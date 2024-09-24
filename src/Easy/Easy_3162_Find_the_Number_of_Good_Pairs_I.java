// 3162. Find the Number of Good Pairs I
package Easy;

public class Easy_3162_Find_the_Number_of_Good_Pairs_I {
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for (int value : nums1)
            for (int i : nums2)
                if (value % (i * k) == 0)
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{1,3,4}, new int[]{1,3,4}, 1));
        System.out.println(numberOfPairs(new int[]{1,2,4,12}, new int[]{2,4}, 3));
    }
}