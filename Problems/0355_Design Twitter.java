class Twitter {
    HashMap<Integer, HashSet<Integer>> followers;
    List<int[]> tweets;

    public Twitter() {
        followers = new HashMap<>();
        tweets = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!followers.containsKey(userId))
            followers.put(userId, new HashSet<Integer>());
        tweets.add(new int[]{tweetId, userId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0; i--) {
            if (followers.get(userId).contains(tweets.get(i)[1]) ||
               userId == tweets.get(i)[1]) {
                res.add(tweets.get(i)[0]);
                if (res.size() == 10) return res;
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<Integer>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
 