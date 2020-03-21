package leetcode.middle.test201To400;

import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-03-21
 * @time 14:05
 **/
public class Test238 {
    public static void main(String[] args) {
        int[] ints = productExceptSelf(new int[]{1, 2, 3, 4});
    }
    public static int[] productExceptSelf(int[] nums) {
        int allProduct =1;
        int zeroCount =0;
        for (int num : nums) {
            if (num==0)zeroCount++;
            allProduct*= num;
        }
        int allProductExceptZero =1;
        if (zeroCount ==1){
            int product=1;
            int zeroIndex =-1;
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]!=0){
                    product *=nums[i];
                    nums[i]=0;
                }else {
                    zeroIndex =i;
                }
            }
            nums[zeroIndex] =product;
        }else {
            for (int i = 0; i <nums.length ; i++) {
                nums[i]= nums[i]==0?0:allProduct/nums[i];
            }
        }

        return nums;
    }


    public  int[] productExceptSelf1(int[] nums) {
        int left =1;
        int right =1;
        int[] res = new int[nums.length];
        //从左边乘  每个元素记录除了他自己以外的左乘积
        for (int i = 0; i <nums.length ; i++) {
            res[i] = left;
            left *= nums[i];
        }
        //从右边乘  每个元素记录了除了他自己  左乘积*右乘积
        for (int i = nums.length-1; i >=0 ; i--) {
            res[i]*=right;
            right *= nums[i];
        }
        return res;
    }
}
