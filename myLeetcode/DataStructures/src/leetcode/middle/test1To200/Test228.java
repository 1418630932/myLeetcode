package leetcode.middle.test1To200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-03-19
 * @time 20:23
 **/
public class Test228 {
    public static void main(String[] args) {
        List<String> list = summaryRanges(new int[]{0, 1,2,4,5,7});
        System.out.println(list);
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <nums.length ; i++) {
            int j =i;
            sb.append(nums[i]).append("->");
            while (i+1<nums.length&&nums[i+1]-nums[i]==1){
                i++;
            }
            if (j!=i){
                sb.append(nums[i]).append("->");
            }
            res.add(sb.delete(sb.length()-2, sb.length()).toString());
            sb = new StringBuilder();
        }
        return res;
    }
}
