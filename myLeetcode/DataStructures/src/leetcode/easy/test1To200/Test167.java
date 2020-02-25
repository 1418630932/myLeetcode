package leetcode.easy.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-06
 * @time 16:12
 **/
public class Test167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 22)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length-1;
        int sum = Integer.MIN_VALUE;
        while (sum!=target){
            sum = numbers[index1]+numbers[index2];
            if (sum<target){index1++;}
            if (sum>target){index2--;}
        }
        return new int[]{index1+1,index2+1};
    }
}
