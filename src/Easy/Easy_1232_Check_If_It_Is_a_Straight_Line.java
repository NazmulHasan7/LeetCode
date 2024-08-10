// 1232. Check If It Is a Straight Line
package Easy;

public class Easy_1232_Check_If_It_Is_a_Straight_Line {
    public static boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];

        int xi, yi;
        for (int i=2; i<coordinates.length; i++) {
            xi = coordinates[i][0];
            yi = coordinates[i][1];
            if ((y1 - y0) * (x1 - xi) != (y1 - yi) * (x1 - x0))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][] {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(checkStraightLine(new int[][] {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
        System.out.println(checkStraightLine(new int[][] {{0,0},{0,1},{0,-1}}));
    }
}
