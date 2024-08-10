// 1374. Generate a String With Characters That Have Odd Counts
package Easy;

public class Easy_1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {
    public static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) sb.append("a".repeat(n-1)).append("b");
        else sb.append("a".repeat(n));
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(generateTheString(4));
        System.out.println(generateTheString(2));
        System.out.println(generateTheString(7));
    }
}
