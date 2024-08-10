// 1313. Decompress Run-Length Encoded List
package Easy;
import java.util.ArrayList;
import java.util.Arrays;

public class Easy_1313_Decompress_Run_Length_Encoded_List {
    public static int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i=0; i<nums.length; i+=2)
            for (int k=0; k<nums[i]; k++)
                numList.add(nums[i+1]);

        int[] array = new int[numList.size()];
        for (int i=0; i<array.length; i++)
            array[i] = numList.get(i);

        return array;
    }
    public static int[] decompressRLElistBetter(int[] nums) {
        int size = 0;
        for (int i=0; i<nums.length; i+=2)
            size += nums[i];

        int[] array = new int[size];
        int startIndex = 0;
        for (int i=0; i<nums.length; i+=2) {
            Arrays.fill(array, startIndex, startIndex+nums[i], nums[i+1]);
            startIndex += nums[i];
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(decompressRLElist(new int[] {1,1,2,3})));
        System.out.println(Arrays.toString(decompressRLElistBetter(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(decompressRLElistBetter(new int[] {1,1,2,3})));
    }
}
