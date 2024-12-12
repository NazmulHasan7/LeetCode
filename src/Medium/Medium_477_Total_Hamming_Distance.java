// 477. Total Hamming Distance
package Medium;

public class Medium_477_Total_Hamming_Distance {
    public static int totalHammingDistance(int[] nums) {
        int answer = 0;
        int n = nums.length;

        for (int i=0; i<n-1; i++)
            for (int j=i+1; j<n; j++)
                answer = answer + Integer.bitCount(nums[i] ^ nums[j]);

        return answer;
    }
    public static int totalHammingDistanceOpt(int[] nums) {
        int answer = 0;
        int n = nums.length;

        // Iterate through all the 32 bits
        for (int i=0; i<32; i++) {
            int setBits = 0;
            // Count the number of integers with the i-th bit set
            for (int num : nums) {
                setBits += (num >> i) & 1;
            }
            int zeroBits = n - setBits;

            // A bit contributes to the distance only if one number has 1 and the other has 0
            answer += (setBits * zeroBits);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4,14,2}));
        System.out.println(totalHammingDistance(new int[]{4,14,4}));
    }
}
