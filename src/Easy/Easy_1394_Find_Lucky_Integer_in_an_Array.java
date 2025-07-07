// 1394. Find Lucky Integer in an Array
package Easy;

public class Easy_1394_Find_Lucky_Integer_in_an_Array {
    public static int findLucky(int[] arr) {
        int[] freq = new int[501];

        for (int n : arr)
            freq[n]++;

        for (int i=freq.length-1; i>0; i--)
            if (freq[i] == i)
                return i;

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,3,4}));
        System.out.println(findLucky(new int[]{1,2,2,3,3,3}));
        System.out.println(findLucky(new int[]{2,2,2,3,3}));
    }
}
