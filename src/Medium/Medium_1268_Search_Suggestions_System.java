// 1268. Search Suggestions System
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_1268_Search_Suggestions_System {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>();
        int left = 0, right = products.length-1;
        Arrays.sort(products);

        // Two pointer approach
        int n = searchWord.length();
        for (int i=0; i<n; i++) {
            char c = searchWord.charAt(i);
            // Left Bound --> What if the product at left does not have ith index or the char does not match
            while (left<=right && (products[left].length()<=i || products[left].charAt(i) != c))
                left++;
            // Right Bound --> What if the product at left does not have ith index or the char does not match
            while (left<=right && (products[right].length()<=i || products[right].charAt(i) != c))
                right--;

            // Maximum of 3 words will be suggested
            int len = Math.min(3, right-left+1);
            List<String> topMatch = new ArrayList<>();
            for (int x=0; x<len; x++)
                topMatch.add(products[left + x]);

            answer.add(topMatch);
        } return answer;
    }
    public static void main(String[] args) {
        List<List<String>> answer = suggestedProducts(new String[]
                {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");

        for (List<String> match : answer)
            System.out.println(Arrays.toString(match.toArray()));
    }
}
