// 535. Encode and Decode TinyURL
package Medium;
import java.util.HashMap;

public class Medium_535_Encode_and_Decode_TinyURL {
    static HashMap<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    static String prefix = "http://tinyurl.com/";
    public static String encode(String longUrl) {
        int hash = longUrl.hashCode();
        String encodedUrl = prefix + Integer.toString(hash);
        map.put(encodedUrl, longUrl);
        return encodedUrl;
    }
    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return map.get(shortUrl).replace("http://tinyurl.com/", "");
    }
    public static void main(String[] args) {
        System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(decode(encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
