// 841. Keys and Rooms
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium_841_Keys_and_Rooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        dfs(rooms, 0, visited);
        for (boolean v : visited)
            if (!v) return false;
        return true;
    }
    public static void dfs(List<List<Integer>> rooms, int source, boolean[] visited) {
        for (int room : rooms.get(source)) {
            if (!visited[room]) {
                visited[room] = true;
                dfs(rooms, room, visited);
            }
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());
        System.out.println(canVisitAllRooms(rooms));

        rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));
        System.out.println(canVisitAllRooms(rooms));
    }
}
