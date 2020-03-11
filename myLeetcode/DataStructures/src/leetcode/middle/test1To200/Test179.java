package leetcode.middle.test1To200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhuliyang
 * @date 2020-03-11
 * @time 18:59
 **/
public class Test179 {
    public static void main(String[] args) {
        String s = largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
        System.out.println(s);
    }

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1);
            }
        });
        if (arr[0] .equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
