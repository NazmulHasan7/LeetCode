// 3084. Count Substrings Starting and Ending with Given Character
package Medium;

public class Medium_3084_Count_Substrings_Starting_and_Ending_with_Given_Character {
    public static long countSubstrings(String s, char c) {
        long x = 0;
        for (char ch : s.toCharArray())
            if (ch == c) x++;

        return (x * (x+1)) / 2;
    }
    public static void main(String[] args) {
        System.out.println(countSubstrings("abada", 'a'));
        System.out.println(countSubstrings("zzz", 'z'));
    }
}
