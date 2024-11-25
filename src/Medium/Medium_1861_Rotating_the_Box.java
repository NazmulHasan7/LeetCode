// 1861. Rotating the Box
package Medium;
import java.util.Arrays;

public class Medium_1861_Rotating_the_Box {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        for (int r=0; r<m; r++) {
            int emptyCell = n-1; // denotes the empty cell
            for (int c=n-1; c>=0; c--) {
                if (box[r][c] == '*') {
                    emptyCell = c - 1;
                } else if (box[r][c] == '#') {
                    box[r][c] = '.';
                    box[r][emptyCell] = '#';
                    emptyCell--;
                }
            }
        }
        char[][] result = new char[n][m];
        for (int r=0; r<m; r++)
            for (int c=0; c<n; c++)
                result[c][m-1-r] = box[r][c];

        return result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{'#','.','#'}})));
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{'#','.','*','.'},{'#','#','*','.'}})));
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'},
        })));
    }
}
