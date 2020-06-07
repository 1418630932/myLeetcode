package leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-06-07
 * @time 16:19
 **/
public class Test126 {
    public static void main(String[] args) {
        System.out.println(findLadders("hot","dog" , Arrays.asList("hot","dog","dot") ));
    }
    static List<List<String>> res = new LinkedList<>();
    static int minSize = Integer.MAX_VALUE;

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        for (int i = 0; i < wordList.size(); i++) {
            String curWord = wordList.get(i);
            if (canChange(beginWord, curWord)) {
                boolean[] isVisited = new boolean[wordList.size()];
                isVisited[i] = true;
                LinkedList<String> list = new LinkedList<>();
                list.add(beginWord);
                list.add(curWord);
                helper(isVisited, list, wordList, curWord, endWord);
            }
        }
        return res;
    }

    private static void helper(boolean[] isVisited, LinkedList<String> list, List<String> wordList,  String curWord, String endWord) {
        if (curWord.equals(endWord)) {
            if (list.size() < minSize) {
                minSize=  list.size();
                res.clear();
                res.add(new LinkedList<>(list));
            } else if (list.size() == minSize) {
                res.add(new LinkedList<>(list));
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (!isVisited[i]&&canChange(curWord,s )){
                isVisited[i]=true;
                list.add(s);
                helper(isVisited, list, wordList, s,endWord);
                list.remove(list.size()-1);
                isVisited[i]=false;
            }
        }
    }

    public  static  boolean canChange(String word1, String word2) {
        int different = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) different++;
            if (different > 1) return false;
        }
        return different == 1;
    }
}
