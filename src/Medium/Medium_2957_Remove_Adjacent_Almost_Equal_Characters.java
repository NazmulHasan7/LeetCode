// 2957. Remove Adjacent Almost-Equal Characters
package Medium;

public class Medium_2957_Remove_Adjacent_Almost_Equal_Characters {
    public static int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int count = 0;

        for (int i=1; i<n; i++) {
            char prev = word.charAt(i-1);
            char curr = word.charAt(i);
            if (prev == curr || prev+1 == curr || prev-1 == curr) {
                count++;
                // Assuming the current character is changed
                // no need to check the next character again
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(removeAlmostEqualCharacters("aaaaa"));
        System.out.println(removeAlmostEqualCharacters("abddez"));
        System.out.println(removeAlmostEqualCharacters("zyxyxyz"));
    }
}
