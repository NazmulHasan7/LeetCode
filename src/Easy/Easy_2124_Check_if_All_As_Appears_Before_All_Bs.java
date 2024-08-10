// 2124. Check if All A's Appears Before All B's
package Easy;

public class Easy_2124_Check_if_All_As_Appears_Before_All_Bs {
    public static boolean checkString(String s) {
        int lastA = -1, firstB = -1;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'a') lastA = i;
            else if (firstB == -1) firstB = i;
        } return lastA < firstB || firstB == -1;
    }
    public static void main(String[] args) {
        System.out.println(checkString("aaabbb"));
        System.out.println(checkString("abab"));
        System.out.println(checkString("bbb"));
        System.out.println(checkString("a"));
    }
}
