package leetcode.easy.test1To200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuliyang
 * @date 2020-02-05
 * @time 16:36
 **/
public class Test136 {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1 );
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
