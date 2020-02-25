package Algorithm.recursion;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2019-12-16
 * @time 0:06
 **/
public class MiGong {
    public static void main(String[] args) {
        //绘制地图开始
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[3][5] = 1;
        map[5][5] = 1;
        //绘制地图结束
        //打印地图
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
        //开始走路
        setWay(map, 1, 1);
        //打印地图
        System.out.println("开始走路");
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 出发点 [1][1]  终点[6][5]
     * [i][j] = 0 表示没走过  [i][j] = 1 表示墙  [i][j] = 2 表示可以走  [i][j] = 3 表示该点已走过 但是走不通
     * 走迷宫策略  优先级：下->右->上->左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//表示结束了 找到了出口
            return true;
        }
        if (map[i][j] == 0) {//表示这个点没走过
            map[i][j] = 2;//假定他是可以走的路
            if (setWay(map, i + 1, j)) {//向下走可以走
                return true;
            } else if (setWay(map, i, j + 1)) {//向右走可以走
                return true;
            } else if (setWay(map, i - 1, j)) {//向上走可以走
                return true;
            } else if (setWay(map, i, j - 1)) {//向左走可以走
                return true;
            } else {//表示走不通
                map[i][j]=3;
                return false;
            }
        } else {//表示此路不可走
            return false;
        }
    }
}
