// 2243. Calculate Digit Sum of a String
package Easy;

public class Easy_2243_Calculate_Digit_Sum_of_a_String {
    public static String digitSum(String s, int k) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        while (length > k) {
            int i=0;
            while (i<length) {
                int j=0, sum=0;
                while (j<k && i<length) {
                    sum += s.charAt(i)-'0';
                    j++; i++;
                } sb.append(sum);
            }
            s = sb.toString();
            sb = new StringBuilder();
            length = s.length();
        } return s;
    }
    public static String digitSumBetter(String s, int k){
        if(s.length() <= k)
            return s;
        StringBuilder r = new StringBuilder();
        for(int i = 1, sum = 0; i <= s.length(); i++){
            sum += s.charAt(i - 1) - '0';
            if(i % k == 0 || i == s.length()){
                r.append(sum);
                sum = 0;
            }
        } return digitSumBetter(r.toString(), k);
    }
    public static void main(String[] args) {
        System.out.println(digitSum("11111222223", 3));
        System.out.println(digitSum("00000000", 3));
        System.out.println(digitSumBetter("11111222223", 3));
        System.out.println(digitSumBetter("00000000", 3));
    }
}
