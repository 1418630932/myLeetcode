package leetcode.easy.test401To600;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-15
 * @time 16:10
 **/
public class Test448 {
    public static void main(String[] args) {
        List<Integer> disappearedNumbers1 = findDisappearedNumbers1(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <=nums.length ; i++) {
            set.add(i);
        }
        for (int i = 0; i <nums.length ; i++) {
            if (set.contains(nums[i])){
                set.remove(i);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (Integer integer : set) {
            list.add(integer);
        }
        return list ;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            int index = Math.abs(nums[i])-1;
            nums[index] = nums[index]<0?nums[index]: -1*nums[index];
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
}
