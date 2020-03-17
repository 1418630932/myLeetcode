package leetcode.middle.test201To400;

/**
 * @author zhuliyang
 * @date 2020-03-16
 * @time 18:11
 **/
public class Test220 {
    public static void main(String[] args) {
        boolean b = containsNearbyAlmostDuplicate(new int[]{1, 0, 0, 1}, 1, 2);
        System.out.println(b);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                int numsAbs = Math.abs(nums[i]-nums[j]);
                int indexAbs = Math.abs(i-j);
                if (numsAbs==t&&indexAbs==k)return true;
            }
        }
        return false;
    }
}
