package leetcode.hard;

/**
 * @author zhuliyang
 * @date 2020-04-11
 * @time 15:35
 **/
public class Test887 {
    public static void main(String[] args) {
        int i = superEggDrop(2, 17);
        System.out.println(i);
    }
    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];   //k个鸡蛋 探测n层楼需要的次数
        //初始化 一个鸡蛋的时候的扔鸡蛋的值
        for (int i = 1; i <dp[0].length ; i++) {
            dp[1][i]=i;
        }
//        //初始化 一层楼的时候的扔鸡蛋的值
//        for (int i = 1; i <dp.length ; i++) {
//            dp[i][1] =1;
//        }
        for (int i = 2; i <dp.length ; i++) {//鸡蛋
            for (int j = 1; j <dp[0].length ; j++) {//楼层
                // i个鸡蛋  j层楼
                // 1<=l<=j  l：表示从第l层楼扔鸡蛋的最优解
                //如果碎了  最优就是 dp[i-1][l-1] ： 鸡蛋数-1  楼层数-1 (i-1个鸡蛋测试l-1层楼需要的次数)
                //如果没碎  最优就是 dp[i][j-l]  ： 鸡蛋不变  楼层数=j-l  （i个鸡蛋测试n-j层楼需要的次数）
                //次数 = dp[i][j] = min( max(碎了次数，没碎次数)+1)
                int res = Integer.MAX_VALUE;
                int start =1;
                int end = j;
                //如果是线性迭代发 时间复杂度O(KN^2)
                //改进 由于dp[i-1][mid-1]时线性递增的函数 dp[i][j-mid]时线性递减的函数
                //两个函数的min(max(y1,y2)）就是他们的交点处
                //所以 我们可以用二分查找来进行加速 快速找到两个函数的交点
                while (start<=end){
                    int mid = start+(end-start)/2;
                    if (dp[i-1][mid-1]==dp[i][j-mid]){
                        res = Math.min(res, dp[i][j-mid]+1);
                        break;
                    }else if (dp[i-1][mid-1]>dp[i][j-mid]){
                        end = mid-1;
                        res = Math.min(res,dp[i-1][mid-1]+1);
                    }else {
                        start=mid+1;
                        res = Math.min(res, dp[i][j-mid]+1);
                    }
;                }
                dp[i][j] = res;
            }
        }
        return dp[k][n];
    }
}
