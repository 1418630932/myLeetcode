package leetcode.middle.test1To200;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-06
 * @time 17:59
 **/
public class Test146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    static class LRUCache {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> list = new LinkedList<>();
        int size = 0;

        public LRUCache(int capacity) {
            size = capacity;
        }

        public int get(int key) {
            if (map.get(key)==null)return -1;
            list.remove(key);
            list.addLast(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                map.put(key,value );
            }
            if (list.size() == size) {
                Integer remove = list.removeFirst();
                map.remove(remove);
            }
            map.put(key, value);
            list.addLast(key);
        }
    }
}
