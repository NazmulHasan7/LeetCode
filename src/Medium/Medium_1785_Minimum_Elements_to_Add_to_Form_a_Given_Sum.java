// 1785. Minimum Elements to Add to Form a Given Sum
package Medium;

public class Medium_1785_Minimum_Elements_to_Add_to_Form_a_Given_Sum {
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) sum += x;

        long target = Math.abs(goal - sum);
        return (int) Math.ceil(1.0 * target / limit);
    }
    public static void main(String[] args) {
        System.out.println(minElements(new int[]{1,-1,1},3,-4));
        System.out.println(minElements(new int[]{1,-10,9,1},100,0));
    }
}
