// 2283. Check if Number Has Equal Digit Count and Digit Value
package Easy;

public class Easy_2283_Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value {
    public static boolean digitCount(String num) {
        int[] freq = new int[10];
        char[] cArr = num.toCharArray();
        for (char c : cArr)
            freq[c-'0']++;
        for (int i=0; i<cArr.length; i++)
            if (cArr[i]-'0' != freq[i])
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }
}
