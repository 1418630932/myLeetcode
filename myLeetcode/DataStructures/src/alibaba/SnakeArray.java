package alibaba;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 20:24
 **/
public class SnakeArray {
    public static void main(String[] args) {
        int[][] snake = snake(5, 5, 8);
        for (int[] ints : snake) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static int[][] snake(int a,int b ,int startNum){
        int[][] newArr = new int[a][b];
        for (int i = 0; i <newArr.length ; i++) {
            for (int j = 0; j <newArr[i].length ; j++) {
                if (i%2==0){
                    newArr[i][j]=startNum++;
                }else {
                    newArr[i][newArr.length-j-1]=startNum++;
                }
            }
        }
        return newArr;
    }
}
