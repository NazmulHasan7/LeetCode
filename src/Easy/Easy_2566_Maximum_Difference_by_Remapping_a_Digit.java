// 2566. Maximum Difference by Remapping a Digit
package Easy;

public class Easy_2566_Maximum_Difference_by_Remapping_a_Digit {
    public static int minMaxDifference(int num) {
        int pos = 0;
        String max = String.valueOf(num);
        String min = max;

        for (char c : max.toCharArray()) {
            if (c != '9')
                break;
            pos++;
        }
        if (pos < max.length())
            max = max.replace(max.charAt(pos), '9');

        int maxNumber = Integer.parseInt(max);
        int minNumber = Integer.parseInt(min.replace(min.charAt(0), '0'));
        return maxNumber - minNumber;

    }
    public static void main(String[] args) {
        System.out.println(minMaxDifference(11891));
        System.out.println(minMaxDifference(90));
    }
}
