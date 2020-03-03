package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-02
 * @time 15:34
 **/
public class Test127 {
    public static void main(String[] args) {
        int i = ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(i);
    }

    //BFS的思想
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[wordList.size()];
        queue.add(beginWord);
        int depth = 0;//层数
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size > 0) {//遍历这层的数据 把可以改变一个位置的字符放入队列 留着下层遍历
                size--;
                String poll = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (!isVisited[i]) {
                        String cur = wordList.get(i);
                        if (canChange(cur, poll)) {//有一个单词的区别
                            if (cur.equals(endWord)) return depth+1;
                            queue.add(cur);
                            isVisited[i] = true;
                        }
                    }
                }
            }
        }
        return 0;
    }

    //是否可以转换的辅助函数
    public static boolean canChange(String s, String t) {
        int len = s.length();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
