// 3042. Count Prefix and Suffix Pairs I
package Easy;

public class Easy_3042_Count_Prefix_and_Suffix_Pairs_I {
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0, length = words.length;
        for (int i=0; i<length-1; i++)
            for (int j=i+1; j<length; j++)
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i]))
                    count++;
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[] {"a","aba","ababa","aa"}));
        System.out.println(countPrefixSuffixPairs(new String[] {"pa","papa","ma","mama"}));
        System.out.println(countPrefixSuffixPairs(new String[] {"abab","ab"}));
    }
}
