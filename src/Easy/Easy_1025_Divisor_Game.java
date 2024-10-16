// 1025. Divisor Game
package Easy;

public class Easy_1025_Divisor_Game {
    public static boolean divisorGame(int n) {
        if (n == 2) return true; // Alice chooses 1, Bob has no choice, so Alice wins
        if (n <= 1) return false; // Alice has no choice, so Bob wins

        for (int x = 1; x < n; x++) {
            if (n % x == 0)
                return !divisorGame(n-x);
        }
        return false;

        // return n % 2 == 0;
    }
    public static void main(String[] args) {
        System.out.println(divisorGame(2));
        System.out.println(divisorGame(3));
    }
}
