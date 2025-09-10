// 390. Elimination Game
package Medium;

public class Medium_390_Elimination_Game {
    public static int lastRemaining(int n) {
        int remains = n;
        int head = 1;
        int gap = 1;
        boolean l2r = true;

        // eliminate (2k+1) == eliminate (2k)
        while (remains > 1) {
            if (l2r)
                head += gap;
            else if (remains % 2 == 1)
                head += gap;

            gap *= 2;
            remains /= 2;
            l2r = !l2r;
        }
        return head;
    }
    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(1));
    }
}
