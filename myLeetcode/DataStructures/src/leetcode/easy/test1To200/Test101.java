package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-03
 * @time 16:18
 **/
public class Test101 {
    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
//    因此，该问题可以转化为：两个树在什么情况下互为镜像？
//
//    如果同时满足下面的条件，两个树互为镜像：
//
//    它们的两个根结点具有相同的值。
//    每个树的右子树都与另一个树的左子树镜像对称。

    public static boolean isSymmetric(TreeNode root) {
       if(root==null){return true;}
       return isMirror(root.right, root.left);//两棵树是不是镜像对称 即树1右子树  对称于 树2左子树
    }
    public static boolean isMirror(TreeNode right,TreeNode left){
        if (right==null&&left==null){return true;};
        if (right==null||left==null){return false;}
        return right.val==left.val&&isMirror(right.left,left.right )&&isMirror(right.right,left.left);
    }
}
