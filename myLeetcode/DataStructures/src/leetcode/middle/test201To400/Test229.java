package leetcode.middle.test201To400;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-19
 * @time 21:03
 **/
public class Test229 {
    public static void main(String[] args) {
        List<Integer> list = majorityElement(new int[]{0,0,0});
        System.out.println(list);
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int num1 =0; int tickit1 = 0;
        int num2 = 0; int tickit2 = 0;
        //找出数组中出现最多的两个数
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==num1){
                tickit1++;
            }else if ((nums[i]==num2)){
                tickit2++;
            }else if (tickit1==0){
                num1 =nums[i];
                tickit1++;
            }else if(tickit2==0){
                num2 = nums[i];
                tickit2++;
            }else if (nums[i]!=num1&&nums[i]!=num2){
                tickit1--;
                tickit2--;
            }
        }
        tickit1=0;
        tickit2=0;
        for (int num : nums) {
            if (num==num1)tickit1++;
            else if (num==num2)tickit2++;
        }
        if (tickit1>nums.length/3)res.add(num1);
        if (tickit2>nums.length/3)res.add(num2);


        return res;
    }
}
