package leetcode.middle.test201To400;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-22
 * @time 14:52
 **/
public class Test260 {
    public static void main(String[] args) {
        int[] ints = singleNumber(new int[]{1, 1, 2, 2, 3, 4, 5, 5});
        System.out.println(Arrays.toString(ints));
    }
    public static int[] singleNumber(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int xor = 0;
        for (int num : nums) {
            xor^=num;
        }
        int bit = 1;
        while ((xor&bit)==0){
            bit = bit<<1;
        }
        for (int num : nums) {
            if ((bit&num)==0){
                num1 ^=num;
            }else {
                num2^=num;
            }
        }
        return new int[]{num1,num2};
    }
}
