// 38. Count and Say
package Medium;

public class Medium_38_Count_and_Say {
    public static String countAndSay(int n) {
        String s = "1";
        while (--n > 0)
            s = getRLE(s);
        return s;
    }
    private static String getRLE(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        int n = s.length();

        for (int i=1; i<n; i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                count = 1;
                prev = c;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(1));
    }
}
