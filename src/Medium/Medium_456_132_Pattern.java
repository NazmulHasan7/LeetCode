// 456. 132 Pattern
package Medium;

public class Medium_456_132_Pattern {
    static class Pair {
        int num, min;
        public Pair (int num, int min) {
            this.num = num;
            this.min = min;
        }
    }
    public static boolean find132pattern(int[] nums) {
        // Pair [num, min in left], monotonic decreasing stack
        // 3,1,4,2 --> [3,3], [1,3], <-- popped both [4,1]
        Pair[] stack = new Pair[nums.length];
        int stackPtr = -1;
        int currentMin = nums[0];
        // i,j,k --> arr[i] < arr[k] < arr[j]
        for (int n : nums) {
            // Finding arr[k], where n => arr[j]
            while (stackPtr > -1 && stack[stackPtr].num <= n)
                stackPtr--;
            // Finding arr[i] where stack top => arr[j] and n => arr[k]
            if (stackPtr > -1 && stack[stackPtr].min < n)
                return true;
            stack[++stackPtr] = new Pair(n, currentMin);
            currentMin = Math.min(n, currentMin);
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(find132pattern(new int[] {1,2,3,4}));
        System.out.println(find132pattern(new int[] {3,1,4,2}));
        System.out.println(find132pattern(new int[] {-1,3,2,0}));
    }
}
