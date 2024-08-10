// 1512. Number of Good Pairs
package Easy;

public class Easy_1512_Number_of_Good_Pairs {
    public static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i=0; i<nums.length; i++)
            for (int j=i+1; j<nums.length; j++)
                if (nums[i] == nums[j])
                    count++;
        return count;
    }
    //  If a number appears n times, then n*(n–1)//2 good pairs can be made
    public static int numIdenticalPairsBetter(int[] nums) {
        int[] counts = new int[101];
        int totalCount = 0;
        for (int num: nums)
            counts[num]++;
        for (int i: counts)
            totalCount += i * (i-1) / 2;
        return totalCount;
    }
    public static void main(String[] args) {
        System.out.println(numIdenticalPairsBetter(new int[] {1,2,3,1,1,3}));
        System.out.println(numIdenticalPairsBetter(new int[] {1,1,1,1}));
        System.out.println(numIdenticalPairsBetter(new int[] {1,2,3}));
    }
}
