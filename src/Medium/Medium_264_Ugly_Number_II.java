// 264. Ugly Number II
package Medium;

public class Medium_264_Ugly_Number_II {
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for (int i=1; i<n; i++) {
            int next2 = ugly[p2] * 2;
            int next3 = ugly[p3] * 3;
            int next5 = ugly[p5] * 5;
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            if (nextUgly == next2) p2++;
            if (nextUgly == next3) p3++;
            if (nextUgly == next5) p5++;
        }
        return ugly[n-1];
    }
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(1));
    }
}
