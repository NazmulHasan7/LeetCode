// 2456. Most Popular Video Creator
package Medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Medium_2456_Most_Popular_Video_Creator {
    /* static class Creator {
        String name;
        int totalViews;
        String mostViewedVideo;
        int mostViews;

        Creator (String name, int views, String id) {
            this.name = name;
            this.totalViews = views;
            this.mostViewedVideo = id;
            this.mostViews = views;
        }
    }
    // TC -> O(N log N) SC -> O(n)
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Creator> creatorMap = new HashMap<>();
        PriorityQueue<Creator> maxHeap = new PriorityQueue<>((c1, c2) -> {
            if (c1.totalViews == c2.totalViews) // compare and find the lexicographically smallest id
                return c1.mostViewedVideo.compareTo(c2.mostViewedVideo);
            return c2.totalViews - c1.totalViews;
        });

        int n = creators.length;
        for (int i=0; i<n; i++) {
            Creator creator;
            if (!creatorMap.containsKey(creators[i])) {
                creator = new Creator(creators[i], views[i], ids[i]);
            } else { // update total views
                creator = creatorMap.get(creators[i]);
                creator.totalViews += views[i];

                // update the most views and most viewed video
                if (creator.mostViews < views[i]) {
                    creator.mostViews = views[i];
                    creator.mostViewedVideo = ids[i];
                } else if (creator.mostViews == views[i]) {
                    creator.mostViewedVideo = (creator.mostViewedVideo.compareTo(ids[i]) > 0 ?
                            ids[i] : creator.mostViewedVideo);
                }
            }
            creatorMap.put(creators[i], creator);
        }
        // Add creators to the max-heap
        maxHeap.addAll(creatorMap.values());

        List<List<String>> answer = new ArrayList<>();
        int highestViews = maxHeap.peek().totalViews;

        while (!maxHeap.isEmpty()) {
            Creator c = maxHeap.poll();
            if (c.totalViews != highestViews) break;
            answer.add(List.of(c.name, c.mostViewedVideo));
        }
        return answer;
    } */

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, Creator> creatorMap = new HashMap<>();

        long maxViews = 0;
        for(int i=0; i<creators.length; i++) {
            Creator creator = creatorMap.get(creators[i]);
            if (creator == null) {
                creator = new Creator(creators[i]);
                creatorMap.put(creators[i], creator);
            }
            creator.updateViews(ids[i], views[i]);
            maxViews = Math.max(maxViews, creator.totalViews);
        }

        for (Creator creator : creatorMap.values()) {
            if (creator.totalViews == maxViews)
                output.add(List.of(creator.name, creator.mostViewedVideo));
        }
        return output;
    }
    static class Creator{
        String name;
        long totalViews;
        String mostViewedVideo;
        long mostViews;

        Creator (String name) {
            this.name = name;
            this.totalViews = 0;
            this.mostViewedVideo = null;
            this.mostViews = Integer.MIN_VALUE;
        }

        public void updateViews(String video, int views){
            totalViews += views;
            if (views > mostViews) {
                mostViewedVideo = video;
                mostViews = views;
            } else if (views == mostViews) {
                mostViewedVideo = mostViewedVideo.compareTo(video) > 0 ? video : mostViewedVideo;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(mostPopularCreator(
                new String[]{"alice","bob","alice","chris"},
                new String[]{"one","two","three","four"},
                new int[]{5,10,5,4})
        );
        System.out.println(mostPopularCreator(
                new String[]{"alice","alice","alice"},
                new String[]{"a","b","c"},
                new int[]{1,2,2})
        );
    }
}
