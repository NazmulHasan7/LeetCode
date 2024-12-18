// 2917. Find the K-or of an Array
package Easy;

public class Easy_2917_Find_the_K_or_of_an_Array {
    public static int findKOr(int[] nums, int k) {
        int answer = 0;
        for (int i=0; i<32; i++) {
            int count = 0;
            for (int n : nums) {
                // Check if the ith bit is set or not
                if ((n & (1 << i)) != 0)
                    count++;
                if (count >= k) {
                    answer |= (1 << i);
                    break;
                }
            }
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(findKOr(new int[]{7,12,9,8,9,15},4));
        System.out.println(findKOr(new int[]{2,12,1,11,4,5},6));
        System.out.println(findKOr(new int[]{10,8,5,9,11,6,8},1));
    }
}
