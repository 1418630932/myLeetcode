package leetcode.easy.test201To400;

/**
 * @author zhuliyang
 * @date 2020-02-10
 * @time 16:18
 **/
public class Test283 {
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[startIndex++]=nums[i];
            }
        }
        for(int j=startIndex;j<nums.length;j++){
            nums[j]=0;
        }
    }
}
