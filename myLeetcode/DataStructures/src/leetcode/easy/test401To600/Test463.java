package leetcode.easy.test401To600;

/**
 * @author zhuliyang
 * @date 2020-02-16
 * @time 17:43
 **/
public class Test463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter  = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if (grid[i][j]==1){
                    perimeter+=4;
                    if(i-1>=0&&grid[i-1][j]==1){
                        perimeter--;
                    }
                    if(i+1<grid.length&&grid[i+1][j]==1){
                        perimeter--;
                    }
                    if(j-1>=0&&grid[i][j-1]==0){
                        perimeter--;
                    }
                    if(j+1>grid[i].length&&grid[i][j+1]==0){
                        perimeter--;
                    }
                }
            }
        }
        return perimeter;
    }
}
