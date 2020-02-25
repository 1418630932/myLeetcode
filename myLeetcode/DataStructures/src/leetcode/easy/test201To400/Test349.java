package leetcode.easy.test201To400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author zhuliyang
 * @date 2020-02-11
 * @time 20:33
 **/
public class Test349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        List<Integer> list = new LinkedList<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num)){
                set.remove(num);
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
