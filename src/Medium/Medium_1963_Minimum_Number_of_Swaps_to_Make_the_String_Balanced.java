// 1963. Minimum Number of Swaps to Make the String Balanced
package Medium;

public class Medium_1963_Minimum_Number_of_Swaps_to_Make_the_String_Balanced {
    public static int minSwaps(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') open++;
            else {
                if (open > 0) open--;
                else close++;
            } // Operations required is half the closing brackets remaining
        } return close % 2 == 0 ? close / 2 : (close + 1) / 2;
    }
    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
        System.out.println(minSwaps("]]][[["));
        System.out.println(minSwaps("[]"));
    }
}
