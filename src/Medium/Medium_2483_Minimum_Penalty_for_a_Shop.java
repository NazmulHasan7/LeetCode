// 2483. Minimum Penalty for a Shop
package Medium;

public class Medium_2483_Minimum_Penalty_for_a_Shop {
    public static int bestClosingTime(String customers) {
        int penalty = 0;
        // Assume we close the shop at 0th hour
        for (char c : customers.toCharArray())
            // the shop is closed and a customer visited
            if (c == 'Y') penalty++;

        int n = customers.length();
        int min_penalty = penalty;
        int hour = 0;
        for (int i=0; i<n; i++) {
            // the shop is open at ith hour, we want to close it at i+1th hour
            if (customers.charAt(i) == 'Y') {
                // shop open and customer came
                penalty--;
            } else {
                // shop open but not customer came
                penalty++;
            }
            if (penalty < min_penalty) {
                min_penalty = penalty;
                hour = i+1;
            }
        } return hour;
    }
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("NNNNN"));
        System.out.println(bestClosingTime("YYYY"));
    }
}
