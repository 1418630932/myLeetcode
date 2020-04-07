package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-04-07
 * @time 18:45
 **/
public class Test33 {
    public static void main(String[] args) {
        boolean b = verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10});
        System.out.println(b);
    }
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder.length==0)return true;
        int rootValue =postorder[postorder.length-1];
        int index =-1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            if (postorder[i]<rootValue){
                index =i;
                break;
            }
        }
        //检查前半段是否比root大
        for (int i = 0; i <index ; i++) {
            if (postorder[i]>rootValue)return false;
        }
        int[] gtArr = Arrays.copyOfRange(postorder, index + 1, postorder.length-1);
        int[] lsArr = Arrays.copyOfRange(postorder, 0, index+1);
        return verifyPostorder(lsArr)&&verifyPostorder(gtArr);
    }
}
