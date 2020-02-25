package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-01-31
 * @time 18:21
 **/
public class Test27 {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=val){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
