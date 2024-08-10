// 832. Flipping an Image
package Easy;
import java.util.Arrays;

public class Easy_832_Flipping_an_Image {
    public static int[][] flipAndInvertImage(int[][] image) {
        int temp;
        for (int i=0; i<image.length; i++) {
            for (int j=0, k=image[i].length-1; j<=k; j++, k--) {
                temp = image[i][j];
                image[i][j] = (image[i][k] == 0) ? 1 : 0;
                image[i][k] = (temp == 0) ? 1 : 0;
            }
        } return image;
    }
    public static void main(String[] args) {
        int[][] arr = flipAndInvertImage(new int[][] {{1,1,0}, {1,0,1}, {0,0,0}});
        for (int[] a : arr)
            System.out.println(Arrays.toString(a));
    }
}
