package leetcode.middle.test1To200;

import leetcode.utils.TreeNode;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-02-29
 * @time 14:29
 **/
public class Test106 {
    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0){
            return null;
        }
        int rootIndex = postorder.length-1;
        TreeNode root=new TreeNode (postorder[rootIndex]);
        for(int i=inorder.length-1;i>=0;i--){
            if(postorder[rootIndex]==inorder[i]){
                root.left=buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,rootIndex));
                break;
            }
        }
        return root;
    }
}
