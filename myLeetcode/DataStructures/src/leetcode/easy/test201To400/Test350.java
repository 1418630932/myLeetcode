package leetcode.easy.test201To400;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-12
 * @time 14:18
 **/
public class Test350 {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }else {
                map.put(i,map.get(i)+1 );
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int j : nums2) {
            if (map.get(j)!=null&&map.get(j)!=0){
                map.put(j,map.get(j)-1 );
                list.add(j);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
