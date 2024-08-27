// 990. Satisfiability of Equality Equations
package Medium;

public class Medium_990_Satisfiability_of_Equality_Equations {
    private static int find(int i, int[] parent) {
        if (i == parent[i])
            return i;
        return parent[i] = find(parent[i], parent);
    }
    private static void union(int x, int y, int[] rank, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);

        if (xParent == yParent)
            return;
        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
    public static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] rank = new int[26];

        for (int i=0; i<26; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        // make a set of equals
        for (String equation : equations)
            if (equation.charAt(1) == '=')
                union(equation.charAt(0)-'a', equation.charAt(3)-'a', rank, parent);

        // now look for the not equals
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int xParent = find(equation.charAt(0)-'a', parent);
                int yParent = find(equation.charAt(3)-'a', parent);
                // if both parent are same then the equation cannot be true
                if (xParent == yParent)
                    return false;
            }
        } return true;
    }
    public static void main(String[] args) {
        System.out.println(equationsPossible(new String[]{"a==b","b!=a"}));
        System.out.println(equationsPossible(new String[]{"a==b","b==a"}));
    }
}
