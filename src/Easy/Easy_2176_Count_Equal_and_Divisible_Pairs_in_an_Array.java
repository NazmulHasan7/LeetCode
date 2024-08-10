// 2176. Count Equal and Divisible Pairs in an Array
package Easy;

public class Easy_2176_Count_Equal_and_Divisible_Pairs_in_an_Array {
    public static int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] == nums[j] && (i*j) % k == 0)
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPairs(new int[] {3,1,2,2,2,1,3}, 2));
        System.out.println(countPairs(new int[] {1,2,3,4}, 1));
    }
}
