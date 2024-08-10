// 1844. Replace All Digits with Characters
package Easy;

public class Easy_1844_Replace_All_Digits_with_Characters {
    public static String replaceDigits(String s) {
        char[] cArr = s.toCharArray();
        for (int i=1; i<cArr.length; i+=2)
            cArr[i] = (char) (cArr[i] - '0' + cArr[i-1]);
        return new String(cArr);
    }
    public static void main(String[] args) {
        System.out.println(replaceDigits("a1c1e1"));
        System.out.println(replaceDigits("a1b2c3d4e"));
    }
}
