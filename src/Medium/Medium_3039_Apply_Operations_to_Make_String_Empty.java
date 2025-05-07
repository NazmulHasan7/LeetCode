// 3039. Apply Operations to Make String Empty
package Medium;

public class Medium_3039_Apply_Operations_to_Make_String_Empty {
    public static String lastNonEmptyString(String s) {
        int[] freq = new int[26];
        int maxFreq = 0;

        for (char c : s.toCharArray()) {
            int i = c-'a';
            freq[i]++;
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            int idx = c - 'a';
            if (freq[idx] == maxFreq) {
                sb.append(c);
                freq[idx] = -1;
            }
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(lastNonEmptyString("aabcbbca"));
        System.out.println(lastNonEmptyString("abcd"));
    }
}
