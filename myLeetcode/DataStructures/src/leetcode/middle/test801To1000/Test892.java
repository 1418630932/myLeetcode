package leetcode.middle.test801To1000;

/**
 * @author zhuliyang
 * @date 2020-03-25
 * @time 13:48
 **/
public class Test892 {
    public static void main(String[] args) {
        int i = surfaceArea(new int[][]{{1,2},{3,4}});
        System.out.println(i);
    }
    public static int surfaceArea(int[][] grid) {
        if (grid.length==0||grid[0].length==0)return 0;
        int area = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                int num = grid[i][j];
                if (num!=0){
                    area +=2;
                    area+=i-1<0?grid[i][j]:grid[i][j]-grid[i-1][j]<0?0:grid[i][j]-grid[i-1][j];
                    area+=j-1<0?grid[i][j]:grid[i][j]-grid[i][j-1]<0?0:grid[i][j]-grid[i][j-1];
                    area+=i+1==grid.length?grid[i][j]:grid[i][j]-grid[i+1][j]<0?0:grid[i][j]-grid[i+1][j];
                    area+=j+1==grid[0].length?grid[i][j]:grid[i][j]-grid[i][j+1]<0?0:grid[i][j]-grid[i][j+1];
                }
            }
        }
        return area;
    }
}
