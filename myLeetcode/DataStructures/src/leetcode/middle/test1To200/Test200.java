package leetcode.middle.test1To200;

/**
 * @author zhuliyang
 * @date 2020-03-12
 * @time 21:12
 **/
public class Test200 {
    public static void main(String[] args) {
    }
    public static int numIslands(char[][] grid) {
        int count =0;
        for (int i = 0; i <grid.length; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]=='1'){
                    count++;
                    dye(grid,i,j);//把岛屿变成水
                }
            }
        }
        return count;
    }
    //染色法
    private static void dye(char[][] grid, int i, int j) {
        if (i<0||i==grid.length||j<0||j==grid[0].length||grid[i][j]=='0')return;
        grid[i][j]=0;
        //四个方向染色 直到把岛屿从1染成0
        dye(grid,i+1 ,j );
        dye(grid,i-1 ,j );
        dye(grid,i ,j+1 );
        dye(grid,i ,j-1 );
    }
}
