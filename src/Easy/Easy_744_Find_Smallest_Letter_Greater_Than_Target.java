// 744. Find Smallest Letter Greater Than Target
package Easy;

public class Easy_744_Find_Smallest_Letter_Greater_Than_Target {
    public static char nextGreatestLetter(char[] letters, char target) {
        char ans = '~';
        for (char c : letters)
            if (c > target && c < ans) ans = c;
        return ans == '~' ? letters[0] : ans;
    }
    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'a'));
        System.out.println(nextGreatestLetter(new char[] {'c','f','j'}, 'c'));
        System.out.println(nextGreatestLetter(new char[] {'x','x','y','y'}, 'z'));
    }
}
