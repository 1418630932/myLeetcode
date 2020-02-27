package leetcode.middle.test1To200;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhuliyang
 * @date 2020-02-27
 * @time 14:41
 **/
public class Test95 {
//    public static void main(String[] args) {
//        List<TreeNode> treeNodes = generateTrees(3);
//        System.out.println(treeNodes);
//    }
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new LinkedList<TreeNode>();
        return helper(1,n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start>end){
            res.add(null);
            return res;
        }
        for (int i = start; i <=end ; i++) {
            List<TreeNode> leftNodes = helper(start, i-1 );
            List<TreeNode> rightNodes = helper(i+1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode cur = new TreeNode(i);
                    cur.left= leftNode;
                    cur.right= rightNode;
                    res.add(cur);
                }
            }
        }
        return res;
    }
//    public static List<TreeNode> generateTrees(int n) {
//        boolean[] isVisited = new boolean[n + 1];
//        List<TreeNode> res = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            TreeNode root = new TreeNode(i);
//            isVisited[i]=true;
//            dfs(res, isVisited, root, root, 1);
//            isVisited[i]=false;
//        }
//        return res;
//    }
//
//    private static void dfs(List<TreeNode> res, boolean[] isVisited, TreeNode root, TreeNode node, int count) {
//        if (count == isVisited.length-1) {
//            res.add(root);
//            return;
//        }
//        for (int i = 1; i <= isVisited.length-1; i++) {
//            if (!isVisited[i]) {
//                isVisited[i]=true;
//                TreeNode curNode = new TreeNode(i);
//                if (i<node.val){
//                    node.left = curNode;
//                }else if (i>node.val){
//                    node.right= curNode;
//                }
//                dfs(res, isVisited,root ,curNode ,count+1 );
//                for (int j = 1; j <= isVisited.length-1; j++) {
//                    if (!isVisited[j]) {
//                        isVisited[j] = true;
//                        TreeNode curNode2 = new TreeNode(j);
//                        if (j < node.val) {
//                            node.left = curNode2;
//                        } else if (j > node.val) {
//                            node.right = curNode2;
//                        }
//                        dfs(res, isVisited, root, curNode2, count + 2);
//                        isVisited[j]=false;//回溯
//                    }
//                }
//                isVisited[i]=false;//回溯
//                node.left=null; node.right=null;
//            }
//        }
//    }

}
