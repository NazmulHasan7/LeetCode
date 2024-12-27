// 299. Bulls and Cows
package Medium;

public class Medium_299_Bulls_and_Cows {
    public static String getHint(String secret, String guess) {
        // Using an integer array (freq) to track the frequency of digits in secret and guess.
        // A negative value indicates the digit has been encountered in guess but not yet matched in secret.
        // A positive value indicates the digit has been encountered in secret but not yet matched in guess.
        int[] freq = new int[10];
        int bulls = 0, cows = 0;
        int n = secret.length();

        for (int i=0; i<n; i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                bulls++;
            } else {
                if (freq[g] > 0) cows++; // secret has this digit in another position
                if (freq[s] < 0) cows++; // guess has this digit in another position
                freq[g]--;
                freq[s]++;
            }
        } return bulls + "A" + cows + "B";
    }
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }
}
