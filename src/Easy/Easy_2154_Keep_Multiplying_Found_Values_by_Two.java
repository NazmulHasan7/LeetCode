// 2154. Keep Multiplying Found Values by Two
package Easy;

public class Easy_2154_Keep_Multiplying_Found_Values_by_Two {
    public static int findFinalValue(int[] nums, int original) {
        for (int num : nums)
            if (num == original)
                return findFinalValue(nums, original * 2);
        return original;
    }
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[] {5,3,6,1,12}, 3));
        System.out.println(findFinalValue(new int[] {2,7,9}, 4));
    }
}
