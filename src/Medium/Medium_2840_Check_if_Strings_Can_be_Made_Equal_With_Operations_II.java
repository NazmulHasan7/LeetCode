// 2840. Check if Strings Can be Made Equal With Operations II
package Medium;

public class Medium_2840_Check_if_Strings_Can_be_Made_Equal_With_Operations_II {
    public static boolean checkStrings(String s1, String s2) {
        int[] even = new int[26];
        int[] odd = new int[26];
        int n = s1.length();

        for (int i=0; i<n; i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            if ((i & 1) == 1) {
                odd[c1]++;
                odd[c2]--;
            } else {
                even[c1]++;
                even[c2]--;
            }
        }
        for (int i=0; i<26; i++)
            if (even[i] != 0 || odd[i] != 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(checkStrings("abcdba", "cabdab"));
        System.out.println(checkStrings("abe", "bea"));
    }
}
