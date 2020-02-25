package Algorithm.sort;

import java.util.Random;

/**
 * 选择排序
 * @author zhuliyang
 * @date 2019-12-17
 * @time 21:27
 **/
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        selectSort(arr);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时："+(timeAfter-timeBefore)/1000+"秒");//13秒
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
