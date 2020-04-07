package leetcode.hard;

/**
 * @author zhuliyang
 * @date 2020-04-06
 * @time 14:40
 **/
public class Test72 {
    public static void main(String[] args) {
        int i = minDistance("horse",
                "ros");
    }
    public static int minDistance(String word1, String word2) {
        int m = word2.length();
        int n = word1.length();
        int[][] cost = new int[m+1][n+1];
        for (int i = 0; i <= m; ++i) {
            cost[i][0] = i;
        }
        for (int j = 0; j <= n; ++j) {
            cost[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word2.charAt(i-1)==word1.charAt(j-1)){
                    //如果他们当前字符相等  就不需要变动
                    cost[i][j]=cost[i-1][j-1];
                }else {
                    //如果当前字符不等
                    //需要变化的步数可能： i-1变化到j-1 然后变化i字符为j
                    //                     i-1变化到j 然后删除i字符
                    //                     i变化到j-1 然后加一个字符
                    //取三种最大值即可
                    cost[i][j]=1+Math.max(cost[i-1][j-1],Math.max(cost[i][j-1], cost[i-1][j]));
                }
            }
        }
        return cost[m][n];
    }
}
