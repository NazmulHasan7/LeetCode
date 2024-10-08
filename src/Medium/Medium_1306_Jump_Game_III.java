// 1306. Jump Game III
package Medium;

public class Medium_1306_Jump_Game_III {
    // TC & SC -> O(n) [visited array + stack]
    public static boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return dfs(arr, visited, start, n);
    }
    private static boolean dfs(int[] arr, boolean[] visited, int idx, int n) {
        if (idx < 0 || idx >= n || visited[idx]) return false;
        if (arr[idx] == 0) return true;
        visited[idx] = true;
        return dfs(arr, visited,idx - arr[idx], n) || dfs(arr, visited, idx + arr[idx], n);
    }
    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2}, 5));
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2}, 0));
        System.out.println(canReach(new int[]{3,0,2,1,2}, 2));
    }
}
