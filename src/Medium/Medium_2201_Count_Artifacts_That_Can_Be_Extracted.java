// 2201. Count Artifacts That Can Be Extracted
package Medium;

public class Medium_2201_Count_Artifacts_That_Can_Be_Extracted {
    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] covered = new boolean[n][n];
        for (int[] d : dig)
            covered[d[0]][d[1]] = true;

        int count = 0;
        for (int[] artifact : artifacts) {
            boolean canBeExtracted = true;
            for (int r=artifact[0]; r<=artifact[2]; r++) {
                for (int c=artifact[1]; c<=artifact[3]; c++) {
                    if (!covered[r][c]) {
                        canBeExtracted = false;
                        break;
                    }
                }
            }
            if (canBeExtracted) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(digArtifacts(2, new int[][]{{0,0,0,0},{0,1,1,1}}, new int[][]{{0,0},{0,1}}));
        System.out.println(digArtifacts(2, new int[][]{{0,0,0,0},{0,1,1,1}}, new int[][]{{0,0},{0,1},{1,1}}));
    }
}
