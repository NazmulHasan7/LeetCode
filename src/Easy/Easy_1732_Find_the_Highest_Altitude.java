// 1732. Find the Highest Altitude
package Easy;

public class Easy_1732_Find_the_Highest_Altitude {
    public static int largestAltitude(int[] gain) {
        int h = 0, sum = 0;
        for (int num: gain) {
            sum += num;
            if (sum > h) h = sum;
        }
        return h;
    }
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] {-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}
