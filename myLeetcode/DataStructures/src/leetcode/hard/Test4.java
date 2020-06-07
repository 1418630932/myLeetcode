package leetcode.hard;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-05-24
 * @time 0:07
 **/
public class Test4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1==null)return nums2[nums2.length/2];
        if (nums2==null)return nums1[nums1.length/2];
        int totalLen = nums1.length+nums2.length;
        int mid1 = -1;int mid2 = -1;
        if ((totalLen&1)==1){
            mid1 = totalLen/2;
            mid2 = totalLen/2;
        }else {
            mid1 = totalLen/2-1;
            mid2 = totalLen/2;
        }
        return 0.0;
    }
}

class LRUCache {
    Map<Integer,Integer> map = new LinkedHashMap();
    int maxCap;
    public LRUCache(int capacity) {
        maxCap = capacity;
    }

    public int get(int key) {
        if (map.get(key)!=null){
            Integer value = map.get(key);
            map.remove(key);
            map.put(key,value );
            return value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)&&map.size()==maxCap){
            removeTop(map);
        }
        map.remove(key);
        map.put(key,value);
    }
    public void removeTop(Map map){
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            map.remove(entry.getKey());
            return;
        }
    }


    public static void main(String[] args) {
        int duplicate = findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(duplicate);
    }
    public static int findDuplicate(int[] nums) {
        int nextIndex = -1;
        int start = nums[0];
        while (true){
            if (start ==nums[start])return start;
            nextIndex = nums[start];
            nums[start] = start;
            start = nextIndex;
        }
    }


}
