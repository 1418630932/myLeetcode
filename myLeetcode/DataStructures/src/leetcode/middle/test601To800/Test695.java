package leetcode.middle.test601To800;

/**
 * @author zhuliyang
 * @date 2020-03-15
 * @time 15:17
 **/
public class Test695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (grid[i][j]==1){
                    max = Math.max(max,dye(grid,i,j) );
                }
            }
        }
        return max;
    }

    private int dye(int[][] grid, int i, int j) {
        if (i<0||i==grid.length||j<0||j==grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        return dye(grid,i-1 ,j )+dye(grid,i+1 ,j )+dye(grid,i ,j-1 )+dye(grid,i ,j+1 )+1;
    }
}
