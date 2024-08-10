// 1750. Minimum Length of String After Deleting Similar Ends
package Medium;

public class Medium_1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    public static int minimumLength(String s) {
        char[] crr = s.toCharArray();
        int start = 0, end = crr.length - 1;

        while (start < end && crr[start] == crr[end]) {
            while (start + 1 < end && crr[end] == crr[start + 1])
                start++;
            while (end - 1 > start && crr[start] == crr[end - 1])
                end--;
            start++;
            end--;
        } return end + 1 - start;
    }
    public int minimumLengthBetter(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end && s.charAt(start) == s.charAt(end)) {
            char c = s.charAt(start);
            while(start <= end && s.charAt(start) == c)
                start++;
            while(start <= end && s.charAt(end) == c)
                end--;
        } return end - start + 1;
    }
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }
}
