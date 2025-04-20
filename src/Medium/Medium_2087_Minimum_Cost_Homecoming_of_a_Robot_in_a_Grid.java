// 2087. Minimum Cost Homecoming of a Robot in a Grid
package Medium;

public class Medium_2087_Minimum_Cost_Homecoming_of_a_Robot_in_a_Grid {
    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int minCost = 0;
        int sr = startPos[0], sc = startPos[1];
        int tr = homePos[0], tc = homePos[1];

        // move vertically
        while (sr != tr) {
            if (sr < tr) sr++;
            else sr--;
            minCost += rowCosts[sr];
        }
        // move horizontally
        while (sc != tc) {
            if (sc < tc) sc++;
            else sc--;
            minCost += colCosts[sc];
        }
        return minCost;
    }
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1,0}, new int[]{2,3}, new int[]{5,4,3}, new int[]{8,2,6,7}));
        System.out.println(minCost(new int[]{0,0}, new int[]{0,0}, new int[]{5}, new int[]{26}));
    }
}
