// 812. Largest Triangle Area
package Easy;

public class Easy_812_Largest_Triangle_Area {
    public static double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;

        for (int i=0; i<n-2; i++)
            for (int j=i+1; j<n-1; j++)
                for (int k=j+1; k<n; k++)
                    maxArea = Math.max(maxArea, area(points[i], points[j], points[k]));
        return maxArea;
    }
    // Area = (1/2) * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|
    private static double area(int[] a, int[] b, int[] c) {
        return Math.abs(a[0] * (b[1] - c[1]) +
                b[0] * (c[1] - a[1]) +
                c[0] * (a[1] - b[1])) / 2.0;
    }
    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
        System.out.println(largestTriangleArea(new int[][]{{1,0},{0,0},{0,1}}));
    }
}
