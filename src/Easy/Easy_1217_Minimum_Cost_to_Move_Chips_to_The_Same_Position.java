// 1217. Minimum Cost to Move Chips to The Same Position
package Easy;

public class Easy_1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position {
    public static int minCostToMoveChips(int[] position) {
        int evenPos = 0, oddPos = 0;

        // Find how many are in even position and how many are in odd position
        for (int p : position) {
            if ((p & 1) == 0) evenPos++;
            else oddPos++;
        }

        int n = position.length;
        // if all the chips are in even position or all are in odd position
        // then the cost is 0, since even + 2 = even, even - 2 = even, same for odd
        // and the cost of position + or - 2 is 0
        if (evenPos == n || oddPos == n) return 0;

        // Otherwise -> minimum of taking the chips to even or odd position
        return Math.min(evenPos, oddPos);
    }
    public static void main(String[] args) {
        System.out.println(minCostToMoveChips(new int[]{1,2,3}));
        System.out.println(minCostToMoveChips(new int[]{2,2,2,3,3}));
        System.out.println(minCostToMoveChips(new int[]{1,1000000000}));
    }
}
