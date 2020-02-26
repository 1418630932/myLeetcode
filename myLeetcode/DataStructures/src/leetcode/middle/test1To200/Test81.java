package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-26
 * @time 14:51
 **/
public class Test81 {
    public boolean search(int[] nums, int target) {
        if(nums == null){
            return false;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == target){
                return true;
            }
        }
        return false;
    }
}
