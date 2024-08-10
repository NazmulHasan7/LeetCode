// 1935. Maximum Number of Words You Can Type
package Easy;

public class Easy_1935_Maximum_Number_of_Words_You_Can_Type {
    public static int canBeTypedWords(String text, String brokenLetters) {
        boolean[] freq = new boolean[26];
        for (char c : brokenLetters.toCharArray())
            freq[c-'a'] = true;

        int count = 0;
        String[] strArr = text.split(" ");
        for (String str : strArr)
            for (char c : str.toCharArray())
                if (freq[c-'a']) {
                    count++;
                    break;
                }
        return strArr.length - count;
    }
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("leet code", "e"));
    }
}
