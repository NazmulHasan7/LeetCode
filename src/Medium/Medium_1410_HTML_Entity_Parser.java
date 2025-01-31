// 1410. HTML Entity Parser
package Medium;
import java.util.HashMap;

public class Medium_1410_HTML_Entity_Parser {
    public static String entityParser(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put("&apos;", "'");
        map.put("&quot;", "\"");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        map.put("&amp;", "&");

        StringBuilder answer = new StringBuilder();
        int n = text.length();
        int idx = 0;
        while (idx < n) {
            char c = text.charAt(idx);
            if (c == '&') {
                int start = idx;
                do {
                    idx++;
                } while (idx < n && text.charAt(idx) != ';' && text.charAt(idx) != '&');

                // To handle &&amp; such cases
                if (idx < n && text.charAt(idx) == ';') {
                    String subStr = text.substring(start, idx+1);
                    answer.append(map.getOrDefault(subStr, subStr));
                } else {
                    answer.append('&');
                    idx = start; // reset
                }
            } else {
                answer.append(c);
            }
            idx++;
        } return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
        System.out.println(entityParser("&&gt;"));
    }
}
