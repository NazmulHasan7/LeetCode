// 1518. Water Bottles
package Easy;

public class Easy_1518_Water_Bottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0, emptyBottles = 0;
        while (numBottles > 0) {
            // Add the current full bottles to the answer
            answer += numBottles;
            // Add the emptied bottles to emptyBottles
            emptyBottles += numBottles;
            // Exchange empty bottles for full ones
            numBottles = emptyBottles / numExchange;
            // Update the number of remaining empty bottles
            emptyBottles = emptyBottles % numExchange;
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9,3));
        System.out.println(numWaterBottles(15,4));
    }
}
