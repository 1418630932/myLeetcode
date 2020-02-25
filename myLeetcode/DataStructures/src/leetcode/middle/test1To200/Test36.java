package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-02-20
 * @time 21:31
 **/
public class Test36 {
    public boolean isValidSudoku(char[][] board) {
        //记录某行数字的摆放情况
        boolean[][] rows = new boolean[9][9];
        //记录某列数字的摆放情况
        boolean[][] columns = new boolean[9][9];
        //记录某块数字的摆放情况
        boolean[][] blocks = new boolean[9][9];
        for (int i = 0; i <9 ; i++) {//行
            for (int j = 0; j <9 ; j++) {//列
                if (board[i][j]!='.'){//是数字
                    int blockIndex = i/3*3 + j/3; //求出属于第几块   （行/3）*3 +（列/3）
                    int index = board[i][j]-'1';
                    if (rows[i][index]||columns[j][index]||blocks[blockIndex][index]){//其中行/列/块 出现过这个数
                        return false;
                    }else {
                        rows[i][index] =true;
                        columns[j][index]=true;
                        blocks[blockIndex][index]=true;
                    }
                }
            }
        }
        return true;
    }
}
