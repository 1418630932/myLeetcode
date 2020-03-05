package leetcode.easy.test1001To1200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-05
 * @time 17:57
 **/
public class Test1103 {
    public static void main(String[] args) {
        int[] ints = distributeCandies(7, 4);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int candyCost =1;
        while (candies>0){
            for (int i = 0; i <res.length; i++) {
                if (candies>=candyCost){
                    res[i] += candyCost;
                    candies -= candyCost++;
                }else {
                    res[i] += candies;
                    return res;
                }
            }
        }
        return  res;
    }

}
