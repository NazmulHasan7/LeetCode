// 2496 Maximum Value of a String in an Array
package Easy;

public class Easy_2496_Maximum_Value_of_a_String_in_an_Array {
    public static int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        int value;
        for (String str : strs) {
            try {
                value = Integer.parseInt(str);
            } catch (Exception ex) {
                value = str.length();
            } if (value > max) max = value;
        } return max;
    }
    public static int maximumValueBetter(String[] strs) {
        int max = 0, value;
        for (String str : strs) {
            value = 0;
            for (char c : str.toCharArray()) {
                if (c >= 'a' && c <='z') {
                    value = str.length();
                    break;
                } else value = value * 10 + (c - '0');
            } if (value > max) max = value;
        } return max;
    }
    public static void main(String[] args) {
        System.out.println(maximumValue(new String[] {"alic3","bob","3","4","00000"}));
        System.out.println(maximumValue(new String[] {"1","01","001","0001"}));
        System.out.println(maximumValueBetter(new String[] {"alic3","bob","3","4","00000"}));
        System.out.println(maximumValueBetter(new String[] {"1","01","001","0001"}));
    }
}
