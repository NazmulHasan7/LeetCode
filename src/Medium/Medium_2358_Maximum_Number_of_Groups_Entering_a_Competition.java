// 2358. Maximum Number of Groups Entering a Competition
package Medium;

public class Medium_2358_Maximum_Number_of_Groups_Entering_a_Competition {
    public static int maximumGroups(int[] grades) {
        // Arrays.sort(grades);
        int n = grades.length;
        int idx = 0;
        int groups = 0;

        while (idx + groups < n) {
            groups++;
            idx += groups;
        }
        return groups;
    }
    public static void main(String[] args) {
        System.out.println(maximumGroups(new int[]{10,6,12,7,3,5}));
        System.out.println(maximumGroups(new int[]{8,8}));
    }
}
