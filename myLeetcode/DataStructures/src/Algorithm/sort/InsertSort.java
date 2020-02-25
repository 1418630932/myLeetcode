package Algorithm.sort;

import java.util.Random;

/**
 * 插入排序
 * @author zhuliyang
 * @date 2019-12-17
 * @time 21:49
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[200000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        insertSort(arr);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时："+(timeAfter-timeBefore)/1000+"秒");//6秒
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i <arr.length ; i++) {
            int insertValue = arr[i];//插入的值
            int insertIndex = i-1;//插入的索引
            while (insertIndex>=0&& insertValue<arr[insertIndex]){//如果插入的数要比比较的数小
                arr[insertIndex+1] = arr[insertIndex];//比较的数向后移动一位
                insertIndex--;//插入的索引向前移动一位
            }
            //走出循环表示找到了插入的索引前一位
            arr[insertIndex+1]=insertValue;//进行插入（值的覆盖）
        }
    }
}
