// 2115. Find All Possible Recipes from Given Supplies
package Medium;
import java.util.*;

public class Medium_2115_Find_All_Possible_Recipes_from_Given_Supplies {
    // Brute Force Approach
    // TC -> O(n^2*m)
    // SC -> O(n) + O(supplies)
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Store all the ingredients to the set for a constant time lookup
        HashSet<String> availableIng = new HashSet<>(Arrays.asList(supplies)); // O(size of supplies)

        int n = recipes.length;
        int size = n;
        // To check if all the ingredients are available for this recipe
        boolean[] isCooked = new boolean[n]; // O(n)
        List<String> answer = new ArrayList<>();

        while (n-- > 0) { // O(n)
            // one of the recipes could be dependent on another recipe to be cooked
            for (int i=0; i<size; i++) { // O(n)

                if (isCooked[i]) continue;

                boolean readyToCook = true;
                for (String ing : ingredients.get(i)) { // O(size of ingredients)
                    if (!availableIng.contains(ing)) { // O(1)
                        readyToCook = false;
                        break;
                    }
                }
                if (readyToCook) {
                    answer.add(recipes[i]);
                    availableIng.add(recipes[i]);
                    isCooked[i] = true;
                }
            }
        }
        return answer;
    }


    // Topological sort Approach BFS -> Kahn's Algorithm
    // A recipe is dependent on another recipe, sandwich is dependent on bread
    // so bread should come before sandwich
    // TC -> O(n * m)
    public static List<String> findAllRecipesOpt(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> availableIng = new HashSet<>(Arrays.asList(supplies));
        int n = recipes.length;

        int[] inDegree = new int[n];
        Map<String, List<Integer>> adj = new HashMap<>();

        for (int i=0; i<n; i++) { // O(n)
            for (String ing : ingredients.get(i)) { // O(m)
                if (!availableIng.contains(ing)) {
                    // since the ingredient is not available in the set, it is a recipe also
                    // recipe[i] is dependent on this ingredient(recipe)
                    adj.computeIfAbsent(ing, key -> new ArrayList<>()).add(i);
                    inDegree[i]++;
                }
            }
        }

        // Simple topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<n; i++) // O(n)
            if (inDegree[i] == 0)
                queue.add(i);

        List<String> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            answer.add(recipes[idx]);

            if (adj.containsKey(recipes[idx])) {
                for (int recipeIdx : adj.get(recipes[idx])) {
                    inDegree[recipeIdx]--;
                    if (inDegree[recipeIdx] == 0)
                        queue.add(recipeIdx);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findAllRecipes(
                new String[]{"bread"},
                List.of(Arrays.asList("yeast","flour"), Arrays.asList("bread","meat")),
                new String[] {"yeast","flour","meat"})
        );
        System.out.println(findAllRecipes(
                new String[]{"bread","sandwich","burger"},
                List.of(Arrays.asList("yeast","flour"), Arrays.asList("bread","meat"), Arrays.asList("sandwich","meat","bread")),
                new String[] {"yeast","flour","meat"})
        );
    }
}
