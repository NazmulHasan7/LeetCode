// 3208. Alternating Groups II
package Medium;

public class Medium_3208_Alternating_Groups_II {
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        // To handle the circular array problem
        int newLen = colors.length + k - 1;
        int[] extendedColors = new int[newLen];

        int idx = 0;
        for (int color : colors)
            extendedColors[idx++] = color;

        for (int i=0; i<k-1; i++)
            extendedColors[idx++] = colors[i];

        int n = extendedColors.length;
        int left = 0, right = 1;

        int groups = 0;

        while (right < n) {
            if (extendedColors[right] == extendedColors[right-1]) {
                left = right;
            } else {
                if (right - left + 1 == k) {
                    left++;
                    groups++;
                }
            } right++;
        }
        return groups;
    }
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,1,0},3));
        System.out.println(numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1},6));
        System.out.println(numberOfAlternatingGroups(new int[]{1,1,0,1},4));
    }
}
