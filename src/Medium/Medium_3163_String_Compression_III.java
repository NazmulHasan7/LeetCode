// 3163. String Compression III
package Medium;

public class Medium_3163_String_Compression_III {
    public static String compressedString(String word) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        char prev = word.charAt(0);
        for (char c : word.toCharArray()) {
            if (c == prev) {
                count++;
                if (count == 9) {
                    sb.append(9).append(prev);
                    count = 0;
                }
            } else {
                if (count > 0)
                    sb.append(count).append(prev);
                prev = c;
                count = 1;
            }
        }
        if (count > 0)
            sb.append(count).append(prev);
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(compressedString("abcde"));
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }
}
