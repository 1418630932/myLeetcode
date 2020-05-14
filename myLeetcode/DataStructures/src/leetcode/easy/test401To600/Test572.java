package leetcode.easy.test401To600;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhuliyang
 * @date 2020-05-07
 * @time 0:02
 **/
public class Test572 {
    public static void main(String[] args) {
        char[][]  chars = new char[][]{"11111".toCharArray(),"11111".toCharArray(),"11111".toCharArray(),"11111".toCharArray()};
        int i = maximalSquare(chars);
        System.out.println(i);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s==null)return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.val==t.val){
                if (equals(poll,t ))return true;
            }
            if (poll.left!=null){
                queue.add(poll.left);
            }
            if (poll.right!=null){
                queue.add(poll.right);
            }
        }
        return false;
    }
    public boolean equals(TreeNode s,TreeNode t){
        if (s==null&&t==null)return true;
        if (s==null || t==null)return false;
        if (s.val!=t.val)return false;
        return equals(s.left,t.left)&&equals(s.right,t.right);
    }



    public static int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            dp[i][0] = matrix[i][0]=='1'?1:0;
        }
        for (int j = 0; j <matrix[0].length ; j++) {
            dp[0][j] = matrix[0][j]=='1'?1:0;
        }
        int max =0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1; j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                   int min = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                   if (min!=0){
                       dp[i][j] = (int) ((Math.sqrt(min)+1)*(Math.sqrt(min)+1));
                       max = Math.max(max,dp[i][j] );
                   }
                }
            }
        }
        return max;
    }

}
