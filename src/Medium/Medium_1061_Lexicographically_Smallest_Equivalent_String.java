// 1061. Lexicographically Smallest Equivalent String
package Medium;

public class Medium_1061_Lexicographically_Smallest_Equivalent_String {
    private static int find(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] parent) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) return;

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i=0; i<26; i++) parent[i] = i;

        for (int i=0; i<s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            union(c1-'a', c2-'a', parent);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray())
            sb.append((char)(find(c-'a', parent) + 'a'));
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker", "morris", "parser"));
        System.out.println(smallestEquivalentString("hello", "world", "hold"));
        System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }
}
