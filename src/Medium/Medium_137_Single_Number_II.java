// 137. Single Number II
package Medium;

public class Medium_137_Single_Number_II {
    public static int singleNumber(int[] nums) {
        int answer = 0;

        // iterate through each bit
        for (int i=31; i>=0; i--) {
            int bitCount = 0;
            // iterate through all the numbers
            for (int num : nums) {
                if ((num & (1 << i)) != 0)
                    bitCount++;
            }
            if (bitCount % 3 != 0)
                answer |= (1 << i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
