// 1323. Maximum 69 Number
package Easy;

public class Easy_1323_Maximum_69_Number {
    public static int maximum69Number (int num) {
        //return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
        String strNum = String.valueOf(num);
        char[] crr = strNum.toCharArray();
        for (int i=0; i<crr.length; i++)
            if (crr[i] == '6') {
                crr[i] = '9';
                break;
            }
        return Integer.parseInt(new String(crr));
    }
    public static void main(String[] args) {
        System.out.println(maximum69Number(6669));
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9969));
        System.out.println(maximum69Number(9999));
    }
}