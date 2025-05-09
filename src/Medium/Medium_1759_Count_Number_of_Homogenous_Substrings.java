// 1759. Count Number of Homogenous Substrings
package Medium;

public class Medium_1759_Count_Number_of_Homogenous_Substrings {
    public static int countHomogenous(String s) {
        int n = s.length();
        int left = 0, right = 1;
        char lc = s.charAt(left);

        int count = 0;
        int mod = (int) 1e9 + 7;

        while (right < n) {
            char rc = s.charAt(right);
            if (lc == rc) {
                right++;
            } else {
                int x = (right - left);
                count = (int)((count + ((long)x*(x+1)/2)) % mod);
                left = right;
                lc = s.charAt(left);
                right++;
            }
        }
        int x = (right - left);
        count = (int)((count + ((long)x * (x + 1) / 2)) % mod);
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(countHomogenous("xy"));
        System.out.println(countHomogenous("zzzzz"));
    }
}
