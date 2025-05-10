// 447. Number of Boomerangs
package Medium;
import java.util.HashMap;

public class Medium_447_Number_of_Boomerangs {
    public static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    long distance = (long)(x2-x1) * (x2-x1) + (long)(y2-y1) * (y2-y1);
                    // a boomerang can be formed with equal lengths only
                    // so we have already a point i, need to pick other 2 points
                    int x = map.getOrDefault(distance, 0);
                    count += (x * 2); // change the order of the 2 elements (2nd, 3rd)
                    // count += (x*(x-1))/2; // if ordering is ignored
                    map.put(distance, x+1);
                }
            } map.clear();
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{{0,0},{1,0},{2,0}}));
        System.out.println(numberOfBoomerangs(new int[][]{{1,1},{2,2},{3,3}}));
        System.out.println(numberOfBoomerangs(new int[][]{{1,1}}));
    }
}
