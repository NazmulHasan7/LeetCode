// 391. Perfect Rectangle
package Hard;
import java.util.HashSet;

public class Hard_391_Perfect_Rectangle {
    public static boolean isRectangleCover(int[][] rectangles) {
        HashSet<String> set = new HashSet<>();
        long area = 0;

        // keeps track of the largest rectangle
        int lx = Integer.MAX_VALUE;
        int rx = Integer.MIN_VALUE;
        int by = Integer.MAX_VALUE;
        int ty = Integer.MIN_VALUE;

        for (int[] coordinates : rectangles) {
            int xi = coordinates[0];
            int yi = coordinates[1];
            int ai = coordinates[2];
            int bi = coordinates[3];

            lx = Math.min(lx, xi);
            rx = Math.max(rx, ai);
            by = Math.min(by, yi);
            ty = Math.max(ty, bi);

            String bottomLeft = xi + "_" + yi;
            if (set.contains(bottomLeft))
                set.remove(bottomLeft);
            else set.add(bottomLeft);

            String bottomRight = ai + "_" + yi;
            if (set.contains(bottomRight))
                set.remove(bottomRight);
            else set.add(bottomRight);

            String topLeft = xi + "_" + bi;
            if (set.contains(topLeft))
                set.remove(topLeft);
            else set.add(topLeft);

            String topRight = ai + "_" + bi;
            if (set.contains(topRight))
                set.remove(topRight);
            else set.add(topRight);

            area += (long) (ai - xi) * (bi - yi);
        }

        // since we removed all the duplicates, the set is expected to contain only the 4 points of large rectangle
        if (set.size() == 4 && set.contains(lx + "_" + by) && set.contains(lx + "_" + ty) &&
                set.contains(rx + "_" + by) && set.contains(rx + "_" + ty))
            return area == (long) (rx - lx) * (ty-by); // check if areas are same

        return false;
    }
    public static void main(String[] args) {
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}}));
        System.out.println(isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}}));
    }
}
