// 1893. Check if All the Integers in a Range Are Covered
package Easy;

public class Easy_1893_Check_if_All_the_Integers_in_a_Range_Are_Covered {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[] line = new int[52];
        for (int[] range : ranges) {
            line[range[0]]++;
            line[range[1]+1]--; // end is inclusive
        }
        int lines = 0;
        for (int i=0; i<52; i++) {
            lines += line[i];
            if (i>=left && i<=right && lines <= 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isCovered(new int[][]{{1,2},{3,4},{5,6}}, 2, 5));
        System.out.println(isCovered(new int[][]{{1,10},{10,20}}, 21, 21));
    }
}
