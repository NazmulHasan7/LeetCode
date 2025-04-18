// 1375. Number of Times Binary String Is Prefix-Aligned
package Medium;

public class Medium_1375_Number_of_Times_Binary_String_Is_Prefix_Aligned {
    public static int numTimesAllBlue(int[] flips) {
        // calculate sum of numbers seen so far
        // if you on position 5 and seen all the numbers in interval [1..5]
        int count = 0;
        long sum = 0;
        int n = flips.length;
        long expectedSum = 0;

        for (int i=0; i<n; i++) {
            sum += flips[i];
            expectedSum += (i+1);
            // if (sum == ((long) (i+1) *(i+2)/2))
            if (sum == expectedSum)
                count++; // expected sum = n*(n+1)/2 if all bits before that are 0
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{3,2,4,1,5}));
        System.out.println(numTimesAllBlue(new int[]{4,1,2,3}));
    }
}
