package leetcode.easy.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-03
 * @time 15:14
 **/
public class Test100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){//两个都是空节点
            return true;
        }
        if (p==null||q==null){//其中一个是空节点
            return false;
        }
        if (p.val!=q.val){//两个节点值不相同
            return false;
        }
        return isSameTree(p.left,q.left )&&isSameTree(p.right,q.right); //左子节点&&右子节点
    }
}
