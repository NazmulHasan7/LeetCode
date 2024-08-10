// 1725. Number Of Rectangles That Can Form The Largest Square
package Easy;

public class Easy_1725_Number_Of_Rectangles_That_Can_Form_The_Largest_Square {
    public static int countGoodRectangles(int[][] rectangles) {
        int maxSize = Integer.MIN_VALUE;
        int count = 0;
        int size;
        for (int[] rec : rectangles) {
            size = Math.min(rec[0], rec[1]);
            if (size > maxSize) {
                maxSize = size;
                count = 1;
            }
            else if (size == maxSize) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countGoodRectangles(
                new int[][] {{5,8},{3,9},{5,12},{16,5}}));
        System.out.println(countGoodRectangles(
                new int[][] {{2,3},{3,7},{4,3},{3,7}}));
    }
}
