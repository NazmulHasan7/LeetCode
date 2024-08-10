// 2303. Calculate Amount Paid in Taxes
package Easy;

public class Easy_2303_Calculate_Amount_Paid_in_Taxes {
    public static double calculateTax(int[][] brackets, int income) {
        double taxAmount = 0;
        int previousAmount = 0;
        for (int[] bracket : brackets) {
            if (income <= 0) return taxAmount;
            double difference = Math.min(income, bracket[0]-previousAmount);
            taxAmount += difference * bracket[1] / 100.0;
            income -= (int) difference;
            previousAmount = bracket[0];
        } return taxAmount;
    }
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]
                {{3,50}, {7,10}, {12,25}}, 10));
        System.out.println(calculateTax(new int[][]
                {{1,0}, {4,25}, {5,50}}, 2));
        System.out.println(calculateTax(new int[][]{{2,50}}, 0));
    }
}
