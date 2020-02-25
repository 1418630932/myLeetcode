package leetcode.middle.test1To200;

import java.util.Arrays;

public class Test79 {
    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'},};
        boolean abcced = exist(chars, "abfcseeda");
        System.out.println(abcced);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) return false;
        if (word.length() > board.length * board[0].length) return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {//找到每个起点  开始检验
                    boolean checkRes = check(board, isVisited, i, j, word, 1);
                    if (checkRes) return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, boolean[][] isVisited, int i, int j, String word, int length) {
        //越界/访问过/字符不相等返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ||isVisited[i][j] || board[i][j] != word.charAt(length - 1)) {
            return false;
        }
        if (length == word.length()) return true;//字符串长度匹配 返回true
        isVisited[i][j] = true;
        //四个方向探测  其中有一个方向探测成功 即匹配成功
        boolean res = check(board, isVisited, i + 1, j, word, length + 1)
                || check(board, isVisited, i - 1, j, word, length + 1)
                || check(board, isVisited, i, j + 1, word, length + 1)
                || check(board, isVisited, i, j - 1, word, length + 1);
        isVisited[i][j] = false;//回溯
        return res;
    }
}
