// 1869. Longer Contiguous Segments of Ones than Zeros
package Easy;

public class Easy_1869_Longer_Contiguous_Segments_of_Ones_than_Zeros {
    public static boolean checkZeroOnes(String s) {
        int count0 = 0, count1 = 0;
        int maxCount0 = 0, maxCount1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count1 = 0;
                count0++;
                maxCount0 = Math.max(maxCount0, count0);
            } else {
                count0 = 0;
                count1++;
                maxCount1 = Math.max(maxCount1, count1);
            }
        } return maxCount1 > maxCount0;
    }
    public static void main(String[] args) {
        System.out.println(checkZeroOnes("1101"));
        System.out.println(checkZeroOnes("111000"));
        System.out.println(checkZeroOnes("110100010"));
        System.out.println(checkZeroOnes("1"));
    }
}
