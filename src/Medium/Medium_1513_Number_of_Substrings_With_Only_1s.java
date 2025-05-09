// 1513. Number of Substrings With Only 1s
package Medium;

public class Medium_1513_Number_of_Substrings_With_Only_1s {
    public static int numSub(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        int count = 0;

        int left = 0, right = 1;

        while (right <= n) { // to handle the last case
            while (left < n && s.charAt(left) != '1')
                left++;

            if (left >= n) break;
            right = left;

            while (right < n && s.charAt(right) == '1')
                right++;

            int x = (right - left);
            count = (int) (count + (((long) x *(x+1))/2 % mod)) % mod;
            left = right + 1;
        }
        return count;
    }

    // Optimized and easier approach
    public static int numSubOpt(String s) {
        long count = 0;
        long answer = 0;
        int mod = (int) 1e9 + 7;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                answer = (answer + (count*(count+1)/2 % mod)) % mod;
                count = 0;
            }
        }
        if (count == 0)
            return (int) (answer % mod);
        return (int) (answer + ((count*(count+1))/2) % mod) % mod;
    }

    public static void main(String[] args) {
        System.out.println(numSub("0110111"));
        System.out.println(numSub("101"));
        System.out.println(numSub("111111"));
    }
}
