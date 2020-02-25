package alibaba;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2019-12-01
 * @time 20:34
 **/
public class NintyArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=========================");
        int[][] afterChangeArr = change(arr);
        for (int[] ints : afterChangeArr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("=========================");
        int[][] change = change(afterChangeArr);
        for (int[] ints : change) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public static int[][] change(int[][] arr){
        int width=arr.length;
        int height=arr[0].length;
        int[][] newArr = new int[width][height];
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                newArr[j][height-1-i]=arr[i][j];
            }
        }
        return newArr;
    }
}
