// 836. Rectangle Overlap
package Easy;

public class Easy_836_Rectangle_Overlap {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1x1 = rec1[0];
        int r1y1 = rec1[1];
        int r1x2 = rec1[2];
        int r1y2 = rec1[3];

        int r2x1 = rec2[0];
        int r2y1 = rec2[1];
        int r2x2 = rec2[2];
        int r2y2 = rec2[3];
        return (r1x1 < r2x2 && r1y1 < r2y2 && r1x2 > r2x1 && r1y2 > r2y1);
    }
    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[] {0,0,2,2}, new int[] {1,1,3,3}));
        System.out.println(isRectangleOverlap(new int[] {0,0,1,1}, new int[] {1,0,2,1}));
        System.out.println(isRectangleOverlap(new int[] {0,0,1,1}, new int[] {2,2,3,3}));
    }
}
