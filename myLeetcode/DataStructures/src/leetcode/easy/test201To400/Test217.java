package leetcode.easy.test201To400;

import java.util.HashSet;

/**
 * @author zhuliyang
 * @date 2020-02-09
 * @time 14:47
 **/
public class Test217 {
    public static void main(String[] args) {

    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set  = new HashSet();
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i)){
                set.add(i);
            }else{
                return true;
            }
        }
        return false;
    }
}
