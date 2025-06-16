// 1946. Largest Number After Mutating Substring
package Medium;

public class Medium_1946_Largest_Number_After_Mutating_Substring {
    public static String maximumNumber(String num, int[] change) {
        char[] crr = num.toCharArray();
        int n = crr.length;
        int idx = 0;

        // skip the digits in num that are greater than it's change
        while (idx < n && crr[idx]-'0' >= change[crr[idx]-'0'])
            idx++;

        while (idx < n && crr[idx]-'0' <= change[crr[idx]-'0']) {
            crr[idx] = (char)(change[crr[idx]-'0']+'0');
            idx++;
        }
        return String.valueOf(crr);
    }
    public static void main(String[] args) {
        System.out.println(maximumNumber("132", new int[]{9,8,5,0,3,6,4,2,6,8}));
        System.out.println(maximumNumber("021", new int[]{9,4,3,5,7,2,1,9,0,6}));
        System.out.println(maximumNumber("5", new int[]{1,4,7,5,3,2,5,6,9,4}));
    }
}
