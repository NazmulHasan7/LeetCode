// 3106. Lexicographically Smallest String After Operations With Constraint
package Medium;

public class Medium_3106_Lexicographically_Smallest_String_After_Operations_With_Constraint {
    public static String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int idx = 0;

        while (k > 0 && idx < n) {
            char c = s.charAt(idx);
            int val = c-'a';
            int diff = Math.min(val, 26-val);

            if (diff <= k) {
                sb.append("a");
                k -= diff;
            } else {
                sb.append((char)((c-k)));
                idx++;
                break; // k = 0
            }
            idx++;
        }
        while (idx < n)
            sb.append(s.charAt(idx++));

        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(getSmallestString("zbbz",3));
        System.out.println(getSmallestString("xaxcd",4));
        System.out.println(getSmallestString("lol",0));
    }
}
