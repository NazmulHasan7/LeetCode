// 3100. Water Bottles II
package Medium;

public class Medium_3100_Water_Bottles_II {
    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinkCount = numBottles; // drink all the bottles
        int emptyBottles = numBottles; // all the bottles are now empty

        while (emptyBottles >= numExchange) {
            emptyBottles -= numExchange;
            numExchange++;
            // cannot exchange multiple batches of empty bottles for the same value of numExchange
            drinkCount += 1; // so, can only exchange one time for each exchange rate
            emptyBottles += 1; // that one bottle is now empty
        }
        return drinkCount;
    }
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(13,6));
        System.out.println(maxBottlesDrunk(10,3));
    }
}
