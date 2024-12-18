// 868. Binary Gap
package Easy;

public class Easy_868_Binary_Gap {
    public static int binaryGap(int n) {
        // Check if the number is a power of 2
        if ((n & (n-1)) == 0) return 0;

        int maxDistance = 0;
        int lastPos = -1;
        int idx = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                if (lastPos != -1)
                    maxDistance = Math.max(maxDistance, idx - lastPos);
                lastPos = idx;
            }
            n >>= 1;
            idx++;
        }
        return  maxDistance;
    }
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(8));
        System.out.println(binaryGap(5));
    }
}
