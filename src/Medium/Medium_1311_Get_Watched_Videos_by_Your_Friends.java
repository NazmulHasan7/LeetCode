// 1311. Get Watched Videos by Your Friends
package Medium;
import java.util.*;

public class Medium_1311_Get_Watched_Videos_by_Your_Friends {
    public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited[id] = true;

        while (!queue.isEmpty() && level > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currId = queue.poll();
                for (int friendId : friends[currId]) {
                    if (!visited[friendId]) {
                        visited[friendId] = true;
                        queue.add(friendId);
                    }
                }
            } level--;
        }

        if (queue.isEmpty())
            return new ArrayList<>();
        // now the queue only holds the ids that video count is required
        return getVideos(watchedVideos, queue);
    }

    private static ArrayList<String> getVideos(List<List<String>> watchedVideos, Queue<Integer> queue) {
        HashMap<String, Integer> videoCountMap = new HashMap<>();
        for (int friendId : queue) {
            for (String video : watchedVideos.get(friendId))
                videoCountMap.put(video, videoCountMap.getOrDefault(video, 0)+1);
        }
        System.out.println(videoCountMap);

        ArrayList<String> answer = new ArrayList<>(videoCountMap.keySet());
        answer.sort((a, b) -> {
            int aCount = videoCountMap.get(a);
            int bCount = videoCountMap.get(b);
            if (aCount == bCount) return a.compareTo(b);
            return aCount - bCount;
        });
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();
        watchedVideos.add(List.of("A","B"));
        watchedVideos.add(List.of("C"));
        watchedVideos.add(List.of("B","C"));
        watchedVideos.add(List.of("D"));

        int[][] friends = new int[][]{{1,2},{0,3},{0,3},{1,2}};
        System.out.println(watchedVideosByFriends(watchedVideos, friends, 0, 1));
    }
}
