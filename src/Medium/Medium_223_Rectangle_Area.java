// 223. Rectangle Area
package Medium;

public class Medium_223_Rectangle_Area {
    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int totalArea = (ax2-ax1) * (ay2-ay1) + ((bx2-bx1) * (by2-by1));
        // check for overlap, considering rec1 left up right down
        if (!(ax2 < bx1 || ay1 > by2 || bx2 < ax1 || by1 > ay2)) {
            // has overlap
            int y2 = Math.min(ay2, by2);
            int y1 = Math.max(ay1, by1);
            int x2 = Math.min(ax2, bx2);
            int x1 = Math.max(ax1, bx1);
            return totalArea - ((x2-x1) * (y2-y1));
        }
        return totalArea;
    }
    public static void main(String[] args) {
        System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
        System.out.println(computeArea(-2,-2,2,2,-2,-2,2,2));
    }
}
