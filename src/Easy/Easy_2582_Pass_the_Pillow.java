// 2582. Pass the Pillow
package Easy;

public class Easy_2582_Pass_the_Pillow {
    public static int passThePillow(int n, int time) {
        // To travel 1 to n or n to 1 -> requires n-1 pass
        boolean evenLoop = (time / (n-1)) % 2 == 0;
        if (evenLoop)
            // If loop count is even -> forward direction
            return 1 + (time % (n-1));
            // reverse direction
        else return n - (time % (n-1));
    }
    public static void main(String[] args) {
        System.out.println(passThePillow(4,5));
        System.out.println(passThePillow(3,2));
    }
}
