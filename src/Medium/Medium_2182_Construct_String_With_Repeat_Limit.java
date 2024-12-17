// 2182. Construct String With Repeat Limit
package Medium;

public class Medium_2182_Construct_String_With_Repeat_Limit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        // Store the frequencies
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c-'a']++;

        StringBuilder answer = new StringBuilder();

        // Iterate through the frequency array
        for (int i=25; i>=0; i--) {

            if (freq[i] != 0) {
                char c = (char) ('a' + i);
                int occurrence = Math.min(freq[i], repeatLimit);
                freq[i] -= occurrence; // update the frequency
                answer.append(String.valueOf(c).repeat(occurrence));

                // If the current character still has occurrence then add a next largest character
                if (freq[i] != 0) {
                    int j = i - 1; // Search for the next largest character
                    while (j >= 0) {
                        if (freq[j] != 0) {
                            answer.append((char) ('a' + j));
                            freq[j]--;
                            break;
                        }
                        j--;
                    }
                    // No other character found - skip the rest
                    if (j < 0) return answer.toString();
                }
                i++; // to add rest of the occurrences
            }
        } return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc",3));
        System.out.println(repeatLimitedString("aababab",2));
    }
}
