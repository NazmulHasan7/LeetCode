// 2288. Apply Discount to Prices
package Medium;

public class Medium_2288_Apply_Discount_to_Prices {
    // TC & SC -> O(n)
    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.charAt(0) == '$') {
                int n = word.length();
                int idx = 1;
                double amount = 0;

                // convert the string into number
                while (idx < n) {
                    char c = word.charAt(idx);
                    if (Character.isDigit(c)) {
                        amount = amount * 10 + c - '0';
                        idx++;
                    } else break;
                }
                if (n > 1 && idx == n) {
                    double updatedAmount = amount - (amount * discount / 100.0);
                    sb.append("$").append(String.format("%.2f", updatedAmount));
                } else {
                    sb.append(word); // not a valid amount
                }
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public static void main(String[] args) {
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }
}
