package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-02
 * @time 14:14
 **/
public class Test130 {
    public static void main(String[] args) {
        char[][] board = {"XXXX".toCharArray(), "XOOX".toCharArray(), "XXOX".toCharArray(), "XOXX".toCharArray()};
        solve(board);
        System.out.println(board);
    }

    public static void solve(char[][] board) {
        if(board.length==0)return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    //找到边界点 开始dfs
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {//表示和边界联通
                    board[i][j] = 'O';//还原
                } else if (board[i][j] == 'O') {//表示和边界不连通  dfs不到
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            //'#'代表访问过
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);//下
        dfs(board, i - 1, j);//上
        dfs(board, i, j + 1);//右
        dfs(board, i, j - 1);//左
    }
}
