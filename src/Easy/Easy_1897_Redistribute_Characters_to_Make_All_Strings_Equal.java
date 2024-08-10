// 1897. Redistribute Characters to Make All Strings Equal
package Easy;

public class Easy_1897_Redistribute_Characters_to_Make_All_Strings_Equal {
    public static boolean makeEqual(String[] words) {
        int length = words.length;
        if (length <= 1) return true;

        int[] freq = new int[26];
        for (String word : words)
            for (char c : word.toCharArray())
                freq[c-'a']++;

        for (int i=0; i<26; i++)
            if (freq[i] % length != 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(makeEqual(new String[] {"abc","aabc","bc"}));
        System.out.println(makeEqual(new String[] {"ab", "a"}));
    }
}
