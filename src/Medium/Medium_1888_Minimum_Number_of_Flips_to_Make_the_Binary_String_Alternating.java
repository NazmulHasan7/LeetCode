// 1888. Minimum Number of Flips to Make the Binary String Alternating
package Medium;

public class Medium_1888_Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating {
    public static int minFlips(String s) {
        // Type-1: Remove the character at the start of the string s and append it to the end of the string.
        // 111000 --> 111000111000 <-- To handle rotation
        int n = s.length();
        int size = 2 * n;
        int answer = Integer.MAX_VALUE;

        // Stating with sequence 010101
        int diff0in01 = 0, diff1in01 = 0;
        // Stating with sequence 010101
        int diff0in10 = 0, diff1in10 = 0;

        // First Window
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                if (c != '0') diff0in01++;
                if (c != '1') diff1in10++;
            } else {
                if (c != '1') diff1in01++;
                if (c != '0') diff0in10++;
            }
        } answer = Math.min(diff0in01 + diff1in01, diff0in10 + diff1in10);

        // Sliding to the next windows
        for (int left = 1, right = n; right < size; left++, right++) {
            // Update counts for the exiting and entering characters
            char exitChar = s.charAt((left - 1) % n);
            char enterChar = s.charAt(right % n);
            if ((left - 1) % 2 == 0) {
                if (exitChar != '0') diff0in01--;
                if (exitChar != '1') diff1in10--;
            } else {
                if (exitChar != '1') diff1in01--;
                if (exitChar != '0') diff0in10--;
            }
            if (right % 2 == 0) {
                if (enterChar != '0') diff0in01++;
                if (enterChar != '1') diff1in10++;
            } else {
                if (enterChar != '1') diff1in01++;
                if (enterChar != '0') diff0in10++;
            }
            // Calculate flips for the current window
            int flipsInWindow = Math.min(diff0in01 + diff1in01, diff0in10 + diff1in10);
            answer = Math.min(answer, flipsInWindow);
        } return answer;
    }
    public static void main(String[] args) {
        System.out.println(minFlips("111000"));
        System.out.println(minFlips("1110"));
    }
}
