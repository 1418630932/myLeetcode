package leetcode.hard;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-05-04
 * @time 0:04
 **/
public class Test45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > max) {
                count++;
                max = i + nums[i];
                if (max >= nums.length - 1) return count;
            }
        }
        return count;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        Integer last = null;
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if (peek.left!=null&&!set.contains(peek.left)){
                stack.push(peek.left);
                continue;
            }
            TreeNode pop = stack.pop();
            if (last!=null&&last>=pop.val)return false;
            last = pop.val;
            set.add(pop);
            if (peek.right!=null){
                stack.push(peek.right);
            }
        }
        return false;
    }

}
