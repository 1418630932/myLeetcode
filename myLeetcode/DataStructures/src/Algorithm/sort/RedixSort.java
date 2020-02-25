package Algorithm.sort;

import java.util.Random;

/**基数排序
 * @author zhuliyang
 * @date 2019-12-24
 * @time 23:28
 **/
public class RedixSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }
        Long timeBefore = System.currentTimeMillis();
        redixSort(arr);
        Long timeAfter = System.currentTimeMillis();
        System.out.println("总共耗时：" + (timeAfter - timeBefore) / 1000 + "秒");//0秒
       //System.out.println(Arrays.toString(arr));
    }
    public static void redixSort(int[] arr){
        int max = arr[0];
        for (int i : arr) {
            if (max<i){
                max=i;
            }
        }
        int length = (max+"").length();//最大数的长度 即最大数有几位 如：100-》3位，1000-》4位
        //创建二位数组
        int[][] buckets = new int[10][arr.length];
        //创建统计数组 用来统计二位数组上每个桶的元素个数
        int[] bucketsElementCount = new int[10];
        for (int i = 0; i <length ; i++) {//按照个位，十位，百位。。。。开始排序
            //数组元素放入桶
            for (int j = 0; j <arr.length ; j++) {
                int index = arr[j]/(int)Math.pow(10.0,i )%10;//得到对应的索引
                buckets[index][bucketsElementCount[index]++]=arr[j];
            }
            //桶中的元素放回数组
            int count = 0;
            for (int j = 0; j <buckets.length ; j++) {
                if (bucketsElementCount[j]!=0){
                    for (int k = 0; k <bucketsElementCount[j] ; k++) {
                        arr[count++]=buckets[j][k];
                    }
                }
                bucketsElementCount[j]=0;//初始化数组
            }
        }
    }
}
