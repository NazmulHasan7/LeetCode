// 806. Number of Lines To Write String
package Easy;
import java.util.Arrays;

public class Easy_806_Number_of_Lines_To_Write_String {
    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 0, pixels = 0, width;
        for (char c : s.toCharArray()) {
            width = widths[c-'a'];
            if (pixels + width <= 100)
                pixels += width;
            else {
                lines++;
                pixels = width;
            }
        } if (pixels > 0) lines++;
        return new int[] {lines, pixels};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(
                new int[] {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(Arrays.toString(numberOfLines(
                new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "bbbcccdddaaa")));
    }
}
