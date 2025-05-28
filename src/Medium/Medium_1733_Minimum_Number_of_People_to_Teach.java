// 1733. Minimum Number of People to Teach
package Medium;
import java.util.HashMap;
import java.util.HashSet;

public class Medium_1733_Minimum_Number_of_People_to_Teach {
    // TC -> O((M+F)∗N) SC -> O(M∗N)
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // user -> language_set map
        HashMap<Integer, HashSet<Integer>> userLanguageMap = new HashMap<>();
        int m = languages.length;

        for (int i=0; i<m; i++) {
            int user = i+1;
            HashSet<Integer> set = new HashSet<>();
            for (int lan : languages[i])
                set.add(lan);

            userLanguageMap.put(user, set);
        }

        // keep track of users who cannot communicate
        HashSet<Integer> userSet = new HashSet<>();

        outer :
        for (int[] friend : friendships) {
            int u = friend[0];
            int v = friend[1];
            HashSet<Integer> uLan = userLanguageMap.get(u);
            HashSet<Integer> vLan = userLanguageMap.get(v);

            for (int lan : uLan)
                if (vLan.contains(lan))
                    continue outer;
            // no language in common, they cannot communicate
            userSet.add(u);
            userSet.add(v);
        }

        int size = userSet.size();
        // find the highest known language among the users who cannot communicate
        int maxKnown = 0;

        HashMap<Integer, Integer> languageCountMap = new HashMap<>();
        for (int user : userSet) {
            for (int lan : userLanguageMap.get(user)) {
                int freq = languageCountMap.getOrDefault(lan,0);
                languageCountMap.put(lan, freq+1);
                maxKnown = Math.max(maxKnown, freq+1);
            }
        }
        return size - maxKnown; // need to teach those who do not speak the maxKnown language
    }
    public static void main(String[] args) {
        System.out.println(minimumTeachings(2, new int[][]{{1},{2},{1,2}}, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(minimumTeachings(3, new int[][]{{2},{1,3},{1,2},{3}}, new int[][]{{1,4},{1,2},{3,4},{2,3}}));
    }
}
