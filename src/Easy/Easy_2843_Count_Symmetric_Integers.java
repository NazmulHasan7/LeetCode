// 2843. Count Symmetric Integers
package Easy;

public class Easy_2843_Count_Symmetric_Integers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0, length, sum1, sum2;
        String number;
        for (int i=low; i<=high; i++) {
            sum1 = sum2 = 0;
            number = Integer.toString(i);
            length = number.length();
            if (length % 2 == 0) {
                for (int j=0, k=length/2; j<length/2; j++, k++) {
                    sum1 += number.charAt(j) - '0';
                    sum2 += number.charAt(k) - '0';
                }
                if (sum1 == sum2) count++;
            }
        } return count;
    }
    public static int countSymmetricIntegersBetter(int low, int high) {
        int count = 0, d1, d2, d3, d4;
        for (int i=low; i<=high; i++) {
            if (i<11 || (i>=100 && i<=999)) continue;
            else if (i<100) {
                if (i % 11 == 0) count++;
            }
            else {
                d1 = i / 1000;
                d2 = i / 100 - (d1 * 10);
                d3 = i / 10 - (d1 * 100 + d2 * 10);
                d4 = i % 10;
                if (d1 + d2 - d3 - d4 == 0) count++;
            }
        } return count;
    }
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(1200, 1230));
        System.out.println(countSymmetricIntegersBetter(1, 100));
        System.out.println(countSymmetricIntegersBetter(1200, 1230));
        System.out.println(countSymmetricIntegersBetter(100, 10000));
    }
}
