package leetcode.easy.test1To200;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhuliyang
 * @date 2020-01-30
 * @time 14:26
 **/
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 22)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i );
            }
        }
        return null;
    }
}
