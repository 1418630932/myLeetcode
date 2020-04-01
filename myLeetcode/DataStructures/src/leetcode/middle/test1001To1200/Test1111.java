package leetcode.middle.test1001To1200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-04-01
 * @time 14:43
 **/
public class Test1111 {
    public static void main(String[] args) {
        int[] ints = maxDepthAfterSplit("(()())");
        System.out.println(Arrays.toString(ints));
    }
    public static int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        for (int i = 0; i <seq.toCharArray().length ; i++) {
            arr[i] = seq.toCharArray()[i]=='('?(i&1):(i+1)&1;
        }
        return arr;
    }
}
