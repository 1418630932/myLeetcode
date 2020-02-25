package Algorithm.sort;

import java.util.Random;

/**归并排序
 * @author zhuliyang
 * @date 2019-12-04
 * @time 21:26
 **/
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        mergetSort(arr,0,arr.length-1,new int[arr.length]);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时：" + (timeAfter - timeBefore) / 1000 + "秒");//2秒
       //System.out.println(Arrays.toString(arr));
    }

    public static void mergetSort(int[] arr ,int start,int end,int[] temp){
        if (start<end){
            int mid = (start+end)/2;
            mergetSort(arr,start ,mid ,temp );//向左递归分解 直到分解到单个元素 停止递归
            mergetSort(arr,mid+1 ,end ,temp );//向右递归分解 直到分解到单个元素 停止递归
            merget(arr, start, end, mid, temp);
        }
    }
    //合并元素 使之有序
    public static void merget(int[] arr ,int start,int end,int mid,int[] temp){
        //System.out.println(start+":"+end);
        int i = start;//数组左边
        int j =mid+1;//数组中间
        int t =0;
        //1 对左半边和右半边进行比较 然后把结果放入临时数组
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){//左边比右边小 把左边放入临时数组
                temp[t]=arr[i];
                t++;
                i++;
            }else {           //右边比左边小 把右边放入临时数组
                temp[t]=arr[j];
                t++;
                j++;
            }
        }
        //2 把剩余的元素放入数组
        while (i<=mid){//左边有剩余
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=end){//右边有剩余
            temp[t]=arr[j];
            t++;
            j++;
        }
        //3把排序好的结果放回原数组
        int index=0;
        while (start<=end){
            arr[start]=temp[index];
            start++;
            index++;
        }
    }
}
