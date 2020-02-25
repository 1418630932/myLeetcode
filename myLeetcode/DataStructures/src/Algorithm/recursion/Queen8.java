package Algorithm.recursion;

import java.util.Arrays;

/**
 * @author zhuliyang
 * @date 2019-12-16
 * @time 15:40
 **/
public class Queen8 {
    static int length = 8;
    static int[] arr = new int[length];
    static int count =0;
    static int chenckcount =0;
    public static void main(String[] args) {
        putQueen(0);//从第0位开始放置
        System.out.println(count);
        System.out.println(chenckcount);
    }

    //放置第n排的皇后
    public static void putQueen(int n) {
        if (n == length) {//n=length表示递归的出口 表示皇后已经放置完毕
            print();
            return;
        }
        for (int i = 0; i < length; i++) {//本行的每个位置都做一次尝试
            arr[n]=i;//第n排 第i个位置 放置皇后
            if (check(n)) {//此位置是否可以放皇后？
                putQueen(n + 1);//可以放置 --》放置下一排的皇后
            }
        }
    }

    //验证第n排第i位置放皇后是否符合
    public static boolean check(int n) {
        chenckcount++;
        for (int j = 0; j < n; j++) {//和前面每行的皇后比较
            //两个皇后在同一列或者一个斜线上
            if (arr[j] == arr[n] || Math.abs(arr[j] - arr[n]) == Math.abs(j - n)) {
                return false;//此位置不可以放置
            }
        }
        return true;//此位置可以放皇后
    }

    //打印数组
    public static void print() {
        count++;
        System.out.println(Arrays.toString(arr));
    }
}
