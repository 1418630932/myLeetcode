package leetcode.middle.test1201To1400;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author zhuliyang
 * @date 2020-05-20
 * @time 0:14
 **/
public class Test1371 {
    public int findTheLongestSubstring(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        map.put('a',new LinkedList<>());
        map.put('e',new LinkedList<>());
        map.put('i',new LinkedList<>());
        map.put('o',new LinkedList<>());
        map.put('u',new LinkedList<>());
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {

        }
        return max;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length ==0)return null;
        if (preorder.length==1 || preorder.length==1)return new TreeNode(preorder[0]);
        TreeNode root  = new TreeNode(preorder[0]);
        int splitIndex = -1;
        for (int i = 0; i <inorder.length ; i++) {
            if (root.val==inorder[i]){
                splitIndex = i;
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1 ,1+splitIndex ),Arrays.copyOfRange(inorder, 0, splitIndex) );
        root.right = buildTree(Arrays.copyOfRange(preorder,1+splitIndex ,preorder.length ),Arrays.copyOfRange(inorder, splitIndex+1, inorder.length) );
        return  root;
    }
}
