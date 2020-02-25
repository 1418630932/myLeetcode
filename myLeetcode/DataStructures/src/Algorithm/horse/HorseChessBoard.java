package Algorithm.horse;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**马踏棋盘问题
 * @author zhuliyang
 * @date 2020-01-28
 * @time 23:00
 **/
public class HorseChessBoard {
    public static void main(String[] args) {
        X=8;
        Y=8;
        visited = new boolean[X][Y];
        int[][] chessboard = new int[X][Y];
        traversalChessboard(chessboard,2 , 1, 1);
        for (int[] ints : chessboard) {
            System.out.println(Arrays.toString(ints));
        }
    }
    private static int X;//棋盘的列
    private static int Y;//棋盘的行
    private static boolean[][] visited;//棋盘数组
    private static boolean finished;//是否全部访问完成标志

    /**
     * 马踏棋盘算法
     * @param chessboard 棋盘数组
     * @param row 行
     * @param column 列
     * @param step 第几步
     */
    public static void traversalChessboard(int[][] chessboard,int row,int column,int step){
        chessboard[row][column]=step;//记录步数
        visited[row][column]=true;//表示已经走过
        ArrayList<Point> next = next(new Point(row, column));//可以走的方位
        sort(next);//按照下一步的走法数量从小到大排序
        while (!next.isEmpty()){
            Point nextPoint = next.remove(0);
            if (!visited[nextPoint.x][nextPoint.y]){//当前格子没走过 递归走
                traversalChessboard(chessboard, nextPoint.x, nextPoint.y,step+1);
            }
        }
        if (step<X*Y&&!finished){ //不是最后一步 回溯
            chessboard[row][column]=0;
            visited[row][column]=false;
        }else {//是最后一步 改变全局变量的值用于递归的条件判断
            finished=true;
        }
    }
    //-------------------------->X
    //\    6  7
    //\ 5       0
    //\    马
    //\ 4       1
    //\    3  2
    //Y
    public static ArrayList<Point> next(Point curPoint){
        ArrayList<Point> points = new ArrayList<>();
        Point point = new Point();
        //可以移动到6
        if ((point.x=curPoint.x-1)>=0&&(point.y=curPoint.y-2)>=0){
            points.add(new Point(point));
        }
        //可以移动到7
        if ((point.x=curPoint.x+1)<X&&(point.y=curPoint.y-2)>=0){
            points.add(new Point(point));
        }
        //可以移动到5
        if ((point.x=curPoint.x-2)>=0&&(point.y=curPoint.y-1)>=0){
            points.add(new Point(point));
        }
        //可以移动到0
        if ((point.x=curPoint.x+2)<X&&(point.y=curPoint.y-1)>=0){
            points.add(new Point(point));
        }
        //可以移动到4
        if ((point.x=curPoint.x-2)>=0&&(point.y=curPoint.y+1)<Y){
            points.add(new Point(point));
        }
        //可以移动到1
        if ((point.x=curPoint.x+2)<X&&(point.y=curPoint.y+1)<Y){
            points.add(new Point(point));
        }
        //可以移动到3
        if ((point.x=curPoint.x-1)>=0&&(point.y=curPoint.y+2)<Y){
            points.add(new Point(point));
        }
        //可以移动到2
        if ((point.x=curPoint.x+1)<X&&(point.y=curPoint.y+2)<Y){
            points.add(new Point(point));
        }
        return points;
    }
    //按照point的下一步的走法有几种从小到大排序
    public static void sort(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size()-next(o2).size();
            }
        });
    }
}
