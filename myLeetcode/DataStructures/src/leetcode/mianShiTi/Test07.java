package leetcode.mianShiTi;

import leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-04-01
 * @time 17:50
 **/
public class Test07 {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(1);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length==0||inorder.length==0)return null;
            int rootIndex = -1;
            int leftLength =-1; int rightLength =-1;
            for (int i = 0; i < inorder.length; i++) {

                if (inorder[i]==preorder[0])rootIndex = i;
            }
            leftLength = rootIndex;
            rightLength = inorder.length-1-rootIndex;
            TreeNode root = new TreeNode(preorder[0]);
            root.left =leftLength<=0?null: buildTree(Arrays.copyOfRange(preorder,1 ,1+leftLength ),Arrays.copyOfRange(inorder, 0, rootIndex) );
            root.right =rightLength<=0?null: buildTree(Arrays.copyOfRange(preorder, preorder.length-rightLength,preorder.length ), Arrays.copyOfRange(inorder,rootIndex+1 ,inorder.length ));
            return root;
    }
}
