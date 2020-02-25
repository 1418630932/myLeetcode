package Algorithm.sort;

import java.util.Random;

/**
 * 冒泡排序
 * @author zhuliyang
 * @date 2019-12-16
 * @time 23:11
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        bubbleSort(arr);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时："+(timeAfter-timeBefore)/1000+"秒");//23秒
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {//最大的往后冒泡
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
