package leetcode.middle.test201To400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-03-13
 * @time 21:33
 **/
public class Test208 {
    static class Trie {
        Set<String> set ;
        /** Initialize your data structure here. */
        public Trie() {
            set = new HashSet<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            set.add(word);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
           return set.contains(word);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for (String s : set) {
                if (s.startsWith(prefix))return true;
            }
            return false;
        }
    }
}
