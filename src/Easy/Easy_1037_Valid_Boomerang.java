// 1037. Valid Boomerang
package Easy;

public class Easy_1037_Valid_Boomerang {
    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0], y1 = points[0][1];
        int x2 = points[1][0], y2 = points[1][1];
        int x3 = points[2][0], y3 = points[2][1];
        return (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) != 0;
    }
    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][] {{1,1}, {2,3}, {3,2}}));
        System.out.println(isBoomerang(new int[][] {{1,1}, {2,2}, {3,3}}));
    }
}
