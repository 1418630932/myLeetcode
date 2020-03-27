package leetcode.easy.test801To1000;

/**
 * @author zhuliyang
 * @date 2020-03-26
 * @time 9:39
 **/
public class Test999 {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (board[i][j]=='R'){
                    return count(board,i ,j , 1)
                            +count(board,i ,j , 2)
                            +count(board,i , j, 3)
                            +count(board,i ,j ,4 );
                }
            }
        }
        return 0;
    }
    public int count(char[][] board,int i,int j,int turn){
        if (i<0||j<0||i==8||j==8||board[i][j]=='B')return 0;
        if (board[i][j]=='p')return 1;
        int left = turn==1?count(board, i, j-1, 1):0;
        int right = turn==2?count(board, i, j+1, 2):0;
        int up = turn==3?count(board, i-1, j, 3):0;
        int  down= turn==4?count(board, i+1, j, 4):0;
        return left+right+up+down;
    }
}
