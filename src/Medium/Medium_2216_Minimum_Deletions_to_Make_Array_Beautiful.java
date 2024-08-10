// 2216. Minimum Deletions to Make Array Beautiful
package Medium;

public class Medium_2216_Minimum_Deletions_to_Make_Array_Beautiful {
    public static int minDeletion(int[] nums) {
        if (nums.length == 1) return 1;
        int delOps = 0;

        for (int i=0; i<nums.length-1; i+=2) {
            if (nums[i] == nums[i+1]) {
                delOps++;
                i--;
            }
        } return (nums.length - delOps) % 2 == 1 ? ++delOps : delOps;
    }
    public static void main(String[] args) {
        System.out.println(minDeletion(new int[] {1,1,2,3,5}));
        System.out.println(minDeletion(new int[] {1,1,2,2,3,3}));
    }
}
