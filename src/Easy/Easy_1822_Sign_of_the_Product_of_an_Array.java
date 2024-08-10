// 1822. Sign of the Product of an Array
package Easy;

public class Easy_1822_Sign_of_the_Product_of_an_Array {
    public static int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) count++;
        } return (count % 2 == 0) ? 1 : -1;
    }
    public static void main(String[] args) {
        System.out.println(arraySign(new int[] {-1,-2,-3,-4,3,2,1}));
        System.out.println(arraySign(new int[] {1,5,0,2,-3}));
        System.out.println(arraySign(new int[] {-1,1,-1,1,-1}));
        System.out.println(arraySign(new int[] {
                41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41
        }));
    }
}
