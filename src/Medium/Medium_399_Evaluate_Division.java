// 399. Evaluate Division
package Medium;
import java.util.*;

public class Medium_399_Evaluate_Division {
    static class Pair {
        String var;
        Double value;
        Pair(String var, Double value) {
            this.var = var;
            this.value = value;
        }
    }
    private static double res;
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        // Intuition -> [a,b] or a/b -> 2 then put in the map as a -> (b, 2) & b -> (a, 1/2)
        HashMap<String, List<Pair>> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double w = values[i];

            if (!map.containsKey(u))
                map.put(u, new ArrayList<>());
            map.get(u).add(new Pair(v, w));

            if (!map.containsKey(v))
                map.put(v, new ArrayList<>());
            map.get(v).add(new Pair(u, 1/w));
        }
        // Handling queries
        int m = queries.size();
        double[] answer = new double[m];

        for (int i=0; i<m; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            // if the variable is not found, then answer is -1
            if (!map.containsKey(u) || !map.containsKey(v)) {
                answer[i] = -1;
            } else if (u.equals(v)) {
                answer[i] = 1; // a/b = 1 where a == b
            } else {
                res = -1;
                dfs(map, new HashSet<>(), u, v, 1);
                answer[i] = res;
            }
        } return answer;
    }
    private static void dfs(HashMap<String, List<Pair>> map, HashSet<String> visited, String src, String dst, double value) {
        if (src.equals(dst)) {
            res = value;
            return;
        }
        visited.add(src);
        for (Pair p : map.get(src))
            if (!visited.contains(p.var))
                dfs(map, visited, p.var, dst, value * p.value);
    }
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }
}
