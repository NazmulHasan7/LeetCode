// 2381. Shifting Letters II
package Medium;

public class Medium_2381_Shifting_Letters_II {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArr = new int[n+1];

        // Update the difference array ti record the overall changes
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                diffArr[start]++;
                diffArr[end+1]--;
            } else {
                diffArr[start]--;
                diffArr[end+1]++;
            }
        }
        // Cumulative sum to record the overall change
        for (int i=1; i<n; i++) // last index in the diff_arr is the dummy index
            diffArr[i] += diffArr[i-1];

        StringBuilder answer = new StringBuilder();
        for (int i=0; i<n; i++) {
            int shiftCount = (diffArr[i] % 26 + 26) % 26; // +26 to avoid the negative number
            answer.append((char)('a' + (s.charAt(i) - 'a' + shiftCount) % 26));
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[][]{{0,1,0},{1,2,1},{0,2,1}}));
        System.out.println(shiftingLetters("dztz", new int[][]{{0,0,0},{1,1,1}}));
    }
}
