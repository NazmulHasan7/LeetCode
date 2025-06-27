// 1007. Minimum Domino Rotations For Equal Row
package Medium;

public class Medium_1007_Minimum_Domino_Rotations_For_Equal_Row {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int minRot = Integer.MAX_VALUE;

        for (int target = 1; target <= 6; target++) {
            boolean same = true;
            int topSwap = 0, bottomSwap = 0;
            for (int i=0; i<n; i++) {
                if (tops[i] != target && bottoms[i] != target) {
                    same = false;
                    break;
                }
                if (tops[i] != target) topSwap++;
                if (bottoms[i] != target) bottomSwap++;
            }
            if (same)
                minRot = Math.min(minRot, Math.min(topSwap, bottomSwap));
        }
        return minRot == Integer.MAX_VALUE ? -1 : minRot;
    }
    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }
}
