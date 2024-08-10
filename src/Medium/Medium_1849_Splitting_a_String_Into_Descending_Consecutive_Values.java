// 1849. Splitting a String Into Descending Consecutive Values
package Medium;

public class Medium_1849_Splitting_a_String_Into_Descending_Consecutive_Values {
    public static boolean splitString(String s) {
        return backtrack(s, 0, -1, 0);
    }
    private static boolean backtrack(String s, int idx, long prevNum, int count) {
        // The values are in descending order and adjacent values differ by 1
        if (idx == s.length())
            return count > 1;

        long currentNo = 0;
        for (int i=idx; i<s.length(); i++) {
            currentNo = currentNo * 10 + s.charAt(i) - '0';
            if (prevNum == -1 || (prevNum - currentNo) == 1)
                if (backtrack(s, i+1, currentNo, count+1))
                    return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(splitString("1234"));
        System.out.println(splitString("050043"));
        System.out.println(splitString("9080701"));
    }
}
