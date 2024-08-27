// 733. Flood Fill
package Easy;
import java.util.Arrays;

public class Easy_733_Flood_Fill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        fill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    private static void fill(int[][] image, int sr, int sc, int orgColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != orgColor)
            return;
        image[sr][sc] = newColor;
        fill(image, sr-1, sc, orgColor, newColor);
        fill(image, sr+1, sc, orgColor, newColor);
        fill(image, sr, sc+1, orgColor, newColor);
        fill(image, sr, sc-1, orgColor, newColor);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));
    }
}
