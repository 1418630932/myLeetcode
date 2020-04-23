package leetcode.middle.test201To400;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author zhuliyang
 * @date 2020-04-13
 * @time 11:57
 **/
public class Test355 {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(7);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.forEach(integer -> System.out.println(integer));
    }
//    public static void main(String[] args) {
//        Twitter twitter = new Twitter();
//
//// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
//        twitter.postTweet(1, 5);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//        System.out.println(twitter.getNewsFeed(1));
//
//// 用户1关注了用户2.
//        twitter.follow(1, 2);
//
//// 用户2发送了一个新推文 (推文id = 6).
//        twitter.postTweet(2, 6);
//
//// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
//// 推文id6应当在推文id5之前，因为它是在5之后发送的.
//        System.out.println(twitter.getNewsFeed(1));
//
//// 用户1取消关注了用户2.
//        twitter.unfollow(1, 2);
//
//// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
//// 因为用户1已经不再关注用户2.
//        System.out.println(twitter.getNewsFeed(1));
//    }
}
class Twitter {
    class article{
        int userId;
        int tweetId;
        long putMillis;//发布时间

        public int getTweetId() {
            return tweetId;
        }

        public article(int userId, int tweetId, long putMillis){
            this.userId = userId;
            this.tweetId = tweetId;
            this.putMillis = putMillis;

        }
    }
    //根据发布时间排的大顶堆
//    Queue<article> queue = new PriorityQueue<>((o1, o2) -> (int) (o2.putMillis-o1.putMillis));
    HashMap<Integer,List<article>> articleMap = new HashMap<>();
    HashMap<Integer,List<Integer>> followMap = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        article article = new article(userId, tweetId, System.currentTimeMillis());
        if (!articleMap.containsKey(userId)){
            List<article> articleList = new ArrayList<>();
            articleList.add(article);
            articleMap.put(userId,articleList);
        }else {
            articleMap.get(userId).add(article);
        }
        if (!followMap.containsKey(userId)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(userId);
            followMap.put(userId,list );
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followList = followMap.get(userId);
        List<article> articleList = new ArrayList<>();
        followList.forEach(id->{
                articleList.addAll(articleMap.get(id));
        });
        articleList.sort((o1, o2) -> (int) (o2.putMillis-o1.putMillis));
        int size = articleList.size();
        return articleList.subList(0,size>10?10:size).stream().map(article ::getTweetId ).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followMap.get(followerId)!=null){
            followMap.get(followerId).add(followeeId);
        }else {
            ArrayList<Integer> list  = new ArrayList<>();
            list.add(followeeId,followerId);
            followMap.put(followerId,list );
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followMap.get(followerId)!=null){
            List<Integer> list =followMap.get(followerId);
            list.removeIf(id->id==followeeId);
        }
    }
}
