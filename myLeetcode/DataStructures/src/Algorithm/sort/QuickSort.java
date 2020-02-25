package Algorithm.sort;

import java.util.Random;

/**
 * @author zhuliyang
 * @date 2019-12-04
 * @time 21:26
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时：" + (timeAfter - timeBefore) / 1000 + "秒");//3秒
//        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr ,int start,int end){
        if (start>=end){
            return;
        }
        int i =start ;
        int j =end;
        int base = arr[i];//基准值
        while (i!=j){
            while (base<=arr[j]&&i<j){
                j--;
            }
            while (base>=arr[i]&&i<j){
                i++;
            }
            int temp = arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
        arr[start]=arr[i];
        arr[i]=base;
        quickSort(arr,start ,i -1);
        quickSort(arr,j+1 ,end );
    }
}
