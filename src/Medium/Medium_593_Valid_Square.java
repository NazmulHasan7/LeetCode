// 593. Valid Square
package Medium;
import java.util.HashSet;

public class Medium_593_Valid_Square {
    private static double distance(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1,2));
    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Double> set = new HashSet<>();
        set.add(distance(p1, p2));
        set.add(distance(p1, p3));
        set.add(distance(p1, p4));
        set.add(distance(p2, p3));
        set.add(distance(p2, p4));
        set.add(distance(p3, p4));
        // A valid square has 2 different distance 4 equal sides, 2 equal diagonals
        return set.size() == 2 && !set.contains((double)0);
    }
    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
        System.out.println(validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,12}));
        System.out.println(validSquare(new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1}));
    }
}
