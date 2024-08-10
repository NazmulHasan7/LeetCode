// 1662. Check If Two String Arrays are Equivalent
package Easy;

public class Easy_1662_Check_If_Two_String_Arrays_are_Equivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "", s2 = "";
        for (String word: word1)
            s1 += word;
        for (String word: word2)
            s2 += word;
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "bc"}));
        System.out.println(arrayStringsAreEqual(new String[] {"ab", "c"}, new String[] {"a", "cb"}));
    }
}
