// 453. Minimum Moves to Equal Array Elements
package Medium;

public class Medium_453_Minimum_Moves_to_Equal_Array_Elements {
    /* Let's assume after k operations, all the number will be x
    Before the operations, the sum is -> total
    After k operations the sum will be -> n * x (all numbers are same)

    After 1 operation, sum becomes -> total + (n-1)
    After k operations, sum becomes -> total + (n-1) * k == n * x

    After k operations the minimum number will be equal to x
    So, x = min + k
    total + (n-1) * k = n * x
    => total + (n-1) * k = (min + k) * n
    => total + kn - k = min * n + kn
    => total - k = min * n
    => k = total - min * n
    */
    public static int minMoves(int[] nums) {
        int total = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            total += num;
            min = Math.min(min, num);
        }
        return total - min * n;
    }
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(minMoves(new int[]{1,1,1}));
    }
}
