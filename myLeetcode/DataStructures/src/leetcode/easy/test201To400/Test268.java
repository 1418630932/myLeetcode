package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 15:30
 **/
public class Test268 {
    public int missingNumber(int[] nums) {
        int sum = nums.length*(nums.length+1)/2;
        for(int num :nums){
            sum -=num;
        }
        return sum;
    }
}
