// 670. Maximum Swap
package Medium;

public class Medium_670_Maximum_Swap {
    public static int maximumSwap(int num) {
        char[] crr = String.valueOf(num).toCharArray();
        int n = crr.length;
        int maxIdx = -1;

        int swap1 = -1, swap2 = -1;
        for (int i=n-1; i>=0; i--) {
            if (maxIdx == -1 || crr[i] > crr[maxIdx]) {
                maxIdx = i;
            } else if (crr[i] < crr[maxIdx]) {
                swap1 = i;
                swap2 = maxIdx;
            }
        }
        if (swap1 != -1) {
            char temp = crr[swap1];
            crr[swap1] = crr[swap2];
            crr[swap2] = temp;
        }
        return Integer.parseInt(String.valueOf(crr));
    }
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736));
        System.out.println(maximumSwap(9973));
    }
}
