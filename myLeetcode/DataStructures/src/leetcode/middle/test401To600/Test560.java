package leetcode.middle.test401To600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-05-15
 * @time 0:28
 **/
public class Test560 {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1 );
        int pre = 0;
        for(int i = 0; i<nums.length;i++){
            pre += nums[i];
            if (map.containsKey(pre-k)){
                count += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
