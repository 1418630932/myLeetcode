package leetcode.easy.test201To400;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 15:06
 **/
public class Test219 {
    public static void main(String[] args) {
        containsNearbyDuplicate(new int[]{1,2,3,1}, 3);
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i );
            }else {
                if (i-map.get(nums[i])<k){
                    return true;
                }else {
                    map.put(nums[i],i );
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <nums.length ; i++) {
            if (set.contains(nums[i]))return true;
            set.add(nums[i]);
            if (set.size()>k){
                set.remove(nums[i-k]);//移除最旧的元素
            }
        }
        return false;
    }
}
