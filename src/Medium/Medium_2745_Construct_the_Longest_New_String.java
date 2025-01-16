// 2745. Construct the Longest New String
package Medium;

public class Medium_2745_Construct_the_Longest_New_String {
    public static int longestString(int x, int y, int z) {
        if (x == y)
            return 4*x + 2*z;
        return Math.min(x, y)*4 + 2 + 2*z;
    }
    public static void main(String[] args) {
        System.out.println(longestString(2,5,1));
        System.out.println(longestString(3,2,2));
    }
}
