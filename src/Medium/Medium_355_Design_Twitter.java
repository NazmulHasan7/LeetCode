// 355. Design Twitter
package Medium;
import java.util.*;

public class Medium_355_Design_Twitter {
    static class Twitter {
        int time;
        PriorityQueue<int[]> tweets;
        Map<Integer, Set<Integer>> users;
        public Twitter() {
            time = 0;
            users = new HashMap<>();
            // Maintain a max heap based on tweet time
            tweets = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        }
        public void postTweet(int userId, int tweetId) {
            if (!users.containsKey(userId)) {
                users.put(userId, new HashSet<>());
                // Assuming the users also follow them
                users.get(userId).add(userId);
            }
            tweets.add(new int[] {time++, tweetId, userId});
        }
        public List<Integer> getNewsFeed(int userId) {
            // Pop the most recent tweets and then add them again
            List<Integer> feed = new ArrayList<>();
            List<int[]> removedTweets = new ArrayList<>();
            int count = 0;

            while (!tweets.isEmpty() && count < 10) {
                int[] tweet = tweets.poll();
                // Check if the tweet is from someone the user is following
                if (users.get(userId).contains(tweet[2])) {
                    feed.add(tweet[1]);
                    count++;
                }
                removedTweets.add(tweet);
            } tweets.addAll(removedTweets);
            return feed;
        }
        public void follow(int followerId, int followeeId) {
            if (!users.containsKey(followerId)) {
                users.put(followerId, new HashSet<>());
                // Assuming the users also follow them
                users.get(followerId).add(followerId);
            }
            users.get(followerId).add(followeeId);
        }
        public void unfollow(int followerId, int followeeId) {
            users.get(followerId).remove(followeeId);
        }
    }
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
