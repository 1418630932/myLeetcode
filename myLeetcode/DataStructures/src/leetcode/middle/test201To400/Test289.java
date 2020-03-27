package leetcode.middle.test201To400;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2020-03-27
 * @time 14:36
 **/
public class Test289 {
    public static void main(String[] args) {
        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
    public static void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                int aliveNum = getAliveNum(board,newBoard,i,j,0);
                if (board[i][j]==1){
                    if (aliveNum<2){
                        board[i][j]=0;
                    }else if (aliveNum>3){
                        board[i][j]=0;
                    }
                }else {
                    if (aliveNum==3)board[i][j]=1;
                }

            }
        }
    }

    private static int getAliveNum(int[][] board, int[][] newBoard, int i, int j,int count) {
        if (i<0||j<0||i==board.length||j==board[0].length||count>1)return 0;
        if (count>0&&newBoard[i][j]==1)return 1;
        if (count>0&&newBoard[i][j]==0)return 0;
        int up = getAliveNum(board,newBoard ,i-1 ,j ,count+1);
        int down = getAliveNum(board,newBoard ,i+1 ,j ,count+1);
        int left = getAliveNum(board,newBoard ,i ,j-1 ,count+1);
        int right = getAliveNum(board,newBoard ,i ,j+1 ,count+1);
        int leftUp = getAliveNum(board,newBoard ,i-1 ,j-1 ,count+1);
        int leftDown = getAliveNum(board,newBoard ,i+1 ,j-1 ,count+1);
        int rightUp = getAliveNum(board,newBoard ,i-1 ,j+1 ,count+1);
        int rightDown = getAliveNum(board,newBoard ,i+1 ,j+1 ,count+1);
        return up+down+left+right+leftUp+leftDown+rightUp+rightDown;
    }
}
