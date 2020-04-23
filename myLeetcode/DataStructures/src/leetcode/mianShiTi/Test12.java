package leetcode.mianShiTi;

/**
 * @author zhuliyang
 * @date 2020-04-14
 * @time 19:06
 **/
public class Test12 {
    public boolean exist(char[][] board, String word) {
        if(word==null)return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,isVisited,i,j,word,0))return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] isVisited, int i, int j, String word, int start) {
        if (start ==word.length())return true;
        if (i<0||j<0||i>=board.length||j>=board[0].length||isVisited[i][j]||board[i][j]!=word.charAt(start)){
            return false;
        }
        isVisited[i][j]=true;
        boolean res =  dfs(board, isVisited, i-1, j,word  ,start+1 )||
                dfs(board, isVisited, i, j-1,word  ,start+1 )||
                dfs(board, isVisited, i+1, j,word  ,start+1 )||
                dfs(board, isVisited, i, j+1,word  ,start+1 );
        isVisited[i][j]=false;
        return  res ;
    }
}
