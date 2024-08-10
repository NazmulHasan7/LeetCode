// 3110. Score of a String
package Easy;

public class Easy_3110_Score_of_a_String {
    public static int scoreOfString(String s) {
        int n = s.length(), sum = 0;
        for (int i=1; i<n; i++)
            sum += Math.abs(s.charAt(i) - s.charAt(i-1));
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
        System.out.println(scoreOfString("zaz"));
    }
}
