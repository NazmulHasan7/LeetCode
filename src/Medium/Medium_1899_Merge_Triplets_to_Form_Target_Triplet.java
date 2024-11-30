// 1899. Merge Triplets to Form Target Triplet
package Medium;

public class Medium_1899_Merge_Triplets_to_Form_Target_Triplet {
    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean found1, found2, found3;
        found1 = found2 = found3 = false;

        // Filter out the triplets that has any of the value > any of the value of target triplet
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2])
                continue; // skip the current triplet

            // since we filter out the invalid triplets
            if (triplet[0] == target[0])
                found1 = true;

            if (triplet[1] == target[1])
                found2 = true;

            if (triplet[2] == target[2])
                found3 = true;

            if (found1 && found2 && found3)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(mergeTriplets(new int[][]{{2,5,3},{1,8,4},{1,7,5}}, new int[]{2,7,5}));
        System.out.println(mergeTriplets(new int[][]{{3,4,5},{4,5,6}}, new int[]{3,2,5}));
        System.out.println(mergeTriplets(new int[][]{{2,5,3},{2,3,4},{1,2,5},{5,2,3}}, new int[]{5,5,5}));
    }
}
