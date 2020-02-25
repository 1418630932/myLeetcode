package leetcode.easy.test1To200;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-01
 * @time 18:34
 **/
public class Test66 {
    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{9, 9, 9, 8});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
