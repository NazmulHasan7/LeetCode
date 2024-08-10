// 1748. Sum of Unique Elements
package Easy;

public class Easy_1748_Sum_of_Unique_Elements {
    public static int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) arr[num]++;

        int sum = 0;
        for (int i=0; i<arr.length; i++)
            if (arr[i] == 1) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[] {1,2,3,2}));
        System.out.println(sumOfUnique(new int[] {1,1,1,1,1}));
        System.out.println(sumOfUnique(new int[] {1,2,3,4,5}));
    }
}
