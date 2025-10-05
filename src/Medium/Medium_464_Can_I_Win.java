// 464. Can I Win
package Medium;

public class Medium_464_Can_I_Win {
    private static Boolean[] memo;
    public static boolean canIWin(int max, int desiredTotal) {
        if (desiredTotal <= max) return true;
        // Check if the game is playable
        // Sum of the all the numbers from 1 to max -> n * (n+1) / 2
        if (max * (max + 1) / 2 < desiredTotal)
            return false;

        memo = new Boolean[1 << max + 1];
        // Masking -> used mask -> initially 0 -> when the number is used -> set the bit to 1
        // bit 0 -> unused, bit 1 -> used
        return solve(max, desiredTotal, 0);
    }
    private static boolean solve(int max, int total, int usedMask) {
        // if the desired total is already reached, the current player loses to prev player
        if (total <= 0) return false;
        if (memo[usedMask] != null) return memo[usedMask];

        for (int i=1; i<=max; i++) {
            int currentBit = 1 << i;
            if ((usedMask & currentBit) == 0) { // numbers cannot be reused
                boolean opponent = solve(max, total-i, usedMask | currentBit);
                if (!opponent) {
                    memo[usedMask] = true;
                    return true;
                }
            }
        }
        memo[usedMask] = false;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(canIWin(10, 11));
        System.out.println(canIWin(10, 0));
        System.out.println(canIWin(10, 1));
    }
}