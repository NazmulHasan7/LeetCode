// 2278. Percentage of Letter in String
package Easy;

public class Easy_2278_Percentage_of_Letter_in_String {
    public static int percentageLetter(String s, char letter) {
        int count = 0;
        for (char c : s.toCharArray())
            if (c == letter) count++;
        return (int) ((count * 100.0) / s.length());
    }
    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
        System.out.println(percentageLetter("jjjj", 'k'));
    }
}
