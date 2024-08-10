// 2379. Minimum Recolors to Get K Consecutive Black Blocks
package Easy;

public class Easy_2379_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks {
    public static int minimumRecolors(String blocks, int k) {
        int size = blocks.length();
        int countW = 0, minCount = 0;

        // Count W block in first window
        for (int i=0; i<k; i++)
            if (blocks.charAt(i) == 'W')
                countW++;

        minCount = countW;
        // Check in the remaining window, while sliding it to the end
        int left = 1, right = k;
        while (right < size) {
            if (blocks.charAt(left-1) == 'W')
                countW--;
            if (blocks.charAt(right) == 'W')
                countW++;
            left++; right++;
            minCount = Math.min(minCount, countW);
        } return minCount;
    }
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
        System.out.println(minimumRecolors("WWBBBWBBBBBWWBWWWB", 16));
    }
}
