// 1094. Car Pooling
package Medium;

public class Medium_1094_Car_Pooling {
    /*
        trips [person, start, end] -> [[2,1,5], [3,3,7]], cap = 4
        Location Id   --> 1 --> 3 --> 5 --> 7
        Seat occupied ->2(in)->3(in)->out(-2)->out(-3)
                Total --> 2 --> 5 --> 3 --> 0
     */
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] passengerChange = new int[1001];
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            passengerChange[from] += passengers;
            passengerChange[to] -= passengers;
        }
        int passengerCount = 0;
        for (int passengers : passengerChange) {
            passengerCount += passengers;
            if (passengerCount > capacity) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}},4));
        System.out.println(carPooling(new int[][]{{2,1,5},{3,3,7}},5));
    }
}
