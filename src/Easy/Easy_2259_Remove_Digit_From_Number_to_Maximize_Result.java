// 2259. Remove Digit From Number to Maximize Result
package Easy;

public class Easy_2259_Remove_Digit_From_Number_to_Maximize_Result {
    public static String removeDigit(String number, char digit) {
        int n = number.length();
        int idx = 0;

        for (int i=0; i<n; i++) {
            if (number.charAt(i) == digit) {
                idx = i;
                if (i+1 < n && number.charAt(i) < number.charAt(i+1))
                    break;
            }
        }
        return number.substring(0, idx) + number.substring(idx+1);
    }
    public static void main(String[] args) {
        System.out.println(removeDigit("123",'3'));
        System.out.println(removeDigit("1231",'1'));
        System.out.println(removeDigit("551",'5'));
    }
}
